/*
Continuando a etapa 1...

Implemente uma ou mais funcoes que permitam ler a quantidade de alunos e de avaliacoes do semestre.
Em seguida, crie essas estruturas
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
    nome = new std::string[quant];
    notas = new double* [quant];
    faltas = new int[quant];
    media = new double[quant];
}

void criaNotas(int alunos, int quantNotas)
{
    for (int i = 0; i < alunos; i++)
    {
        notas[i] = new double[quantNotas]; // segunda dimensão
    }
}

int main()
{   
    

    return 0;
}