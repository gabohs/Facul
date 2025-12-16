#include <iostream>
#include <fstream>
#include <filesystem>
#include <ios>

// Peça para o usuário digitar uma pasta/caminho. Liste os arquivos da pasta.

int main()
{   
    system("cls");

    std::string path;

    std::cout << "Digite o caminho do arquivo\n";
    std::cin >> path;

    if (!std::filesystem::exists(path))
    {
        std::cerr << "Diretório não existe\n";
        return -1;
    }

    if (!std::filesystem::is_directory(path))
    {
        std::cerr << "O caminho especificado não é um diretório\n";
        return -1;
    }

    std::cout << "============= DIRETORIOS =============\n";
    for (const std::filesystem::path& p : std::filesystem::directory_iterator(path))
    {
        std::cout << p.filename() << "\n";
    }
    std::cout << "======================================\n";

    return 0;
}