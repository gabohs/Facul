#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
#include <ios>

struct Informacao
{
    std::string anotacao;
    std::string categoria;
    int prioridade;  
};

int printMenu()
{
    int operacao;
    system("cls");

    std::cout << "1) Ver anotacoes " << "\n"
              << "2) Criar anotacao " << "\n";


    return operacao;
}

int main()
{
    std::fstream arq("arquivos/lendo_escrevendo.csv", std::ios::app | std::ios::in);

    int op; 
    do 
    {
        int op = printMenu();

        switch(op)
        {
            case 1:
                Informacao info;
                break;
        }


    } while (op != 4);

    return 0;
}