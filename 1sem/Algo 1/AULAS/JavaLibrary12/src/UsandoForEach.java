import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;

public class UsandoForEach
{
    public static void main(String[] args)
    {
        String[] cidades = {
            "Erechim", "Getulio Vargas", "Estacao", "Passo Fundo", "Sertao"
        };
        
        for (String item : cidades)
        {
            System.out.println(item); 
        }
        
        System.out.println("\n-------------- ARRAY LIST -------------\n");
        
        ArrayList<String> lista = new ArrayList( Arrays.asList(cidades) );
        
        for (String s : lista)
        {
            System.out.println(s);
        }
        
        System.out.println("\n-------------- FILA -------------\n");
        
        LinkedList<String> fila = new LinkedList( Arrays.asList(cidades) );
        
        for (String s : fila)
        {
            System.out.println(s);
        }
        
        System.out.println("\n-------------- STACK -------------\n");
        
        Stack<String> pilha = new Stack();
        pilha.addAll(lista);
        
        for (String s : pilha)
        {
            System.out.println(s);
        }
    }
    
}
