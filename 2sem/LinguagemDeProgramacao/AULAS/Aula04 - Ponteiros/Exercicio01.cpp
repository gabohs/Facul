/*
Escreva uma funcao com a seguinte assinatura:
int recupera(double original[], double novas[], int quant, double* media)

> Ela deve verificar no array notas se o valor é maior que o correspondente em original. Se for,
substitui o original

> quant é a quantidade de notas em cada array
> Atualize a media com a media apos todas as substituicoes
> Retorne quantas notas foram recuperadas
*/ 

#include <iostream>

void printArr(double arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}

// --------------------------------------------------------------------------------------------------

int recupera(double original[], double novas[], int quant, double* media)
{   
    int notasTrocadas = 0;
    double soma = 0;
    
    for (int i = 0; i < quant; i++)
    {
        if (novas[i] > original[i])
        {
            original[i] = novas[i];
            notasTrocadas++;
        }

        soma += original[i];
    }

    *media = soma / quant;

    return notasTrocadas;
}

int main()
{
    double nOrignal[] = {5, 3, 6};
    double nRec[] = {7, 2, 8};

    std::cout << "Notas originais: " << std::endl;
    printArr(nOrignal, 3);

    std::cout << "Notas recuperacao: " << std::endl;
    printArr(nRec, 3);

    double mediaNova;

    // ---

    int notasTroc = recupera(nOrignal, nRec, 3, &mediaNova);

    // ---

    std::cout << "\n-------------------------" << std::endl;

    std::cout << "Nova media: " << mediaNova << std::endl;
    std::cout << "Quantidade de notas substituidas: " << notasTroc << std::endl;

    std::cout << "Novo array:" << std::endl;
    printArr(nOrignal, 3);

    return 0;
}