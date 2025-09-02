/*
Escreva uma funcao que receba um array de inteiros e inverta a posicao dos valores.
Da 0 para n - 1, 1 para n - 2, e assim por diante

{10, 15, 7, 0} ----> {0, 7, 15, 10} 
*/

#include <iostream>

void printArr(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}

// --------------------------------------------------------

void inverteArray(int array[], int tam)
{
    for (int i = 0; i < (tam / 2); i++)
    {
        int temp = array[i];
        array[i] = array[(tam - 1) - i];
        array[(tam - 1) - i] = temp;
    }
}

int main()
{
    int arr[] = {10, 15, 7, 2, 0};
    int tamanho = sizeof(arr) / sizeof(arr[0]);

    system("cls");
    std::cout << "Qntia de elems no array: " << tamanho << std::endl;
    printArr(arr, tamanho);

    // ---                   

    inverteArray(arr, tamanho);

    // ---

    printArr(arr, tamanho);

    
    return 0;
}