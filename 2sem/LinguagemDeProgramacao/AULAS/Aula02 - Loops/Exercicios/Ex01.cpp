/*
Leia um numero inteiro e informe se ele eh par ou impar
*/

#include <iostream>

int main()
{   
    int num = 0;
    std::cin >> num;

    if (num % 2 == 0)
    {
        std::cout << num << " eh par" << std::endl;
    }
    else
    {
        std::cout << num << " eh impar" << std::endl;
    }

    return 0;
}