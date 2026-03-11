package bilhetes;

public class Bilhetes 
{
    public static void main(String[] args) 
    {
        MaquinaBilhetes mb = new MaquinaBilhetes(12.50);
        
        System.out.println("Preco bilhete: " + mb.getPreco());
        
        mb.inserir_dinheiro(2 * 12.5);
        
        System.out.println("Saldo atual: " + mb.getSaldo());
        
        mb.imprimir_bilhete();
        
        System.out.println("Saldo atual: " + mb.getSaldo());
        System.out.println("Total: " + mb.getTotal());
        
        // --------------------------------------
        System.out.println("\n-------------------------------");
        System.out.println("Maquina 2");
        
        MaquinaBilhetes mb2 = new MaquinaBilhetes(21.99);
        
        mb2.imprimir_bilhete();
        
        
        System.out.println("Saldo atual: " + mb2.getSaldo());
        System.out.println("Total: " + mb2.getTotal());
        
    } 
}
