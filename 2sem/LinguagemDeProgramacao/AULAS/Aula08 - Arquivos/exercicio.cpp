#include <iostream>
#include <iomanip>

int main()
{   
    system("cls");

    std::string produtos[] = {
        "agua mineral", "refrigerante", "suco", "copo descartavel"
    };

    int quant[] = { 120, 50, 60, 250 };

    double precoUnit[] = { 0.69, 2.45, 5.7, 0.2 };

    // EXERCICIO: exibir um relatorio formatado em espacos e casas decimais contendo:
    // PRODUTO QUANTIDADE PRECO_UNITARIO PRECO_TOTAL

    std::cout << std::left;
    std::cout << std::setw(16) << "PRODUTO ";
    std::cout << std::setw(6) << "QUANT ";
    std::cout << std::setw(10) << "PRECO_UNI " << "PRECO_TOT " << "\n";

    std::cout << std::fixed;
    std::cout << std::setprecision(2);

    double pTotal = 0;
    for (int i = 0; i < 4; i++)
    {   
        double pTotalUni = quant[i] * precoUnit[i];
        pTotal += pTotalUni;

        std::cout << std::setw(17) << produtos[i]<< " ";
        std::cout << std::setw(8) << quant[i] << " "; 
        std::cout << std::setw(7) << precoUnit[i] << " " << pTotalUni << "\n";     
    }
    std::cout << std::setw(29) << "" << "TOTAL: " << pTotal;

    return 0;
}