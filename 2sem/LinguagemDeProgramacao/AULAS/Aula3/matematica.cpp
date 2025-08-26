#include <iostream>

#include <cmath>

#define _USE_MATH_DEFINES
#include <math.h>

int main()
{
    double raio;
    std::cout << "Digite o raio: ";
    std::cin >> raio;

    std::cout << "Circunferencia: ";
    std::cout << (2 * M_PI * raio) << std::endl;  

    std::cout << "Raio: ";
    std::cout << ( M_PI * pow(raio, 2) ) << std::endl;

    return 0;
}