public class InsertSort
{   
    public static void InsertSort(int[] vetor)
    {
        for (int i = 1; i < vetor.length; i++)
        {   
            int valor = vetor[i];
            int j = i - 1;
            
            while (j >= 0 && vetor[j] > valor)
            {   
                vetor[j + 1] = vetor[j]; 
                j--;
            }
            vetor[j + 1] = valor;
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
        
        InsertSort(vetor);
        
        long elapsedTime = System.nanoTime() - startTime;
        
        System.out.println("Vetor ordenado: ");
        
        for (int e : vetor)
            System.out.printf("%d ", e);
        
        System.out.println("\nTempo: " + (elapsedTime /  1_000_000_000.0) + " segundos");
        System.out.println("Tempo: " + elapsedTime + " nanosegundos");
        
        System.out.printf("\n");
    }
    
}
