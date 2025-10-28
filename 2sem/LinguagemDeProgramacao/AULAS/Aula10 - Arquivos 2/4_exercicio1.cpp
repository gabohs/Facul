#include <iostream>
#include <fstream>
#include <string>

/* EXERCICIO
escrever uma string n vezes em um arquivo
*/

int main()
{   
    int n;
    std::cin >> n;

    std::ofstream arq("arquivos/exercicio1.txt");
    std::string frase = "Hello, World";
    
    for (int i = 0; i < n; i++)
    {
        arq << frase << "\n";
    }

    arq.close();

    return 0;
}