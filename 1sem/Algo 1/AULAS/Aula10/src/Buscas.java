public class Buscas
{
    public static int BuscaBinaria(String[] conjunto, int inicio, int fim, String chave)
    {
        int pivo = (inicio + fim) / 2;
        
        if (inicio > fim)
            return -1; // chave nao encontrada. Acabou o conjunto de busca
        else
        
            if (conjunto[pivo].equals(chave))
                return pivo;
            else
                if (conjunto[pivo].compareTo(chave) < 0) // pivo menor q a chave; devemos ir para a direita
                    return BuscaBinaria(conjunto, pivo + 1, fim, chave);
                else
                    return BuscaBinaria(conjunto, inicio, pivo - 1, chave);
    }
    
    public static void main(String[] args)
    {
        
    }
}
