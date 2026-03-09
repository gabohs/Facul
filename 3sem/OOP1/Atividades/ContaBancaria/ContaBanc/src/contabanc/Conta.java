package contabanc;

public class Conta 
{
    // 1: atributos da classe conta
    private int numero;
    private String dono;
    private double saldo;
    private double limite;
    
    // 2: construtor
    public Conta(int numero, String dono, double saldo, double limite)
    {
        this.numero = numero;
        this.dono   = dono;
        this.saldo  = saldo;
        this.limite = limite;
    }
    
    // 3: metodos acessores
    public int getNumero()
    {
        return this.numero;
    }
    
    public String getDono()
    {
        return this.dono;
    }
    
    public double getSaldo()
    {
        return this.saldo;
    }
    
    public double getLimite()
    {
        return this.limite;
    }
    
    // 4: metodos mutantes
    public void setNumero(int numero)
    {
        this.numero = numero;
    }
    
    public void setDono(String dono)
    {
        this.dono = dono;
    }
    
    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }
    
    public void setLimite(double limite)
    {
        this.limite = limite;
    }
    
    // 5: metodo sacar e depositar
    public void sacar(double valor)
    {
        if (valor > this.limite)
            return;
        
        this.saldo -= valor;
    }
    
    public void depositar(double valor)
    {
        this.saldo += valor;
    }
    
}
