public class SelectionSort
{   
    public static void SelectionSort(int[] vetor)
    {
        for (int i = 0; i < vetor.length - 1; i++) // num de rodadas
        {
            int indice_minimo = i;
            
            for (int j = i + 1; j < vetor.length; j++) // num de comparacoes
            {
                if (vetor[j] < vetor[indice_minimo])
                    indice_minimo = j;    
            }
            int temp = vetor[indice_minimo];
            vetor[indice_minimo] = vetor[i];
            vetor[i] = temp;
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
        
        SelectionSort(vetor);
        
        long elapsedTime = System.nanoTime() - startTime;
        
        System.out.println("Vetor ordenado: ");
        
        for (int e : vetor)
            System.out.printf("%d ", e);
        
        System.out.println("\nTempo: " + (elapsedTime /  1_000_000_000.0) + " segundos");
        System.out.println("Tempo: " + elapsedTime + " nanosegundos");
        
        System.out.printf("\n");
    }
    
}
