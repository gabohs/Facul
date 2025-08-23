// Leia uma nota de um aluno (entre 0 e 10). Se o valor digitado for inválido, peça novamente até que o usuário digite um valor válido.

#include <iostream>

int main()
{   
    int nota;
    do
    {   
        std::cout << "Nota do aluno: ";
        std::cin >> nota;
    } while (nota < 0 || nota > 10);
    
    std::cout << nota << std::endl;

    return 0;
}