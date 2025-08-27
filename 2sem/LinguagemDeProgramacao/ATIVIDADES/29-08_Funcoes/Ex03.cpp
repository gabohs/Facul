/*
Escreva uma função recursiva que calcule a potência X^N. 
Nesse exemplo, X é um valor real e N é um valor inteiro. Ambos são passados como parâmetros de entrada da função.
*/

#include <iostream>

/*
Ex: x = 5, n = 3
potenciaRecursiva(5, 3):

5 * potenciaRecursiva(5, 2);
5 * 5 * potenciaRecursiva(5, 1);
5 * 5 * 5 potenciaRecursiva(5, 0)
5 * 5 * 5 * 1
*/

double potenciaRecursiva(double x, int n)
{   
    if (n == 0)
        return 1;
    else
        return x * potenciaRecursiva(x, n - 1);
}

int main()
{
    std::cout << potenciaRecursiva(5, 3) << std::endl;
    
    return 0;
}