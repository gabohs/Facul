#include <iostream>
#include <fstream>

#include <string>

int main()
{   
    system("cls");

    // escrevendo em arquivo
    std::ofstream arqw("arquivos/teste.txt");
    arqw << "Hello, World!\n";

    arqw.close();

    return 0;
}