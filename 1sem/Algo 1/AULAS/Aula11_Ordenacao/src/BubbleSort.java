public class BubbleSort
{   
    public static void BubbleSort(int[] vetor)
    {   
        int troca;
        
        for (int i = 0; i < vetor.length - 1; i++)
        {
            for (int j = 0; j < vetor.length - i - 1; j++)
            {
                if (vetor[j] > vetor[j + 1])
                {
                    troca = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = troca;
                }
            }
        }
    }
    
    public static void O_BubbleSort(int[] vetor) // otimizado para parar se nao acontecerem trocas na rodada
    {
        int troca;
        
        for (int i = 0; i < vetor.length - 1; i++)
        {   
            boolean fezTroca = false;
            
            for (int j = 0; j < vetor.length - i - 1; j++)
            {
                if (vetor[j] > vetor[j + 1])
                {   
                    fezTroca = true;
                    
                    troca = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = troca;
                }
            }
            
            if (!fezTroca)
                break;
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
        
        O_BubbleSort(vetor);
        
        long elapsedTime = System.nanoTime() - startTime;
        
        System.out.println("Vetor ordenado: ");
        
        for (int e : vetor)
            System.out.printf("%d ", e);
        
        System.out.println("\nTempo: " + (elapsedTime /  1_000_000_000.0) + " segundos");
        System.out.println("Tempo: " + elapsedTime + " nanosegundos");
        
        System.out.printf("\n");
    }
}
