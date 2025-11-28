#include <iostream>
#include <vector>
#include <chrono>

void printVec(const std::vector<int>& vec)
{   
    std::cout << "[  ";
    for (const int i : vec)
    {
        std::cout << i << "  ";
    }
    std::cout << "]\n";
}

void bubbleSort(std::vector<int>& vec)
{   
    bool trocou;

    for (int i = 0; i < vec.size(); i++)
    {
        for (int j = i + 1; j < vec.size(); j++)
        {
            trocou = false;

            if (vec[i] > vec[j])
            {   
                int temp = vec[i];
                vec[i] = vec[j];
                vec[j] = temp;

                trocou = true;
            }
            
            if (!trocou)
                break;
        }
    }
}

void selectionSort(std::vector<int>& vec)
{
    int menor;

    for (int i = 0; i < vec.size(); i++)
    {
        menor = i;

        for (int j = i + 1; j < vec.size(); j++)
        {
            if (vec[j] < vec[menor])
                menor = j;
        }

        if (i != menor)
        {
            int temp = vec[i];
            vec[i] = vec[menor];
            vec[menor] = temp;
        }
    }
}

void insertionSort(std::vector<int>& vec)
{
    for (int i = 1; i < vec.size(); i++)
    {
        for (int j = i; (j > 0) && (vec[j - 1] > vec[j]); j -= i)
        {
            int temp = vec[j];
            vec[j] = vec[j - 1];
            vec[j - 1] = temp;
        }
    }
}

int main()
{   
    system("cls");
    std::vector<int> vetor = {5, 2, 3, 7, 9, 6};
    
    printVec(vetor);

    const auto inicio = std::chrono::steady_clock::now();
    
    bubbleSort(vetor);

    const auto fim = std::chrono::steady_clock::now();

    const std::chrono::duration<double> tPercorrido = fim - inicio;

    printVec(vetor);

    std::cout << "\nTEMPO PERCORRIDO:\n";
    std::cout << "SEG: " << tPercorrido.count() << "\n";
    std::cout << "MS:  " << tPercorrido.count() * 1000 << "\n\n";

    return 0;
}