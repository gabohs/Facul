/*
No município de Miracema do Norte, Arlindo Orlando está responsável por instalar novos radares de velocidade e necessita de auxílio 
para configurá-los. Dado um limite de velocidade, a ser lido externamente, deve ser considerado um erro geral de qualquer equipamento de 7 km/h 
(subtrair da velocidade medida do veículo). 

Em seguida, analisar se a velocidade do veículo for até 10% do limite, está dentro da tolerância e não é gerada autuação; 
se for entre 10 e 20%, a infração é MÉDIA; 
até 50% a infração é GRAVE; 
e acima disso ela é GRAVÍSSIMA.
*/

#include <iostream>
#include <string>

int main()
{   
    const short LIMIAR_ERRO = 7;

    int limite;
    int velocidade;
    
    std::cout << "Limite do radar (km/h): ";
    std::cin >> limite;

    std::cout << "Velocidade do veiculo (km/h): ";
    std::cin >> velocidade;
    
    std::cout << "---------------------------------------------" << std::endl;
    std::cout << "[VEL. REAL]        " << velocidade << " km/h" << std::endl;
    
    velocidade -= LIMIAR_ERRO;

    std::cout << "[VEL. CONSIDERADA] " << velocidade << " km/h" << std::endl;
    std::cout << "[LIMITE]           " << limite << " km/h\n" << std::endl;

    double excesso = (velocidade - limite) / (double)limite;
    
    if (excesso <= 0.1)
    {    
        std::cout << "DENTRO DA TOLERANCIA DO RADAR!" << std::endl;
    }
    else 
    {   
        std::string infracao;

        if (excesso <= 0.2)  
            infracao = "MEDIA";
        else if (excesso <= 0.5) 
            infracao = "GRAVE";
        else 
            infracao = "GRAVISSIMA";

        std::cout << "FORA DA TOLERANCIA!" << std::endl;
        std::cout << "Velocidade considerada ultrapassa o limite em " << excesso * 100.0 << "%" << std::endl; 
        std::cout << "Nivel da infracao: " << infracao << std::endl;
    }   
    std::cout << "---------------------------------------------" << std::endl;
        
    return 0;
}