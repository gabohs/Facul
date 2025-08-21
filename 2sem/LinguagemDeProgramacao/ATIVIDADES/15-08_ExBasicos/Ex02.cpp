/*
A EHEV (Erechim Hybrid and Electrical Vehicles) está lançando seus veículos no mercado. 
É possível escolher entre três modelos base: A, B e C. 
O modelo A tem 3 opções de bateria: X, Y e Z. 
Os modelos B e C tem apenas 2 opções: Y e Z. 
O modelo A pode ser configurado com rodas de aro tamanho 14 e 15. 
O modelo B, apenas tamanho 16. 
O modelo C, podem ser 15 ou 16. 
Escreva um programa que leia as 3 características, modelo (char), bateria (char) e roda (int). Dadas as restrições descritas, informe se o carro a ser 
fabricado é VALIDO ou INVALIDO.
*/

#include <iostream>

int main()
{   
    char modelo, bateria;
    int roda;

    std::cin >> modelo >> bateria >> roda;

    bool valido = false;

    switch (modelo)
    {
        case 'A':
            if (bateria == 'X' || bateria == 'Y' || bateria == 'Z')
            {
                if (roda == 14 || roda == 15)
                    valido = true;
            }
            break;

        case 'B':
            if (bateria == 'Y' || bateria == 'Z')
            {
                if (roda == 16)
                    valido = true;
            }
            break;

        case 'C':
            if (bateria == 'Y' || bateria == 'Z')
            {
                if (roda == 15 || roda == 16)
                    valido = true;
            }
            break;
    }

    if (valido)
        std::cout << "VALIDO" << std::endl;
    else
        std::cout << "INVALIDO" << std::endl;

    return 0;
}