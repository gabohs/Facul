/*
Exiba na tela uma lista de valores, iniciando em 0, aumentando gradativamente de 0.1,
ate chegarem a 10, inclusive.
*/

#include <iostream>

int main()
{
    for (double i = 0; i <= 10; i += 0.1)
    {
        std::cout << i << std::endl;
    }

    return 0;
}