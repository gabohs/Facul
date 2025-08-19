/*
Leia um num real (double) e informe se ele eh positivo, zero ou negativo
*/

#include <iostream>

int main()
{   
    double num = 0;
    std::cin >> num;

    if (num < 0)                                       
    {
        std::cout << num << " eh negativo" << std::endl;
    }
    else if (num > 0)
    {
        std::cout << num << " eh positivo" << std::endl;
    }
    else
    {
        std::cout << "ZERO" << std::endl;
    }

    return 0;
}