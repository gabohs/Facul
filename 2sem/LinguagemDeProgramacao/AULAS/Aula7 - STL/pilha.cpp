#include <iostream>
#include <stack>
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

    std::stack<std::string> frutas;
    frutas.push("Uva");
    frutas.push("Banana");
    frutas.push("Figo");
    frutas.push("Abacate");


    /* NAO FUNCIONA PQ PILHAS N SAO ACESSIVEIS POR INDICE: 
    std::cout << frutas[0] << std::endl;
    std::cout << frutas.at(0) << std::endl;
    */
    
    /* N TEM ACESSO BILATERAL
    std::cout << frutas.front() << std::endl;
    std::cout << frutas.back() << std::endl;
    */
    std::cout << frutas.top() << std::endl; // o elemento do topo eh o unico q pode ser acessado

    /*
    std::cout << frutas[2] << std::endl;
    frutas[2] = "Kiwi";
    std::cout << frutas[2] << std::endl; 
    */
      
    // N DA PRA USAR FOR EACH EM PILHAS

    std::cout << "\nTamanho (n. de elementos): " << frutas.size() << std::endl;

    // REMOCAO SOMENTE COM POP (ELEMENTO DO TOPO)
    frutas.pop();
    std::cout << frutas.top() << std::endl;

    std::cout << "Tamanho (n. de elementos): " << frutas.size() << std::endl;
    
    std::cout << "Vazia?: " << frutas.empty() << std::endl;


    return 0;
}