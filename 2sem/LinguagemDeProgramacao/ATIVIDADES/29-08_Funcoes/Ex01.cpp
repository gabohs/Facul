/*
Escreva uma função que receba como parâmetro um número inteiro, no intervalo de 1 a 20, e retorne uma String correspondente ao número por extenso. 
Caso o número seja menor que 1 ou maior que 20, o método deve retornar o texto “inválido”.
*/

#include <iostream>
#include <string>

std::string numPorExtenso(int num)
{   
    if (num < 1 || num > 20)
        return "invalido";

    std::string numsExtenso[] = {
        "um", "dois", "tres", "quatro", "cinco", "seis", "sete", "oito", "nove",
        "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove", "vinte"
    };

    return numsExtenso[num - 1];
}   

int main()
{    
    for (int i = 0; i <= 21; i++)
    {
        std::cout << i << ": " << numPorExtenso(i) << std::endl; 
    }
    
    return 0;
}