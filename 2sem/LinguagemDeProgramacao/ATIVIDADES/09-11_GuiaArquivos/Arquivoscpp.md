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

- O constructor das funções para criar uma stream (e também a função open) aceitam um segundo argumento: std::ios_base::openmode. Ele é um bitmask que especifica o modo em que o arquivo será aberto. Esses modos definem o que podemos fazer com o arquivo.

#### Principais modos:

- `std::ios::in`: Permite que seja feita a leitura de um arquivo.

- `std::ios::out`: Permite escrever em um arquivo.

- `std::ios::app`: Append. Escrever no final do arquivo.

- `std::ios::trunc`: Os conteúdos são deletados ao abrir o arquivo.

- Como esse segundo argumento que pode ser especificado é um bitmask (ios_base::openmode), é possível definir várias flags ao mesmo tempo usando o operator bitwise OR (|):

```c++
std::fstream arq("oi.csv", std::ios::out | std::ios::in);
```

### Lidando com erros de abertura

- A função `is_open()` retorna um boolean que representa se o arquivo está ou não aberto. 
- Portanto, podemos verificar com um if se tudo ocorreu bem ao tentar abrir algum arquivo:

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

- Podemos usar o operador >> para ler até encontrar um espaço (ou seja, ler uma única palavra)

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

- Podemos usar a função `getline()` para ler uma linha inteira. Ou seja, ela lê até encontrar um caractere de nova linha '\n';

```c++
std::string linha;
while (std::getline(arq, linha))
{
    std::cout << linha << "\n";
}
``` 

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

## Header \<filesystem\>

- `std::filesystem::path p("path")`: representa um path para um arquivo

- `p.filename()`: retorna o nome do arquivo (com a extensão, inclusive)
- `p.extension()`: retorna apenas a extensão do arquivo
- `p.parent_path()`: retorna o diretório que contém o arquivo
- `p.relative_path()`: retorna o caminho relativo do arquivo
- `std::filesystem::absolute(p)`: retorna o caminho absoluto de p 
- `std::filesystem::file_size(p)`: retprma o tamanho  em bytes de p
  
- `std::filesystem::create_directory(dir)`: cria um único diretório no local desejado
- `std::filesystem::create_directories(dir)`: cria diretórios aninhados
- `std::filesystem::copy_file(a1, a2)`: copia a1 para a2
- `std::filesystem::exists(dir)`: retorna true se o arquivo/caminho existir
- `std::filesystem::is_directory(p)`: retorna true se p for um diretório
- `std::filesystem::is_regular_file(p)`: retorna true se p for um arquivo


## REFERÊNCIAS

- https://cppreference.com/
- https://www.studyplan.dev/pro-cpp/file-streams
- https://www.geeksforgeeks.org/cpp/file-system-library-in-cpp-17/