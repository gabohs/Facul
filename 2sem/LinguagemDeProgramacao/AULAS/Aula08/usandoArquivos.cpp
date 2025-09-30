#include <fstream>

int main()
{
    std::ofstream arquivo("dados.txt");

    arquivo << "ALGUNS DADOS:" << "\n";
    arquivo << 12345 << "\n";
    arquivo << 2.786 << "\n";

    arquivo.close();

    return 0;
}