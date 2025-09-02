#include <iostream>

void duplica(int vetor[], int tam)
{
    for (int i = 0; i < tam; i++)
    {
        vetor[i] *= 2;
    }
}

int main()
{
    int vetor[] = {8, 5, 3};

    for (int i : vetor)
    {
        std::cout << i << " ";
    }
    std::cout << std::endl;

    duplica(vetor, 3);

    for (int i : vetor)
    {
        std::cout << i << " ";
    }
    std::cout << std::endl;

    return 0;
}