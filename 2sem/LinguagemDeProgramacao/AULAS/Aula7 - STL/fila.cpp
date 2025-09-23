#include <iostream>
#include <queue>
#include <string>

int main()
{   
    system("cls");
    std::cout << std::boolalpha;

    /* N EH POSSIVEL INSERIR ELEMENTOS NA CRIACAO
    std::stack<std::string> frutas = {
        "Uva", "Banana", "Figo", "Abacate"
    };
    */

    std::queue<std::string> frutas;
    frutas.push("Uva");
    frutas.push("Banana");
    frutas.push("Figo");
    frutas.push("Abacate");

    // NAO POSSUEM ACESSO POR INDICE: 
    // N DA PRA USAR FOR EACH
    
    std::cout << "Front: " <<frutas.front() << std::endl;
    std::cout << "Back:  " <<frutas.back() << std::endl;
    std::cout << "\nTamanho (n. de elementos): " << frutas.size() << std::endl;
    
    std::cout << "\nRemovendo com pop..." << std::endl;
    frutas.pop();

    std::cout << "Front: " <<frutas.front() << std::endl;
    std::cout << "Back:  " << frutas.back() << std::endl;
    
    std::cout << "\nTamanho (n. de elementos): " << frutas.size() << std::endl;
    
    std::cout << "Vazia?: " << frutas.empty() << std::endl;


    return 0;
}