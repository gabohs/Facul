#include <iostream>
#include <fstream>
#include <filesystem>
#include <ios>

/*
Crie um arquivo de texto com <fstream> e use <filesystem> para mostrar:

Nome do arquivo
Extensão do arquivo
Tamanho do arquivo em bytes
Caminho absoluto do arquivo
*/

int main()
{   
    system("cls");

    std::ofstream arquivo("arquivo.txt", std::ios::app);
    std::filesystem::path pArq("arquivo.txt");
    
    std::cout << "Nome:             " << pArq.filename() << "\n";
    std::cout << "Extensao:         " << pArq.extension() << "\n";
    std::cout << "Caminho absoluto: " << std::filesystem::absolute(pArq) << "\n";

    arquivo.close();

    std::cout << "Tamanho (bytes):  " << std::filesystem::file_size(pArq) << "\n";

    return 0;
}