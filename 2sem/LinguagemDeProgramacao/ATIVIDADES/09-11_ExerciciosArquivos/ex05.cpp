#include <iostream>
#include <filesystem>
#include <vector>

#include <map>

// Conte quantos arquivos de cada tipo de extensão a pasta atual possui.

int main()
{   
    system("cls");

    std::filesystem::path atual( std::filesystem::current_path() );
    std::map<std::string, int> contadorExtensoes;

    for (const std::filesystem::path& p : std::filesystem::directory_iterator(atual))
    {
        if (std::filesystem::is_regular_file(p))
        {
            std::string ext = p.extension().string();

            contadorExtensoes[ext]++;
        }
    }

    std::cout << "Foram encontradas " << contadorExtensoes.size() << " extensoes diferentes no diretorio atual:\n";

    std::cout << "EXTENSAO" << " | " << "QUANTIDADE\n";

    for (const auto& [extensao, quantidade] : contadorExtensoes)
    {
        std::cout << extensao << " | " << quantidade << '\n';
    }

    return 0;
}