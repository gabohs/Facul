#include <iostream>
#include <iomanip>

int main()
{   
    system("cls");

    int num = 671;

    std::cout << std::hex << num << "\n";
    std::cout << std::oct << num << "\n";
    std::cout << std::dec << num << "\n\n";

    // showbase utiliza convenções de representação de números de diferentes bases
    std::cout << std::hex << std::showbase << num << "\n";
    std::cout << std::oct << std::showbase << num << "\n";
    std::cout << num << "\n\n"; // o num permanece sendo exibido na forma octal, o std::oct e os demais manipuladores de saida funcionam de forma análoga à uma state-machine
    std::cout << std::dec;

    std::cout << "-----------------------------------------\n";

    // Formatacao de numeros de ponto de flutuante
    double valor = 1785.576;
    std::cout << valor << "\n";

    std::cout << std::setprecision(4) << std::fixed << valor << "\n";
    std::cout << std::scientific << valor << "\n\n";

    std::cout << "-----------------------------------------\n";

    double numeros[] = {1.75, 13.1, 14.567, 120.2, 1300.68, 890};

    std::cout << std::fixed;
    for (double n : numeros)
    {
        std::cout << std::setw(9) << n << "\n";
    }

    std::cout << "-----------------------------------------\n";

    std::string frutas[] = {"uva", "banana", "figo", "laranja", "fruta-do-conde"};

    for (std::string fruta : frutas)
    {
        std::cout << std::setw(15) << std::left << std::setfill('.') << fruta << " ---\n";
    }

    std::cout << "-----------------------------------------\n";

    std::cout << true << "\n";
    std::cout << false << "\n";
    std::cout << std::boolalpha << true << "\n";
    std::cout << false << "\n";

    return 0;
}