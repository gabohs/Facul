#include <iostream>
#include <fstream>
#include <filesystem>
#include <ios>

/*
Conte quantos arquivos e quantas pastas o caminho atual possui
*/

int main()
{   
    system("cls");

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

    std::cout << "Arquivos:   " << arquivos << "\n";
    std::cout << "Diretorios: " << dirs << "\n";

    return 0;
}