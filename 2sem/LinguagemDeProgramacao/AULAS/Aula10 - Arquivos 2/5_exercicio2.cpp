#include <iostream>
#include <fstream>

#include <string>

int main()
{   
    system("cls");

    std::string pathArq;
    std::cout << "Caminho do Arquivo: ";
    std::cin >> pathArq;

    std::ifstream arq(pathArq, std::ios::in);

    if (!arq.is_open())
        return -1;

    std::cout << "\nFORMA 1:\n";
    // forma 1: linha a linha

    std::string linha;
    while (std::getline(arq, linha))
    {
        std::cout << linha << "\n";
    }

    std::cout << "\nFORMA 2:\n";
    // forma 2: leitura palavra a palavra

    std::string palavra;
    while (!arq.eof())
    {
        arq >> palavra;
        std::cout << palavra;
    }

    std::cout << "\nFORMA 3:\n";
    // forma 3: letra a letra
    
    std::string letra;
    while (!arq.eof())
    {
        std::cout << (char)arq.get();
    }

    arq.close();

    return 0;
}