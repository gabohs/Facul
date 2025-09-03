/*
Rotação dos Elementos de um Array

Implemente uma função que rotacione os elementos do array. A função deve receber, além do array, mais dois parâmetros:

forward (bool) : se true, a rotação ocorre dos menores índices para os maiores, se false, o sentido inverte
steps (int): indica quandos índices a rotação deve avançar, se  por acaso o usuário informar um número não positivo, a rotação ocorre de 1 em 1.
Escreva também uma função principal (main) para testar o seu código.
*/

#include <iostream>
#include <vector>

void printArr(int arr[], int tam)
{
    for (int i = 0; i < tam; i++)
    {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}

void rotaciona(int vetor[], int tam, bool forward, int steps)
{   
    if (steps < 0)
        steps = 1;

    std::vector<int> temp(tam);

    for (int i = 0; i < tam; i++)
    {
        if (forward)
            temp[ (i + steps) % tam ] = vetor[i];
        else
            temp[ (i - steps + tam) % tam ] = vetor[i];
    }

    for (int i = 0; i < tam; i++)
    {
        vetor[i] = temp[i];
    }
}

int main()
{   
    system("cls");

    int vetor[10] = {};
    int tam = sizeof(vetor) / sizeof(vetor[0]);

    for (int i = 0; i < tam; i++)
    {
        std::cin >> vetor[i];
    }

    std::cout << "ORIGINAL:     ";
    printArr(vetor, tam);

    rotaciona(vetor, tam, false, 3);

    std::cout << "ROTACIONADO:  ";
    printArr(vetor, tam);

    return 0;
}