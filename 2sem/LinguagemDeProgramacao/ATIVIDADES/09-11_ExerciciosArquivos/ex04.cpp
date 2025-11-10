#include <iostream>
#include <fstream>
#include <filesystem>
#include <ios>

#include <vector>

/*
Conte quantas extensões diferentes a pasta atual possui.
*/

bool estaNoVetor(const std::vector<std::filesystem::path>& vec, std::filesystem::path elemento)
{
    if (vec.empty())
        return;

    for (const std::filesystem::path& cElem : vec)
    {
        if (cElem.extension() == elemento.extension())
            return true;
    }

    return false;
}

int main()
{   
    system("cls");

    std::filesystem::path pAtual( std::filesystem::current_path() );

    std::vector<std::filesystem::path> extensoes;

    for (const std::filesystem::path& p : std::filesystem::directory_iterator(pAtual))
    {
        if (std::filesystem::is_regular_file(p))
        {
            if (estaNoVetor(extensoes, p))
            {

            }
        }
        
    }

    return 0;
}