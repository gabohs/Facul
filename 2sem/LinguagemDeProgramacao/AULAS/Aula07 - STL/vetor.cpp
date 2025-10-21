#include <iostream>
#include <vector>
#include <string>

void printVec(std::vector<std::string> vec)
{
    for (std::string elem : vec)
    {
        std:: cout << elem << " ";
    } 
    std::cout << std::endl;
}

int main()
{   
    system("cls");
    std::cout << std::boolalpha;

    std::vector<std::string> frutas = {
        "Uva", "Banana", "Figo", "Abacate"
    };

    std::cout << frutas[0] << std::endl;
    std::cout << frutas.at(0) << std::endl;
    std::cout << frutas.front() << std::endl;
    std::cout << frutas.back() << std::endl;

    printVec(frutas);

    std::cout << frutas[2] << std::endl;
    frutas[2] = "Kiwi";
    std::cout << frutas[2] << std::endl;

    std::cout << "\nInserindo Morango com push_back" << std::endl;
    frutas.push_back("Morango");
    printVec(frutas);

    std::cout << "\nRemovendo com pop_back" << std::endl;
    frutas.pop_back();
    printVec(frutas);

    std::cout << "\nTamanho (n. de elementos): " << frutas.size() << std::endl;
    
    std::cout << "Vazia?: " << frutas.empty() << std::endl;

    return 0;
}