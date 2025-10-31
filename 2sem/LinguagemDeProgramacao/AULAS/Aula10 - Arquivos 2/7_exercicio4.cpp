#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <limits>

struct Informacao
{
    std::string anotacao;
    std::string categoria;
    int prioridade;
};

class ListaCSV
{
public:
    ListaCSV(const char* path) 
        : m_Arq(path, std::ios::app)
    {
    }

    ~ListaCSV()
    {
        m_Arq.close();
    }

    void addInformacao(const Informacao& info)
    {
        m_Info.push_back(info);
    }

    void escreveNoArquivo()
    {   
        if (m_Info.empty())
            return;

        for (const Informacao& info : m_Info)
        {
            m_Arq << info.anotacao << ",";
            m_Arq << info.categoria << ",";
            m_Arq << info.prioridade << "\n";
        }
    }

    const Informacao& lerInfo() const
    {
        Informacao nova;

        return nova;
    }

    void mostraTabela()
    {

    }

private:
    std::ofstream m_Arq;

    std::vector<Informacao> m_Info;
};

int main()
{   
    system("cls");

    const char* arquivoP = "arquivos/listacsv.csv";
    ListaCSV lista(arquivoP);

    char continuar;
    do 
    {   
        Informacao info;

        std::cout << "=================\n";
        std::cout << "CRIACAO DE NOVA INFORMACAO" << std::endl;

        std::cout << "Anotacao: ";
        std::getline(std::cin, info.anotacao);

        std::cout << "Categoria: ";
        std::cin >> info.categoria;

        std::cout << "Prioridade: ";
        std::cin >> info.prioridade;

        std::cout << "=================\n";

        lista.addInformacao(info);

        std::cout << "Deseja Continuar?: ";
        std::cin >> continuar;

        std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // para nao bugar o std::getline nas prox iteracoes
    } while (continuar == 's');

    lista.escreveNoArquivo();
}