/*
Considere uma situação em que é necessário implementar algumas funcionalidades de um diário escolar.
Para esse momento, so sao permitidos para uso os tipos de dados primitivos e arrays. O diário precisa
considerar o armazenamento das seguintes informações:

- o código do aluno (pode ser alfanumérico, conforme a necessidade)
- o nome do aluno
- as notas das avaliações (min 2, max 10)
- numero de faltas
- media dos alunos
*/

#include <iostream>
#include <string>

std::string* codigo;
std::string* nome;

double** notas;
int* faltas;
double* media;

int main()
{
    codigo = new std::string[10];
    
    notas = new double*[10]; // primeira dimensão, array de ponteiros double
    for (int i = 0; i < 10; i++)
    {
        notas[i] = new double[2]; // segunda dimensão
    }

    return 0;
}