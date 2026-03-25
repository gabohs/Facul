package banco;

public class Banco 
{
    public static void main(String[] args) 
    {
        Conta conta = new Conta("Dario", "001", 10000);
        conta.escrever();
        
        conta.sacar(3000);
        conta.depositar(2000);
        
        System.out.print("\n");
        conta.escrever();
        
        System.out.print("\n\n");
        
        // ----------------------------------
        
        ContaCorrente cc = new ContaCorrente("Ricardo", "002", 30000, 50000);
        cc.escrever();
        System.out.print("\n");
        
        cc.depositar(500000);
        cc.sacar(10000000);
        
        System.out.print("\n");
        cc.escrever();
        
    }
    
}
