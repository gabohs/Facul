#include <iostream>
#include <fstream>

#include <string>

int main()
{
    // lendo de arquivo
    std::ifstream arqr("arquivos/teste.txt");
    
    std::string texto1, texto2;

    arqr >> texto1; // lê ate encontrar um espaco 
    arqr >> texto2;

    std::cout << texto1; //<< texto2;

    // ---------------------------------------------------------

    std::ifstream arql("arquivos/leitura.txt");


    return 0;
}