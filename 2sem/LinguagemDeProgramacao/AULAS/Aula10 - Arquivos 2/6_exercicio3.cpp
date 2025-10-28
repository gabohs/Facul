#include <iostream>
#include <fstream>

#include <string>

struct arqInfo
{
    arqInfo(std::string path)
        : m_Path(path), m_Arq(path)
    {
        if (!m_Arq.is_open())
            exit(-1);

        getInfo();
    }

    void getInfo()
    {
        char c;
        while (!m_Arq.eof())
        {   
            c = m_Arq.get();

            if (c == '\n')
                quantLinhas++;
            else if (c == ' ')
                quantEspacos++;
            else if (c == ',')
                quantVirgs++;
            else if (isalnum(c))
                quantValidos++;
        }
    }

    std::string m_Path;
    std::ifstream m_Arq;

    int quantLinhas  = 0;
    int quantEspacos = 0;
    int quantVirgs   = 0; 
    int quantValidos = 0;
};

int main()
{   
    system("cls");

    std::string pathArq;
    std::cout << "Caminho do Arquivo: ";
    std::cin >> pathArq;

    std::ifstream arq(pathArq); 

    arqInfo arq1(pathArq);

    std::cout << "QUANT. LINHAS:   " << arq1.quantLinhas << "\n";
    std::cout << "QUANT. ESPACOS:  " << arq1.quantEspacos << "\n";
    std::cout << "QUANT. VIRGULAS: " << arq1.quantVirgs << "\n";
    std::cout << "QUANT. VALIDOS:  " << arq1.quantValidos << "\n";

    arq.close();

    return 0;
}