/*
Peça ao usuário um número inteiro n e exiba os primeiros n termos da sequência de Fibonacci usando while.

O que é a sequência de Fibonacci?

A sequência de Fibonacci é uma sucessão numérica em que cada termo, a partir do terceiro, é a soma dos dois anteriores. 
Os dois primeiros termos geralmente são definidos como 1 e 1. 
Assim: 1, 1, 2, 3, 5, 8, 13, 21, 34, …
*/

#include <iostream>

int main()
{
    int n;
    std::cin >> n;

    int t1 = 1, t2 = 1;
    std::cout << t1 << "  " << t2 << "  ";

    int t = 0;
    int cont = 3; // contador para o loop

    while (cont <= n)
    {
        t = t1 + t2;
        std::cout << t << "  ";
        
        t1 = t2;
        t2 = t;
        cont++;
    }
    std::cout << "\n";

    return 0;
}