#include <iostream>
#include <map>
#include <string>

void printMap(std::map<std::string, int> map)
{
    for (auto [key, value] : map)
    {
        std::cout << key << ": " << value << std::endl;
    }

    /*
    for (auto pessoa : pessoas)
    {
        std::cout << pessoa.first << ": " << pessoa.second << std::endl;
    }
    */
}

int main()
{   
    system("cls");
    std::cout << __cplusplus << std::endl;

    std::map<std::string, int> pessoas;

    pessoas["Daniel"] = 31;
    pessoas.insert({"Vitor", 19});

    printMap(pessoas);

    std::cout << "\n" << pessoas["Daniel"] << std::endl;

    return 0;
}