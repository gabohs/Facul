/*
Leia 2 caracteristicas de um animal:
caracteristica A: 
    1 - mamifero   
    2 - ave

caracteristica B:
    1 - herbivoro
    2 - carnivoro

Se for mamifero e herbivoro, eh uma vaca
Se for mamifero e carnivoro, eh uma onca
Se for ave e herbivoro, eh um sabia
Se for ave e carnivoro, eh um gaviao
*/

#include <iostream>

int main()
{   
    int c1, c2;

    std::cout << "Digite as caracteristicas (A B)" << std::endl;
    std::cin >> c1 >> c2;

    if (c1 == 1)
    {
        if (c2 == 1)
            std::cout << "Vaca" << std::endl;

        else if (c2 == 2)
            std::cout << "Onca" << std::endl;

        else 
            std::cout << "Segunda caracteristica invalida" << std::endl;
    }
    else if (c1 == 2)
    {
        if (c2 == 1)
            std::cout << "Sabia" << std::endl;

        else if (c2 == 2)
            std::cout << "Gaviao" << std::endl;

        else 
            std::cout << "Segunda caracteristica invalida" << std::endl;
    }
    else
    {
        std::cout << "Primeira caracteristica invalida" << std::endl;
    }

    return 0;
}