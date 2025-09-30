#include <fstream>
#include <iomanip>

int main()
{   
    std::ofstream arquivo("produtos.txt");

    std::string produtos[] = {
        "agua mineral", "refrigerante", "suco", "copo descartavel"
    };

    int quant[] = { 120, 50, 60, 250 };
    double precoUnit[] = { 0.69, 2.45, 5.7, 0.2 };

    // EXERCICIO: exibir um relatorio formatado em espacos e casas decimais contendo:
    // PRODUTO QUANTIDADE PRECO_UNITARIO PRECO_TOTAL

    arquivo << std::left;
    arquivo << std::setw(16) << "PRODUTO ";
    arquivo << std::setw(6) << "QUANT ";
    arquivo << std::setw(10) << "PRECO_UNI " << "PRECO_TOT " << "\n";
    arquivo << std::fixed;
    arquivo << std::setprecision(2);

    double pTotal = 0;
    for (int i = 0; i < 4; i++)
    {   
        double pTotalUni = quant[i] * precoUnit[i];
        pTotal += pTotalUni;

        arquivo << std::setw(17) << produtos[i]<< " ";
        arquivo << std::setw(8) << quant[i] << " "; 
        arquivo << std::setw(7) << precoUnit[i] << " " << pTotalUni << "\n";     
    }
    arquivo << std::setw(29) << "" << "TOTAL: " << pTotal;

    return 0;
}