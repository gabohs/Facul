#include <iostream>

int main()
{
    int num1, num2;

    std::cout << "Digite o primeiro numero: ";
    std::cin >> num1;

    std::cout << "Digite o segundo numero: ";
    std::cin >> num2;

    int soma = num1 + num2;

    std::cout << "Resultado: " << soma << std::endl;

    return 0;
}