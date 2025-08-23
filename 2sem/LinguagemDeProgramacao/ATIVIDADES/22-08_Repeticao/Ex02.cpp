// Leia vários números inteiros do usuário e calcule a soma deles. O programa deve parar quando o usuário digitar 0

#include <iostream>

int main()
{
    int soma = 0;
    
    int in;
    
    do
    {
        std::cin >> in;
        soma += in;
    } while (in != 0);

    std::cout << "Soma: " << soma << std::endl;

    return 0;
}