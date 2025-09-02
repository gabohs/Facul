/*
Altere o cod. anterior, incluindo uma funcao para fazer a tarefa de troca (swap)
de dois inteiros
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

void swapInt(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void inverteArray(int array[], int tam)
{
    for (int i = 0; i < (tam / 2); i++)
    {
        swapInt(&array[i], &array[tam - 1 - i]);
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