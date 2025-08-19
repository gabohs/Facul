/*
Leia dois numeros reais e um numero inteiro. 
Se o numero inteiro for 1, some os dois reais.
Se o inteiro for 2, multiplique os reais.
Se o inteiro for 3, subtraia o primeiro pelo segundo
*/

#include <iostream>

int main ()
{
    double r1, r2;
    int i = 0;

    std::cout << "DIGITE OS REAIS" << std::endl;
    std::cin >> r1 >> r2;

    std::cout << "DIGITE O INTEIRO" << std::endl;
    std::cin >> i;

    switch (i)
    {
        case 1:
            std::cout << "Soma dos reais: " << r1 + r2 << std::endl;
            break;

        case 2:
            std::cout << "Produto dos reais: " << r1 * r2 << std::endl;
            break;

        case 3:
            std::cout << "Diferenca entre os reais (r1 - r2): " << r1 - r2 << std::endl; 
            break;

        default:
            std::cout << "Inteiro invalido" << std::endl;
            break;
        }

    return 0;
}
