/*
Leia 3 valores reais: A, B e C

Se ( A < B + C ) e ( B < A + C ) e ( C < A + B ) eh um triangulo.

Se os 3 valores forem iguais, eh um triangulo equilatero

Se apenas 2 forem iguais eh um triangulo isosceles

Do contrario, eh um triangulo escaleno
*/

#include <iostream>

int main()
{
    double A, B, C;
    
    std::cout << "A B C" << std::endl;
    std::cin >> A >> B >> C;

    if ( (A < B + C) && (B < A + C) && (C < A + B) )
    {
        if (A == B == C)
        {
            std::cout << "Equilatero" << std::endl;
        }
        else if ( (A == B && A != C) || (A == C && A != B) || (B == C && B != A) )
        {
            std::cout << "Isosceles" << std::endl;
        }
        else
        {
            std::cout << "Escaleno" << std::endl;
        }
    }
    else
    {
        std::cout << "Nao eh triangulo" << std::endl;
    }

    return 0;
}