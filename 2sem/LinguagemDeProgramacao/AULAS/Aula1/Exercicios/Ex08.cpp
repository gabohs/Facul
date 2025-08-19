/*
Exiba a tabuada de todos os numeros de 2 a 9
*/

#include <iostream>

int main()
{
    for (int i = 2; i < 10; i++)
    {   
        std::cout << "TABUADA DO " << i << std::endl;
        for (int j = 0; j <= 10; j++)
        {
            std::cout << i << " x " << j << " = " << i * j << std::endl;
        }
        std::cout << "--------------------------" << std::endl;
    }

    return 0;
}