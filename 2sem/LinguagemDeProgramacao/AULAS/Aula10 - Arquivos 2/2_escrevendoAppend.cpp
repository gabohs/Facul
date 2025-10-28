#include <iostream>
#include <fstream>

#include <string>
#include <ios>

int main()
{
    // escrevendo em arquivo
    std::ofstream arqwa("arquivos/testeAp.txt", std::ios::app);
    arqwa << "Hello, World!\n";

    arqwa.close();

    return 0;
}