#include <iostream>
#include <fstream>
#include <string>

int main()
{
    std::ofstream arqn("arquivos/navegando.txt");
    
    arqn.seekp(12);

    arqn << "Hello, World";

    return 0;
}