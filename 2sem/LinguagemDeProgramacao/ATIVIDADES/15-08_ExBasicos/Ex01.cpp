/*
Um analista está avaliando um processo. São realizadas duas avaliações, com valores entre 0 e 10, inclusive. 
Se as duas avaliações forem maiores ou iguais a 9,0, o valor final será a maior das duas. 
Se ambas forem superiores a 5,0, o resultado será a média das duas. 
Caso alguma seja inferior ou igual a 5.0, prevalecerá a menor das duas avaliações.
*/

#include <iostream>

int main()
{
    double av1, av2;
    std::cin >> av1 >> av2;

    double valorFinal = av1;

    if (av1  >= 9.0 && av2 >= 9.0)
    {
        if (av2  > av1) 
            valorFinal = av2;
    }
    else if (av1 > 5.0 && av2 > 5.0)
    {
        valorFinal = (av1 + av2) / 2.0;
    }
    else 
    {
        if (av2 < av1)
            valorFinal = av2;
    }

    std::cout << "Nota final: " << valorFinal << std::endl;

    return 0;
}