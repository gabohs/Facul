#include <iostream>
#include <deque>
#include <string>

void printDeque(std::deque<std::string> deque)
{
    for (std::string elem : deque)
    {
        std::cout << elem << " ";
    }
    std::cout << std::endl;
}

int main()
{   
    system("cls");

    std::deque<std::string> frutas = {
        "Uva", "Banana", "Figo", "Abacate"
    };

    std::cout << frutas[2] << std::endl;
    std::cout << frutas.at(2) << std::endl;

    printDeque(frutas);

    std::cout << "\nAlterando elemento de indice 2..." << std::endl;
    frutas.at(2) = "Abacaxi";

    std::cout << frutas[2] << std::endl;

    std::cout << "\nFront: " <<frutas.front() << std::endl;
    std::cout << "Back:  " <<frutas.back() << std::endl;
    std::cout << "Tamanho (n. de elementos): " << frutas.size() << std::endl;

    std::cout << "\nInserindo Elementos com push_front e push_back..." << std::endl;
    frutas.push_front("laranja");
    frutas.push_back("morango");

    printDeque(frutas);

    std::cout << "\nFront: " <<frutas.front() << std::endl;
    std::cout << "Back:  " <<frutas.back() << std::endl;
    std::cout << "Tamanho (n. de elementos): " << frutas.size() << std::endl;

    std::cout << "\nRemovendo Elementos com pop_front e pop_back..." << std::endl;
    frutas.pop_back();
    frutas.pop_front();

    printDeque(frutas);

    std::cout << "Tamanho (n. de elementos): " << frutas.size() << std::endl;

    return 0;
}