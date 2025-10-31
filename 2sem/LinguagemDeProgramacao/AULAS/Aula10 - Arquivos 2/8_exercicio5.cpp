#include <iostream>
#include <fstream>
#include <string>

#include <iomanip>

struct Informacao
{
    std::string anotacao;
    std::string categoria;
    int prioridade;  
};

int main()
{   
    system("cls");

    std::ifstream arq("arquivos/listacsv.csv");

    int linhasCount = 0;
    std::string linha;
    Informacao info;

    while (std::getline(arq, linha))
    {
        int fim_anot = linha.find(',');
        int fim_cat = linha.rfind(',');

        info.anotacao = linha.substr( 0, fim_anot );
        info.categoria = linha.substr( fim_anot + 1, fim_cat - fim_anot - 1 );
        info.prioridade = std::stoi( linha.substr(fim_cat + 1, 1) );
        
        std::cout << std::left << std::setw(7) << ++linhasCount
                  << std::setw(7) << info.prioridade
                  << std::setw(10) << info.categoria
                  << "\t" << info.anotacao << "\n";
    }

    arq.close();

    return 0;
}