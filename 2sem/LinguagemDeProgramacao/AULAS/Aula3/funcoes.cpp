#include <iostream>

int soma(int a, int b)
{
    return a + b;
}

double soma(double a, double b)
{
    return a + b;
}

int soma(int a, int b, int c)
{
    return a + b + c;
}

int main()
{
    std::cout << soma(5, 7) << std::endl;      // (int, int)
    std::cout << soma(5.0, 7.0) << std::endl;  // (double, double)
    std::cout << soma(5, 7, 9) << std::endl;   // (int, int, int)

    return 0;
}