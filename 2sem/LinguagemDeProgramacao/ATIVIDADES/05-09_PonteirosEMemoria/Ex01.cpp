/*
Rotação dos Elementos de um Array

Escreva um programa que permita ao usuário inserir 10 números inteiros em um array. 
O programa deve conter uma função que rotacione os elementos do array para a direita uma vez 
(o primeiro vai para o segundo, o segundo vai para o terceiro, até que o último elemento vai para o primeiro índice). 
Ao final, a função principal (main), deve exibir o array resultante.
*/

#include <iostream>

void rotaciona(int vetor[], int tam)
{   
    int ultimo = vetor[tam - 1];

    for (int i = tam; i > 0; i--)
    {
        vetor[i] = vetor[i - 1];
    }

    vetor[0] = ultimo;
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

    rotaciona(vetor, tam);

    for (int n : vetor)
    {
        std::cout << n << " "; 
    }
    std::cout << std::endl;

    return 0;
}