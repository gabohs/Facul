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

    for (int i = 0; i < vec.size() - 1; i++)
    {
        trocou = false;

        for (int j = 0; j < vec.size() - 1 - i; j++)
        {
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

// =====================================================================================================

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

// =====================================================================================================

void insertionSort(std::vector<int>& vec)
{
    for (int i = 1; i < vec.size(); i++)
    {
        for (int j = i; (j > 0) && (vec[j - 1] > vec[j]); j--)
        {
            int temp = vec[j];
            vec[j] = vec[j - 1];
            vec[j - 1] = temp;
        }
    }
}

// =====================================================================================================

int partition(std::vector<int>& arr, int low, int high) 
{
    int pivot = arr[high]; // Choosing the last element as pivot
    int i = (low - 1);     // Index of smaller element

    for (int j = low; j <= high - 1; j++) 
    {
        // If current element is smaller than or equal to pivot
        if (arr[j] <= pivot) 
        {
            i++; // Increment index of smaller element
            std::swap(arr[i], arr[j]);
        }
    }
    std::swap(arr[i + 1], arr[high]);
    return (i + 1);
}

// Main Quicksort function
void quickSort(std::vector<int>& arr, int low, int high) 
{
    if (low < high) 
    {
        // pi is partitioning index, arr[pi] is now at right place
        int pi = partition(arr, low, high);

        // Separately sort elements before partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

// =====================================================================================================

void merge(std::vector<int>& arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    // Create temporary arrays
    std::vector<int> L(n1);
    std::vector<int> R(n2);

    // Copy data to temporary arrays L[] and R[]
    for (int i = 0; i < n1; ++i)
        L[i] = arr[left + i];

    for (int j = 0; j < n2; ++j)
        R[j] = arr[mid + 1 + j];

    // Merge the temporary arrays back into arr[left..right]
    int i = 0;      // Initial index of first subarray
    int j = 0;      // Initial index of second subarray
    int k = left;   // Initial index of merged subarray

    while (i < n1 && j < n2) 
    {
        if (L[i] <= R[j]) 
        {
            arr[k] = L[i];
            i++;
        } 
        else 
        {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    // Copy the remaining elements of L[], if any
    while (i < n1) 
    {
        arr[k] = L[i];
        i++;
        k++;
    }

    // Copy the remaining elements of R[], if any
    while (j < n2)
    {
        arr[k] = R[j];
        j++;
        k++;
    }
}

// Main Merge Sort function
void mergeSort(std::vector<int>& arr, int left, int right) 
{
    if (left < right) 
    {
        // Find the middle point
        int mid = left + (right - left) / 2;

        // Sort first and second halves
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Merge the sorted halves
        merge(arr, left, mid, right);
    }
}

// =====================================================================================================

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