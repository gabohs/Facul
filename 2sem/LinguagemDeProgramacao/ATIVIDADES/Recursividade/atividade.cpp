#include <iostream>

void imprimeLinha(int nivel)
{
    std::cout << "| ";
    if (nivel > 0) std::cout << " " << std::string(nivel, '-');

    std::cout << "\n";
}

void regua(int n) 
{
    if (n == 0) 
    {
        imprimeLinha(0); 
        return;
    }

    regua(n - 1);

    imprimeLinha(n);

    regua(n - 1);
}


int main()
{    
    int N;
    std::cin >> N;
    
    regua(N);
    
    return 0;
}