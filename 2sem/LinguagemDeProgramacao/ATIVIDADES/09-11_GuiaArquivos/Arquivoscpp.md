# Funções de acesso a arquivos em C++

- Gabriel H. Schaeffer

---

## Header \<fstream\>

```c++
#include <fstream>
```

### Criando streams

- `std::ofstream`: Stream de **output**. Permite escrever em um arquivo.

- `std::ifstream`: Stream de **input**. Permite ler o conteúdo de um arquivo.

- `std::fstream`: É a junção das duas anteriores. Permite ler e escrever.

### Abrindo e fechando arquivos

```c++
std::ofstream arqw("testeW.txt");
std::ifstream arqr("testeR.txt");
std::fstream arq("teste.txt");
```

- O constructor padrão das funções acima constrói um objeto não associado a nenhum arquivo. Portanto, é perfeitamente válido escrever:

```c++
std::fstream arq;
```

e depois associar a este objeto um arquivo:

```c++
arq.open("teste.txt");
```

- Para fechar um arquivo, usamos:

```c++
arq.close();
```

### Modos de abrir

- O constructor das funções para criar uma stream (e também a função open) aceitam um segundo argumento: std::ios_base::openmode. Ele é um bitmask especifica o modo em que o arquivo será aberto. Esses modos definem o que podemos fazer com o arquivo.

#### Principais modos:

- `std::ios::in`: Permite que seja feita a leitura de um arquivo.

- `std::ios::out`: Permite escrever em um arquivo.

- `std::ios::app`: Append. Escrever no final do arquivo.

- `std::ios::trunc`: Os conteúdos são deletados ao abrir o arquivo.

- Como o constructor das funções recebe um bitmask, é possível definir várias flags ao mesmo tempo, como:

```c++
std::fstream arq("oi.csv", std::ios::out | std::ios::in);
```

### Lidando com erros de abertura

- A função `is_open()` retorna um boolean que representa se o arquivo está ou não aberto. 
- Portanto, podemos verificar com um if:

```c++
if (!arq.is_open())
    std::cout << "Não foi possível abrir o arquivo!\n";
```

### Escrevendo em um arquivo

- Dada a stream

```c++
std::ofstream arqw("arquivo.txt");
```

- Podemos escrever usando o operador <<

```c++
arqw << "Hello, World!\n";
```

- E não pode-se esquecer de fechar o arquivo no final:

```c++
arqw.close();
```

#### Resultado:

![output](image.png)

### Lendo de um arquivo

- Agora vamos ler o arquivo.txt com o hello, world que geramos.

- Dada a stream:

```c++
std::ifstream arqr("arquivo.txt");
```

- Podemos usar o operador >> para ler até encontrar um espaço

```c++
 std::string texto1, texto2;

    arqr >> texto1; // lê ate encontrar um espaco 
    arqr >> texto2;
```

- Se fizermos:

```c++
std::cout << texto1 << texto2;
```

> Output:
> 
> \> Hello,World!

- Podemos usar a função `getline()` para ler uma linha inteira. Ou seja, ela lê até encontrar um caractere de nova linha "\n";

```c++
std::string linha;
std::getline(arqr, linha);

arqr.close();

std::cout << linha << "\n";
```

> Output:
> 
> \> Hello, World!

Podemos usar a função `get()` para extrair um caractere.

```c++
std::ifstream arqtest("arquivos/teste.txt");

char c = arqtest.get();
std::cout << c << "\n";

arqtest.close();
```

> Output:
> 
> \> H

- A função get() retorna um int, e se a variável c do exemplo acima fosse declarada como um inteiro, o output seria '72', que é o código para 'H' na tabela ASCII.

### Acessando e Lendo posições específicas

- `tellp()`: retorna a posição atual do "cursor"
- `seekp(<nova_posicao>)`: move o "cursor" para a nova posição

---

Outra função relevante é a `eof()`, que retorna true quando o final do arquivo for atingido. Útil para usar em loops. Exemplo:

```c++
std::string palavra;
while (!arq.eof())
{
    arq >> palavra; 
    std::cout << palavra;
}
```