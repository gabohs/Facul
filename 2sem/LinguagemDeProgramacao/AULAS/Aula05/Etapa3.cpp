/*
Implemente uma ou mais funções que permitam ler o código e o nome dos alunos e armazene-os nas
estruturas de dados
*/

#include <iostream>
#include <string>

std::string* codigo;
std::string* nome;

double** notas;
int* faltas;
double* media;

int quantidadeAlunos;
int quantidadeAval;

void criaAlunos(int quant)
{
    codigo = new std::string[quant];
    nome   = new std::string[quant];
    notas  = new double* [quant];
    faltas = new int[quant];
    media  = new double[quant];
}

void criaNotas(int alunos, int quantNotas)
{
    for (int i = 0; i < alunos; i++)
    {
        notas[i] = new double[quantNotas]; // segunda dimensão
    }
}

void leituraAluno(int indice)
{
    std::cout << "Codigo [" << indice << "]: ";
    std::cin >> codigo[indice];

    std::cout << "Aluno [" << indice << "]: ";
    std::cin >> nome[indice];
}

void leituraAlunos(int numAlunos)
{
    for (int i = 0; i < numAlunos; i++)
    {
        leituraAluno(i);
    }
}

int main()
{   
    int nAlunos, nNotas;

    std::cout << "Num. Alunos | Num. Notas:" << std::endl;
    std::cin >> nAlunos >> nNotas;

    criaAlunos(nAlunos);
    criaNotas(nAlunos, nNotas);

    leituraAlunos(nAlunos);

    return 0;
}