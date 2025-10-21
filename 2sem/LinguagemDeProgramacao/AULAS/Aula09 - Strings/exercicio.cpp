#include <iostream>
#include <string>

/*
Dada uma string contendo um nome completo, realize as seguintes operacoes:

1. Imprima o primeiro nome
2. Imprima o ultimo sobrenome
3. Imprima o nome invertido
*/

const std::string achaPrimeiroNome(const std::string nome)
{
    return nome.substr( 0, nome.find(" ") );
}

const std::string achaUltimoSobrenome(const std::string nome)
{
    return nome.substr( nome.rfind(" ") + 1, nome.length() );
}

const std::string inverteNome(const std::string nome)
{
    std::string invertido = "";

    for (int i = nome.length() - 1; i >= 0; i--)
        invertido += nome.at(i);

    return invertido;
}

int main()
{
    system("cls");
    const std::string nome = "Alexandro Magno dos Santos Adario";

    std::cout << "NOME ORIGINAL: " << nome << "\n\n";
    std::cout << "1. Primeiro nome:    " << achaPrimeiroNome(nome) << "\n";
    std::cout << "2. Ultimo sobrenome: " << achaUltimoSobrenome(nome) << "\n";
    std::cout << "3. Nome invertido:   " << inverteNome(nome) << "\n";

    return 0;
}