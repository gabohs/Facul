/*
Faça uma leitura aprofundada do texto sobre Funcões Matemáticas. Em seguida, explore mais sobre as funções matemáticas de cmath, 
pesquisando sobre aplicações e usos dessas funções. Por fim, elabore um programa em C++ que demonstre o uso de ao menos 10 funções de diferentes 
categorias, e ao menos 3 constantes matemáticas dessa biblioteca. Use sem moderação os comentários no seu código para demonstrar que você compreendeu 
o uso dessas funções e constantes.
*/

#define _USE_MATH_DEFINES
#include <cmath>
#include <iostream>

void imprimirMenu()
{
    std::cout << "------------------- CALCULADORA CIENTIFICA --------------------" << std::endl;
    std::cout << "Operacoes: \n" << std::endl;
    std::cout << "1 - Raiz Quadrada" << "  2 - R. cubica" << "  3 - Fatorial" << "  4 - Log natural" << std::endl;
    std::cout << "5 - Log base 10" << "    6 - Seno" << "       7 - Cosseno" << "   8 - Tangente" << std::endl;
    std::cout << "9 - e^x        " << "    10 - Log base 2" << std::endl;
    std::cout << "11 - Arredondar p/ baixo" << "  12 - Arredondar p/ cima" << std::endl;
    std::cout << "0 - Sair" << std::endl;
    std::cout << "---------------------------------------------------------------\n" << std::endl;
}

void mostrarConstantes()
{
    std::cout << "CONSTANTES: " << std::endl;
    std::cout << "PI:      " << M_PI << std::endl;
    std::cout << "E:       " << M_E << std::endl;
    std::cout << "ln(2):   " << M_LN2 << std::endl;
    std::cout << "sqrt(2): " << M_SQRT2 << std::endl;
    std::cout << "\n";
}

void calcular(int operacao, double x)
{
    switch (operacao)
    {
        case 1:
            std::cout << sqrt(x) << std::endl;
            break;

        case 2:
            std::cout << cbrt(x) << std::endl;
            break;

        case 3:
            // a cmath n tem uma função fatorial especifica, mas podemos usar a função gamma, que retorna (n - 1)!. Assim para ter o fatorial, 
            // podemos somar 1 ao parâmetro
            std::cout << tgamma(x + 1) << std::endl; 
            break;

        case 4:
            std::cout << log(x) << std::endl;
            break;

        case 5:
            std::cout << log10(x) << std::endl;
            break;

        case 6:
            std::cout << sin(x * M_PI / 180) << std::endl; // dividir por PI/180 para converter para radianos, que eh oq a função espera
            break;
    
        case 7:
            std::cout << cos(x * M_PI / 180) << std::endl;
            break;

        case 8:
            std::cout << tan(x * M_PI / 180) << std::endl;
            break;

        case 9:
            std::cout << pow(M_E, x) << std::endl;
            break;

        case 10:
            std::cout << log(x) / M_LN2 << std::endl;
            break;

        case 11:
            std::cout << floor(x) << std::endl;
            break;

        case 12:
            std::cout << ceil(x) << std::endl;
            break;

        default:
            std::cout << "Operacao invalida!" << std::endl;
            break;
    }
}

int main()
{
    imprimirMenu();
    mostrarConstantes();
    int op; // operacao
    double x;

    while (true)
    {
        std::cout << "ESCOLHA A OPERACAO: ";
        std::cin >> op;

        if (op == 0)
            break;

        std::cout << "OPERANDO: ";
        std::cin >> x;

        std::cout << "> ";
        calcular(op, x);
    }

    return 0;
}