#include <iostream>
#include <set>
#include <string>

void printSet(std::set<int> set)
{
    for (int num : set)
    {
        std::cout << num << " ";
    }
    std::cout << std::endl;
}

int main()
{   
    system("cls");

    std::set<int> conjunto = {1, 2, 90, 1, 4, 5}; // n armazena elementos iguais
    std::cout << "Tamanho: " << conjunto.size() << std::endl; // 5, pois o segundo 1 n vai ser inserido

    printSet(conjunto);

    conjunto.insert(2); // n vai ser inserido, ja tem 2 no set
    std::cout << "Tamanho: " << conjunto.size() << std::endl;

    conjunto.insert(3); // vai ser inserido, pq ainda n tem 3 no set
    printSet(conjunto);

    std::set<int , std::greater<int>> conjunto2 = {1, 2, 90, 1, 4, 5}; 
    // conjunto2 vai ser printado em ordem decrescente
    for (int num : conjunto2)
    {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    // removendo
    conjunto.erase(90);
    printSet(conjunto);

    return 0;
}