/*
Implemente uma função que leia a quantidade de faltas dos alunos e armazene na estrutura de
dados criada.
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

void leituraAvaliacao(int numAlunos, int numAvaliacao)
{
    for (int i = 0; i < numAlunos; i++)
    {
        std::cout << "Aluno: " << nome[i] << std::endl;
        std::cout << "Nota: [" << numAvaliacao + 1 << "]: ";
        std::cin >> notas[i][numAvaliacao];
    }
}

void leituraTodasAvaliacoes(int numAlunos, int numNotas)
{
    for (int i = 0; i < numNotas; i++)
    {
        leituraAvaliacao(numAlunos, i);
    }
}

void atualizaMedia(int numAlunos, int numNotas) 
{
	double soma;

    for(int a=0; a < numAlunos; a++) 
    {
    	soma = 0;
    	for(int n=0; n< numNotas; n++) 
        {
    		soma += notas[a][n];
		}
    	media[a] = soma / numNotas;
	}	
}

void leituraFaltas(int numAlunos)
{
    for (int i = 0; i < numAlunos; i++)
    {
        std::cout << "Aluno: " << nome[i] << std::endl;
        std::cout << "Faltas: ";
        std::cin >> faltas[i];
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

    leituraTodasAvaliacoes(nAlunos, nNotas);
    atualizaMedia(nAlunos, nNotas);

    leituraFaltas(nAlunos);

    return 0;
}