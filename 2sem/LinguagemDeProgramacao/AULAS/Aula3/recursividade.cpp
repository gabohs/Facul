#include <iostream>

int fatorial(int n)
{
    if (n <= 1)   
        return 1;

    else
        return ( n * fatorial(n - 1) ); 
}

int main()
{   
    std::cout << fatorial(4) << std::endl;

    return 0;
}