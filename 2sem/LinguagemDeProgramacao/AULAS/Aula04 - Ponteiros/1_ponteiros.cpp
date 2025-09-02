#include <iostream>

int incremento(int valor)
{
    valor++;
    return valor;
}

int ptr_incremento(int* valor)
{   
    (*valor)++;
    return (*valor);
}

int main()
{   
    int numero = 15;
    int resultado;

    std::cout << "Numero (antes): " << numero << std::endl;
    resultado = incremento(numero);
    std::cout << "Numero (dps): " << numero << std::endl;
    std::cout << "Resultado: " << resultado << std::endl;

    std::cout << "\n------------------------------" << std::endl;

    std::cout << "Numero (antes): " << numero << std::endl;
    resultado = ptr_incremento(&numero);
    std::cout << "Numero (dps): " << numero << std::endl;
    std::cout << "Resultado: " << resultado << std::endl;

    return 0;
}