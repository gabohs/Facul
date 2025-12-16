# RESUMO - Prova I

## Strings 

### Strings em C

```C
char s[] = "Cplus"; // 6 bytes -> char[] + '\0'
```

#### `strlen(char* str)` - O(n)

```C
int len = strlen(s); // retorna 5 nesse caso, percorre todo o array até encontrar o '\0'
```

#### `strcpy(char* string, const char* string2)` - O(n)

```C
char dest[10];
strcpy(dest, s); // copia s para dest. Não verifica tamanho do buffer de destino (insegura)
```

#### `strcat(char* string1, char* string2)` - O(L1 + L2) L: length

```C
char sFinal[32];
strcat(sFinal, "Hello"); // concatena string 
strcat(sFinal, ", "); // tambem nao verifica os limites; pode ser insegura
strcat(sFinal, "World");
// sFinal -> Hello, World
```

#### `strcmp(const char* string1, const char* string2)` - O(k) k: shorter string

- Retorna um int que é positivo se a string1 for maior que a string2; negativo se a string2 for maior, e 0 se forem iguais

```C
char s1[] = "Oi";
char s2[] = "Oi";
char s3[] = "Hello";

std::cout << strcmp(s1, s2) << "\n"; // compara as strings lexicograficamente
std::cout << strcmp(s1, s3) << "\n";
```

### std::string (c++)

```c++
std::string s = "Hello"; 
```

#### Funções:

- As funções de strings em C apresentadas acima possuem operadores equivalentes em std::string

- `std::string& append(const std::string& str)`: concatena no final

- `char& at(size_t pos)`: equivalente ao operador [], mas verifica os limites

- `char& back()` e `char& front()`- O(1): retornam uma referencia ao ultimo char da string e ao primeiro, respectivamente (se a string for const retorna const char&), dai n pode alterar

- `int compare(const string& str)`: compara lexicograficamente duas strings

- `bool empty() const`: retorna true se a string esta vazia

- `std::string& erase(size_t pos = 0, size_t len = npos)`: apaga *len* caracteres comecando de *pos* 

- `size_t find (const std::string& str, size_t pos = 0) const`: procura a partir de *pos*

- `size_t rfind (const std::string& str, size_t pos = npos) const;`: procura a partir do final por padrao

- `std::string& insert (size_t pos, const std::string& str)`: insere na string logo antes de *pos*

- `void pop_back()`: remove o ultimo character da string

- `void push_back (char c)`: insere *c* no final da string

- `std:: string& replace (size_t pos,  size_t len,  const std::string& str)`: substitui *len* caracteres por *str* comecando de *pos*

- `std::string substr (size_t pos = 0, size_t len = npos) const`: retorna uma substring de length() *len* comecando a partir da posicao *pos* da string original

- `void swap (std::string& str);`: troca o objeto string atual por *str* e *str* pela string

- `void resize (size_t n)`: redimensiona a string. Novo tamanho: *n*

#### Exemplo:

```c++
const std::string achaPrimeiroNome(const std::string nome)
{
    return nome.substr( 0, nome.find(" ") );
}

const std::string achaUltimoSobrenome(const std::string nome)
{
    return nome.substr( nome.rfind(" ") + 1, nome.length() );
}

const std::string inverteNome(const std::string nome)
{
    std::string invertido = "";
    for (int i = nome.length() - 1; i >= 0; i--)
        invertido += nome.at(i);
    return invertido;
}
```

## Arquivos

### Abrindo e fechando arquivos

```c++
std::ofstream arqw("testeW.txt");
std::ifstream arqr("testeR.txt");
std::fstream arq("teste.txt");
```

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

- Como esse segundo argumento que pode ser especificado é um bitmask (ios_base::openmode), é possível definir várias flags ao mesmo tempo usando o operator bitwise OR (|):```c++
std::fstream arq("oi.csv", std::ios::out | std::ios::in);

### Lidando com Erros de Abertura

```c++
if (!arq.is_open())
    std::cout << "Não foi possível abrir o arquivo!\n";
```

### Escrevendo em um arquivo

- Dada a stream

```c++
std::ofstream arqw("arquivo.txt");
```

```c++
arqw << "Hello, World!\n";
```

### Lendo de um arquivo

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

### Alguns Exemplos

```c++
void getInfo()
{
    char c;
    while (!m_Arq.eof())
    {   
        c = m_Arq.get();

        if (c == '\n')
            quantLinhas++;
        else if (c == ' ')
            quantEspacos++;
        else if (c == ',')
            quantVirgs++;
        else if (isalnum(c))
            quantValidos++;
    }
}
```

```c++
// Exercício 4: usuário escreve anotação, categoria e prioridade,
// programa salva (append) as informações separadas por vírgula (arquivo.csv)
struct Anotacao
{
    string descricao,categoria;
    int prioridade;
};

int main()
{
	Anotacao nova;
	cout << "Digite a descricao da nota: ";
	getline(cin,nova.descricao);
	cout << "Digite a categoria da nota (casa, trabalho, lazer, pessoal): ";
	cin >> nova.categoria;
	cout << "Digite a prioridade da nota (1 a 5): ";
	cin >> nova.prioridade;

	ofstream File("bloco.csv",ios::app);
	File << nova.descricao << ',' << nova.categoria << ',' << nova.prioridade << endl;
	File.close();
}
```

```c++
// Exercício 5: Fazer a leitura de um arquivo .csv e mostrar cada entrada em uma tabela formatada
	// nro_linha	prioridade		categoria		descrição
struct Anotacao
{
    string descricao,categoria;
    int prioridade;
};

int main()
{
    Anotacao teste;
    ifstream csv("bloco.csv");
    cout << setw(7)<< "Ordem"<<setw(7)<<"Prio."<<setw(10)<<"Categoria"<<"\tDescricao"<<endl;

    int num = 0;
    string linha;

    while (getline(csv,linha))
    {
		int fim_desc = linha.find(',');
		int fim_cat = linha.rfind(',');
		teste.descricao = linha.substr(0,fim_desc);
		teste.categoria = linha.substr(fim_desc+1,fim_cat-fim_desc-1);
		teste.prioridade = stoi(linha.substr(fim_cat+1,1));
		cout << setw(7) << ++num
			<< setw(7) << teste.prioridade
			<< setw(10) << teste.categoria
			<< "\t" << teste.descricao <<endl;
    }
    csv.close();
}
```

### Header \<filesystem\>

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

- Exemplos:

```c++
std::filesystem::path p("arquivos");
std::filesystem::create_directory(p);

std::ofstream arq("arquivos/ric.txt");
std::filesystem::path pRic("arquivos/ric.txt");

std::cout << p.filename() << "\n";             // out: "arquivos"
std::cout << pRic.filename() << "\n";          // out: "ric.txt"
std::cout << pRic.extension() << "\n";         // out: ".txt"
std::cout << pRic.parent_path() << "\n";       // out: "arquivos"
std::cout << pRic.relative_path() << "\n";     // out: "arquivos/ric.txt"

std::cout << std::filesystem::absolute(pRic) << "\n"; // out: "C:\\Facul\\2sem\\LinguagemDeProgramacao\\AULAS\\Aula11 - Arquivos 3\\arquivos\\ric.txt"

arq << "Ric Zanoni cara do momento\n";

arq.close();

std::cout << std::filesystem::file_size(pRic) << "\n"; // out: 28
```

```c++
std::ofstream arquivo("arquivo.txt", std::ios::app);
std::filesystem::path pArq("arquivo.txt");

std::cout << "Nome:             " << pArq.filename() << "\n";
std::cout << "Extensao:         " << pArq.extension() << "\n";
std::cout << "Caminho absoluto: " << std::filesystem::absolute(pArq) << "\n";

arquivo.close();

std::cout << "Tamanho (bytes):  " << std::filesystem::file_size(pArq) << "\n";
```

```c++
// Peça para o usuário digitar uma pasta/caminho. Liste os arquivos da pasta.

std::string path;

std::cout << "Digite o caminho do arquivo\n";
std::cin >> path;

if (!std::filesystem::exists(path))
    return -1; // diretorio n existe
if (!std::filesystem::is_directory(path))
    return -1; // caminho nao eh diretorio

for (const std::filesystem::path& p : std::filesystem::directory_iterator(path))
{
    std::cout << p.filename() << "\n";
}
```

```c++
// Conte quantos arquivos e quantas pastas o caminho atual possui
std::filesystem::path pAtual( std::filesystem::current_path() );

int arquivos = 0;
int dirs     = 0;

for (const std::filesystem::path& p : std::filesystem::directory_iterator(pAtual))
{
    if (std::filesystem::is_regular_file(p))
        arquivos++;
    else if (std::filesystem::is_directory(p))
        dirs++;
}
```

```c++
// Conte quantas extensões diferentes a pasta atual possui.

bool estaNoVetor(const std::vector<std::string>& vec, const std::string& elemento)
{
    for (const auto& cElem : vec)
        if (cElem == elemento)
            return true;
    return false;
}

int main()
{
    std::filesystem::path atual( std::filesystem::current_path() );
    std::vector<std::string> extensoes;

    for (const std::filesystem::path& p : std::filesystem::directory_iterator(atual))
    {
        if (std::filesystem::is_regular_file(p))
        {
            std::string ext = p.extension().string();

            if (!ext.empty() && !estaNoVetor( extensoes, ext ))
                extensoes.push_back( ext );
        }
    }

    std::cout << "Foram encontradas " << extensoes.size() << " extensoes diferentes no diretorio atual:\n";
    for (const auto& ext : extensoes)
        std::cout << ext << '\n';
}
```

```c++
// Conte quantos arquivos de cada tipo de extensão a pasta atual possui.
std::filesystem::path atual( std::filesystem::current_path() );
std::map<std::string, int> contadorExtensoes;

for (const std::filesystem::path& p : std::filesystem::directory_iterator(atual))
{
    if (std::filesystem::is_regular_file(p))
    {
        std::string ext = p.extension().string();

        contadorExtensoes[ext]++;
    }
}
std::cout << "Foram encontradas " << contadorExtensoes.size() << " extensoes diferentes no diretorio atual:\n";

for (const auto& [extensao, quantidade] : contadorExtensoes)
{
    std::cout << extensao << " | " << quantidade << '\n';
}
```

## Recursividade

A recursividade é uma forma de resolver um caso complexo dividindo-o em casos mais simples. No contexto da programação, uma recursão é caracterizada por uma função realizando uma chamada para ela mesma. 

Para que isso funcione, é preciso definir um caso base na função, garantindo que exista uma condição de parada, evitando que a recursividade ocorra até acontecer um stack overflow.

 Exemplo de função recursiva que realiza a operação matemática de potenciação:

```c++
int potencia(int base, int expoente)
{
    if (expoente == 0) // caso base
        return 1; 

    return base * potencia(base, expoente - 1)
}
```
Supondo que:

base = 5; expoente = 3;

A funçao irá ser executada da seguinte maneira:

potencia(5, 3)
   5 * potencia(5, 2)
       5 * potencia(5, 1)
           5 * potencia(5, 0)
               1

No final fica: 

5 * 5 * 5 * 1

Que retorna o resultado correto: 125

## Algos de Ordenacao

### Bubble Sort 

- Pior caso (array invertido): $O(n^2)$
- Caso médio: $O(n^2)$
- Melhor caso (array já ordenado): $O(n)$
- Espaço extra: $O(1)$
- Bom para arrays já quase ordenados e para fins didáticos

```c++
void bubbleSort(std::vector<int>& vec)
{   
    bool trocou;

    for (int i = 0; i < vec.size() - 1; i++)
    {
        trocou = false;

        for (int j = 0; j < vec.size() - 1 - i; j++)
        {
            if (vec[i] > vec[j])
            {   
                int temp = vec[i];
                vec[i] = vec[j];
                vec[j] = temp;

                trocou = true;
            }
            
            if (!trocou)
                break;
        }
    }
}
```

### Selection Sort

- Pior caso: $O(n^2)$
- Caso médio: $O(n^2)$
- Melhor caso (array já ordenado): $O(n^2)$
- Espaço extra: $O(1)$
- Bom quando você quer o menor número de trocas (swaps). Util em sistemas embarcados com writes caros, como EEPROM, Flash...

```c++
void selectionSort(std::vector<int>& vec)
{
    int menor;

    for (int i = 0; i < vec.size(); i++)
    {
        menor = i;

        for (int j = i + 1; j < vec.size(); j++)
        {
            if (vec[j] < vec[menor])
                menor = j;
        }

        if (i != menor)
        {
            int temp = vec[i];
            vec[i] = vec[menor];
            vec[menor] = temp;
        }
    }
}
```

### Insertion Sort

- Pior caso (array invertido): $O(n^2)$
- Caso médio: $O(n^2)$
- Melhor caso (array já ordenado): $O(n)$
- Espaço extra: $O(1)$
- Bom quando os dados já estão quase ordenados e para listas pequenas

```c++
void insertionSort(std::vector<int>& vec)
{
    for (int i = 1; i < vec.size(); i++)
    {
        for (int j = i; (j > 0) && (vec[j - 1] > vec[j]); j--)
        {
            int temp = vec[j];
            vec[j] = vec[j - 1];
            vec[j - 1] = temp;
        }
    }
}
```

### Quick Sort

- Pior caso (array já ordenado ou invertido): $O(n^2)$
- Caso médio (pivos aleatorios): $O(n \ log \ n)$
- Melhor caso (pivo divide o array igualmente): $O(n \ log \ n)$
  
- Espaço extra (melhor e medio): $O(log n)$
- Expaco extra (pior)? $O(n)$

```c++
// Quick sort lomuto partition
int partition(std::vector<int>& arr, int low, int high) 
{
    int pivot = arr[high]; // Choosing the last element as pivot
    int i = (low - 1);     // Index of smaller element

    for (int j = low; j <= high - 1; j++) 
    {
        // If current element is smaller than or equal to pivot
        if (arr[j] <= pivot) 
        {
            i++; // Increment index of smaller element
            std::swap(arr[i], arr[j]);
        }
    }
    std::swap(arr[i + 1], arr[high]);
    return (i + 1);
}

// Main Quicksort function
void quickSort(std::vector<int>& arr, int low, int high) 
{
    if (low < high) 
    {
        // pi is partitioning index, arr[pi] is now at right place
        int pi = partition(arr, low, high);

        // Separately sort elements before partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```

### Merge Sort

- Pior caso (merge sort é imune a pivos ruins pois sempre divide pela metade): $O(n \ log \ n)$
- Caso médio: $O(n \ log \ n)$
- Melhor caso: $O(n \ log \ n)$
  
- Espaço extra: $O(n)$

```c++
void merge(std::vector<int>& arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    // Create temporary arrays
    std::vector<int> L(n1);
    std::vector<int> R(n2);

    // Copy data to temporary arrays L[] and R[]
    for (int i = 0; i < n1; ++i)
        L[i] = arr[left + i];

    for (int j = 0; j < n2; ++j)
        R[j] = arr[mid + 1 + j];

    // Merge the temporary arrays back into arr[left..right]
    int i = 0;      // Initial index of first subarray
    int j = 0;      // Initial index of second subarray
    int k = left;   // Initial index of merged subarray

    while (i < n1 && j < n2) 
    {
        if (L[i] <= R[j]) 
        {
            arr[k] = L[i];
            i++;
        } 
        else 
        {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    // Copy the remaining elements of L[], if any
    while (i < n1) 
    {
        arr[k] = L[i];
        i++;
        k++;
    }

    // Copy the remaining elements of R[], if any
    while (j < n2)
    {
        arr[k] = R[j];
        j++;
        k++;
    }
}

// Main Merge Sort function
void mergeSort(std::vector<int>& arr, int left, int right) 
{
    if (left < right) 
    {
        // Find the middle point
        int mid = left + (right - left) / 2;

        // Sort first and second halves
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Merge the sorted halves
        merge(arr, left, mid, right);
    }
}
```