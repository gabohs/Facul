/*
Implemente um programam que crie um arquivo com uma lista de tarefas. Cada tarefa deve ter: 
    - descricao, categoria (casa, trabalho, ...), prioridade (1 a 5)
*/

#include <fstream>
#include <iostream>
#include <vector>

struct Tarefa
{
    std::string descricao;
    std::string categoria;

    int prioridade;
};

class Arquivo
{
private:
    std::vector<Tarefa> tarefas;
    std::ofstream arq;

    void sortLista()
    {
        int n = tarefas.size();
        bool trocou;
    
        for (int i = 0; i < n - 1; i++) 
        {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (tarefas[j].prioridade > tarefas[j + 1].prioridade) 
                {
                    Tarefa temp = tarefas[j];
                    tarefas[j] = tarefas[j + 1];
                    tarefas[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
    }

public:
    Arquivo(const char* nome) : arq(nome)
    {
    }

    void adicionaTarefa(Tarefa t)
    {
        tarefas.push_back(t);
    }

    void escreveNoArquivo()
    {      
        sortLista();
        for (int i = 0; i < tarefas.size(); i++)
        {   
            arq << "[TAREFA " << i + 1 << "]: ";
            arq << tarefas[i].descricao << "\n";
            arq << "[CATEGORIA]: " << tarefas[i].categoria << "\n";
            arq << "[PRIORIDADE]: " << tarefas[i].prioridade << "\n";
            arq << "\n";
        }
    }
};

int verificaPrioridade(int prioridade)
{
    if (prioridade > 5 || prioridade < 1)
        return 100;

    return prioridade;
}

int main()
{   
    system("cls");

    Arquivo arquivo("todo.txt");

    char parar;
    while(parar != 's')
    {
        Tarefa t;

        std::cout << "Descreva sua tarefa: ";
        std::cin >> t.descricao;

        std::cout << "Categorize sua tarefa: ";
        std::cin >> t.categoria;

        std::cout << "Prioridade da tarefa: ";
        int prioridade;
        std::cin >> prioridade;

        t.prioridade = verificaPrioridade(prioridade);

        arquivo.adicionaTarefa(t);

        std::cout << "Parar?: ";
        std::cin >> parar;
    }

    arquivo.escreveNoArquivo();

    return 0;
}