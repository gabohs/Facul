/*
Codigo que calcule o volume de uma esfera e a area superficial da esfera
*/

#define _USE_MATH_DEFINES
#include <cmath>

#include <iostream>

int main()
{
    double raio;
    std::cout << "Raio: ";
    std::cin >> raio;

    std::cout << "Volume: ";
    std::cout << ( (4 * M_PI * std::pow(raio, 3)) / 3 ) << std::endl;

    std::cout << "Area Superficial: ";
    std::cout << ( 4 * M_PI * std::pow(raio, 2) ) << std::endl;

    return 0;
}