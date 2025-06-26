public class MergeSort
{   
    public static void merge(int[] vetor, int inicio, int meio, int fim)
    {
        int[] metade1 = new int[ meio - inicio + 1 ]; 
        int[] metade2 = new int[ fim - meio ];
        
        for (int i = 0; i < metade1.length; i++)
            metade1[i] = vetor[inicio + i];
        
        for (int i = 0; i < metade2.length; i++)
            metade2[i] = vetor[meio + 1 + i];
        
        int i = 0, j = 0, k = inicio;
        while (i < metade1.length && j < metade2.length)
        {
            if (metade1[i] <= metade2[j])
                vetor[k] = metade1[ i++ ];
            else
                vetor[k] = metade2[ j++ ];
            
            k++;
        }
        
        while (i < metade1.length)
        {
            vetor[k] = metade1[i];
            k++;
            i++;
        }
        
        while (j < metade2.length)
        {
            vetor[k] = metade2[j];
            k++;
            j++;
        }
    }
    
    public static void MergeSort(int[] vetor, int inicio, int fim)
    {
        if (inicio < fim)
        {
            int meio = (inicio + fim) / 2;
            MergeSort(vetor, inicio, meio);
            MergeSort(vetor, meio + 1, fim);
            
            merge(vetor, inicio, meio, fim);
        }
       
    }
    
    public static void main(String[] args)
    {
        int[] vetor = {47, 13, 1, 85, 24, 36, 5, 2}; 
        System.out.println("Vetor original: ");
        
        for (int e : vetor)
            System.out.printf("%d ", e);
        
        System.out.printf("\nTamanho: %d\n\n", vetor.length);
        
        long startTime = System.nanoTime();
        
        MergeSort(vetor, 0, vetor.length - 1);
        
        long elapsedTime = System.nanoTime() - startTime;
        
        System.out.println("Vetor ordenado: ");
        
        for (int e : vetor)
            System.out.printf("%d ", e);
        
        System.out.println("\nTempo: " + (elapsedTime /  1_000_000_000.0) + " segundos");
        System.out.println("Tempo: " + elapsedTime + " nanosegundos");
        
        System.out.printf("\n");
    }
    
}
