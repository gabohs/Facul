#include <iostream>
#include <format>

int main()
{   
    system("cls");

    std::string texto = "Nome da pessoa"; // SSO
    std::cout << texto << "\n";

    texto += " nao esta no nosso catalogo"; // agora area esta alocada na heap, maior q 15 caracteres
    std::cout << texto << "\n";

    // ----

    std::string txt   = "pipoca";
    std::string valor = "pipoca";

    std::cout << std::boolalpha << (txt == valor) << "\n";

    // ----

    // std::string final = std::format("Nome: {} Idade {}", "Zezinho", 12);

    // ---- 
    // funcoes para trabalhar com strings
    std::cout << "---------------\n";
    {
        std::string s = "Hello";
        s.append(" World");

        std::cout << "\n" << s << "\n";

        std::cout << s.at(1) << "\n";
        std::cout << s.back() << "\n";
        std::cout << s.front() << "\n";

        std::cout << s.length() << "\n";
        std::cout << s.size() << "\n";

        s.erase(2, 3);
        std::cout << s << "\n";
    }

    {
        std::string a = "abc", b = "abd";

        std::cout << a.compare(b) << "\n"; // comparacao lexicografica -> (a < b): result negativo
        std::cout << b.compare(a) << "\n"; // result positivo (b > a)
        std::cout << b.compare("abd") << "\n"; // result positivo (b > a)

        std::cout << a.empty() << "\n"; // string vazia ou n?
    }

    {
        std::string fruta = "banana";

        std::cout << fruta.find("na") << "\n"; // 2 -> busca a partir do inicio
        std::cout << fruta.rfind("na") << "\n"; // 4 -> busca a partir do final

        fruta.insert(3, "XYZ");
        std::cout << fruta << "\n";
    }

    {
        std::string fruta = "maca";
        
        fruta.pop_back(); // remove do final 
        std::cout << fruta << "\n";

        fruta.push_back('a');
        fruta.push_back('!');
        std::cout << fruta << "\n";

        fruta.replace(2, 3, "++");
        std::cout << fruta << "\n";

        fruta.resize(2); // aumenta ou diminui
        std::cout << fruta << "\n";
    }

    {
        std::string comp = "computacao";
        std::cout << comp.substr(0, 4) << "\n"; // retorna parte da string
    }

    {
        std::string a = "abc", b = "xyz";
        std::cout << a << " " << b << "\n";
        a.swap(b);
        std::cout << a << " " << b << "\n";
    }


    return 0;
}