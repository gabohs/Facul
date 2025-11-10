#include <iostream>
#include <filesystem>
#include <vector>

// Conte quantas extensões diferentes a pasta atual possui.

bool estaNoVetor(const std::vector<std::string>& vec, const std::string& elemento)
{
    for (const auto& cElem : vec)
    {
        if (cElem == elemento)
            return true;
    }
    return false;
}

int main()
{
    system("cls"); 

    std::filesystem::path atual( std::filesystem::current_path() );
    std::vector<std::string> extensoes;

    for (const std::filesystem::path& p : std::filesystem::directory_iterator(atual))
    {
        if (std::filesystem::is_regular_file(p))
        {
            std::string ext = p.extension().string();

            if (!ext.empty() && !estaNoVetor( extensoes, ext ))
                extensoes.push_back( ext );
        }
    }

    std::cout << "Foram encontradas " << extensoes.size() << " extensoes diferentes no diretorio atual:\n";
    for (const auto& ext : extensoes)
    {
        std::cout << ext << '\n';
    }
        
    return 0;
}
