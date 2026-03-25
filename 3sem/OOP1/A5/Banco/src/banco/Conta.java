package banco;

public class Conta 
{
    protected String nome_titular;
    protected String numero_conta;
    protected double saldo;
    
    public Conta(String nome_titular, String numero_conta, double saldo)
    {
        this.nome_titular = nome_titular;
        this.numero_conta = numero_conta;
        this.saldo        = saldo;
    }
    
    // ---
    
    public String getNomeTitular()
    {
        return this.nome_titular;
    }
    
    public String getNumConta()
    {
        return this.numero_conta;
    }
    
    public double getSaldo()
    {
        return this.saldo;
    }
    
    public void setNomeTitular(String nome)
    {
        this.nome_titular = nome;
    }
    
    public void setNumeroConta(String num)
    {
        this.numero_conta = num;
    }
    
    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }
    
    // -------------
    
    public void depositar(double valor)
    {
        saldo += valor;
    }
    
    public void sacar(double valor)
    {
        if (valor <= this.saldo)
            saldo -= valor;
        else
            System.out.println("Nao ha saldo suficiente!");
    }
    
    public void escrever()
    {
        System.out.println("Nome do titular: " + this.nome_titular);
        System.out.println("Numero da conta: " + this.numero_conta);
        System.out.println("Saldo da conta: "  + this.saldo);
    }
}
