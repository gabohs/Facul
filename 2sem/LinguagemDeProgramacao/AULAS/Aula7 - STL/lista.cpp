#include <iostream>
#include <list>
#include <string>

void printList(std::list<std::string> list)
{
    for (std::string elem : list)
    {
        std:: cout << elem << " ";
    } 
    std::cout << std::endl;
}

int main()
{   
    system("cls");
    std::cout << std::boolalpha;

    std::list<std::string> frutas = {
        "Uva", "Banana", "Figo", "Abacate"
    };

    /* NAO FUNCIONA PQ LISTAS N SAO ACESSIVEIS POR INDICE: 
    std::cout << frutas[0] << std::endl;
    std::cout << frutas.at(0) << std::endl;
    */
    
    std::cout << frutas.front() << std::endl;
    std::cout << frutas.back() << std::endl;

    printList(frutas);

    /*
    std::cout << frutas[2] << std::endl;
    frutas[2] = "Kiwi";
    std::cout << frutas[2] << std::endl; 
    */
      
    std::cout << "\nInserindo: " << std::endl;
    frutas.push_back("Morango");
    frutas.push_front("Laranja");
    printList(frutas);

    std::cout << "\nRemovendo:" << std::endl;
    frutas.pop_back();
    frutas.pop_front();
    printList(frutas);

    std::cout << "\nTamanho (n. de elementos): " << frutas.size() << std::endl;
    
    std::cout << "Vazia?: " << frutas.empty() << std::endl;

    frutas.front() = "Tomate";
    frutas.back() = "Abacaxi";

    std::cout << frutas.front() << std::endl;
    std::cout << frutas.back() << std::endl;

    return 0;
}