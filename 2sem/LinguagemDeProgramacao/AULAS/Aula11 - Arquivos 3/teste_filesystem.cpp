#include <iostream>
#include <filesystem>
#include <fstream>

int main()
{   
    system("cls");

    std::filesystem::path p("arquivos");
    std::filesystem::create_directory(p);

    std::ofstream arq("arquivos/ric.txt");
    std::filesystem::path pRic("arquivos/ric.txt");

    std::cout << p.filename() << "\n";
    std::cout << pRic.filename() << "\n";
    std::cout << pRic.extension() << "\n";
    std::cout << pRic.parent_path() << "\n";
    std::cout << pRic.relative_path() << "\n";

    std::cout << "Caminho absoluto: " << std::filesystem::absolute(pRic) << "\n";

    arq << "Ric Zanoni cara do momento\n";

    arq.close();

    std::cout << std::filesystem::file_size(pRic) << "\n";

    return 0;
}