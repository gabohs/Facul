#include <iostream>
#include <fstream>

#include <string>

int main()
{
    // lendo de arquivo
    std::ifstream arqr("arquivos/leitura.txt");
    
    std::string texto1, texto2;

    arqr >> texto1; // lê ate encontrar um espaco 
    arqr >> texto2;

    std::cout << texto1 << texto2 << "\n";

    arqr.close();

    // ---------------------------------------------------------

    std::ifstream arql("arquivos/teste.txt");

    std::string linha;
    std::getline(arql, linha);

    arql.close();

    std::cout << linha << "\n";

    // ---- -------------------------------------------------------
    
    std::ifstream arqtest("arquivos/teste.txt");

    char c = arqtest.get();
    std::cout << c << "\n";

    arqtest.close();

    return 0;
}