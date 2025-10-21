#include <iostream>
#include <cstring>

int main()
{   
    system("cls");

    char s[] = "Cplus"; // 6 bytes -> char[] + '\0'

    std::cout << strlen(s) << "\n"; // tamanho da string, excluindo o '\0'
    // strlen tem complexidade de tempo linear, pois precisa percorrer
    // todo o array até encontrar o \0.

    char dest[10];
    strcpy(dest, s); // copia a string para um destino
    std::cout << dest << "\n";

    // strcpy não verifica o tamanho do buffer de destino, portanto pode ser insegura.

    char sFinal[32];
    strcat(sFinal, "Hello"); // concatena string 
    strcat(sFinal, ", "); // tambem nao verifica os limites; pode ser insegura
    strcat(sFinal, "World");

    std::cout << sFinal << "\n";

    char s1[] = "Oi";
    char s2[] = "Oi";
    char s3[] = "Hello";

    std::cout << strcmp(s1, s2) << "\n";
    std::cout << strcmp(s1, s3) << "\n";

    // -------------------------------------------------------------------
    
    char buf[10];
    std::cin >> buf; // se a entrada for maior que 9 caracteres -> out-of-bounds
    std::cout << buf << "\n";


    return 0;
}