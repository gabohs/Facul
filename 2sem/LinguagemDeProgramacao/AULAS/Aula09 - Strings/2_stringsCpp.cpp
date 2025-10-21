#include <iostream>
#include <string>

#include <format>

void testeStrLegada(const char* str)
{
    std::cout << str << "\n";
}

void imprime(std::string_view sView)
{
    std::cout << sView << "\n";
}

int main()
{   
    system("cls");

    std::string s = "Ola ";
    s += "Mundo";
    s += "!";

    std::cout << s << "\n";
    testeStrLegada(s.c_str());

    std::string s2 = std::move(s); // transfere recursos sem cópia profunda
    std::cout << s << "\n"; // s agora ficou vazia
    std::cout << s2 << "\n";

    imprime(s2);

    return 0;
}
