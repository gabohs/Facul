import java.util.ArrayList;

public class UsandoListas
{   
    public static void info(ArrayList<String> lista)
    {
        System.out.println("\n--------------------------------");
        System.out.println("[INFO] Tamanho atual: " + lista.size());
        System.out.println("[INFO] Esta vazia? "    + lista.isEmpty()); 
    }
    public static void printLista(ArrayList<String> lista)
    {
        for (int i = 0; i < lista.size(); i++)
        {
            System.out.println("Elemento " + i + ":" + lista.get(i));
        }
    }
    
    public static void main(String[] args)
    {
        ArrayList<String> lista = new ArrayList();
        
        info(lista);
        
        lista.add("Erechim");
        lista.add("Passo fundo");
        lista.add("Sertao");
        
        info(lista);
        printLista(lista);
        
        lista.add(1, "Getulio Vargas");
        
        info(lista); 
        printLista(lista);
        
        lista.remove(2);
        
        info(lista);
        printLista(lista);
        
        lista.set(1, "Estacao");
        
        info(lista);
        printLista(lista);
        
        lista.clear();
        info(lista);
    }
    
}
