public class QuickSort
{   
    public static void swap(String[] vetor, int i, int j)
    {
        String temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
    
    public static int partition(String[] vetor, int inicio, int fim)
    {
        String pivo = vetor[fim];
        int i = inicio - 1;
        
        for (int j = inicio; j < fim; j++)
        {
            if ( vetor[j].compareTo(pivo) <= 0 )
            {
                i++;
                swap(vetor, i, j);            
            }
        }
        
        swap(vetor, i + 1, fim);
        
        return i + 1;
    }
    
    public static void quickSort(String[] vetor, int inicio, int fim)
    {
        if (inicio < fim)
        {
            int pivoIndex = partition(vetor, inicio, fim);
            quickSort(vetor, inicio, pivoIndex - 1);
            quickSort(vetor, pivoIndex + 1, fim);
        }
    }
    
    public static void main(String[] args)
    {
        String[] nomes = {
            "Jean", "Maria", "Daniel", "Emanuel", "Leticia", "Marlon", "Guilherme", "Vitor", "Miguel", "Fabio", "Ariel", "Alis", "Arthur", "Yan",
            "Joao", "Matheus", "Raquel", "Leonardo", "Diogo", "Ricardo"
        };
        
        System.out.println("Vetor original:");
        for (String nome : nomes) 
            System.out.print(nome + "  ");
        
        long startTime = System.nanoTime();
        
        quickSort(nomes, 0, nomes.length - 1);
        
        long elapsedTime = System.nanoTime() - startTime;
        
        System.out.println("\n\nVetor ordenado:");
        for (String nome : nomes) 
            System.out.print(nome + "  "); 
        
        System.out.println("\n\nTempo de execucao do QuickSort:");
        System.out.println((elapsedTime /  1_000_000_000.0) + " segundos");
        System.out.println(elapsedTime + " nanosegundos");
    }
    
}
