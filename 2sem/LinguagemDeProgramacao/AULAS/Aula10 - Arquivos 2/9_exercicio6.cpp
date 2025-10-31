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

void printMenu()
{
    std::cout << "============================\n";
    std::cout << "1. Ver anotacoes\n";
    std::cout << "2. Criar anotacao\n";
    std::cout << "3. Buscar uma anotacao\n";
    std::cout << "============================\n";
    std::cout << "O que deseja?: ";
}

void verAnotacoes()
{   
    std::ifstream arquivo("arquivos/listacsv.csv");

    int linhasCount = 0;
    std::string linha;
    Informacao info;

    while (std::getline(arquivo, linha))
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

    arquivo.close();
}   

void adicionarAnotacao()
{   
    std::ofstream arquivo("arquivos/listacsv.csv", std::ios::app);
    Informacao info;

    std::cout << "\n=================\n";
    std::cout << "CRIACAO DE NOVA INFORMACAO" << std::endl;

    std::cout << "Anotacao: ";
    std::getline(std::cin, info.anotacao);

    std::cout << "Categoria: ";
    std::cin >> info.categoria;

    std::cout << "Prioridade: ";
    std::cin >> info.prioridade;

    std::cout << "=================\n";

    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');

    arquivo << info.anotacao << ",";
    arquivo << info.categoria << ",";
    arquivo << info.prioridade << "\n";

    arquivo.close();
}

void buscarAnotacao()
{
    std::ifstream arquivo("arquivos/listacsv.csv");

    

    arquivo.close();
}

int main()
{
    printMenu();
    int opcao;

    std::cin >> opcao;

    if (opcao < 1 || opcao > 3)
    {
        std::cout << "Opcao invalida!\n";
        return -1;
    }

    switch (opcao)
    {
        case 1:
            verAnotacoes();
            break;

        case 2:
            adicionarAnotacao();
            break;

        case 3:
            buscarAnotacao();
        
        default:
            break;
    }

    return 0;
}