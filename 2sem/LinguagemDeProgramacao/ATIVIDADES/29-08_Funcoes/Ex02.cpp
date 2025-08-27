/*
Criar uma função para calcular o n-ésimo número da série de Fibonacci. 
A série inicia com os valores 1 e 1, e os números subsequentes são a soma dos dois anteriores. 
(ex.: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...)
*/

#include <iostream>

int fibonacciN(int n)
{   
    if (n < 1)
        return 0;

    if (n == 1 || n == 2)
        return 1;

    int t1 = 1, t2 = 1;

    for (int i = 3; i <= n; i++)
    {
        int t = t1 + t2;
        t1 = t2;
        t2 = t;
    }
    return t2;
}

int main()
{
    for (int i = 1; i < 11; i++)
    {
        std::cout << "Termo " << i << ": " << fibonacciN(i) << std::endl;
    }

    return 0;
}