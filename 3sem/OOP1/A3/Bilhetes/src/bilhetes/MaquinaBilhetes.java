package bilhetes;


public class MaquinaBilhetes 
{
    private double preco;
    public double saldo;
    public double total;
    
    public MaquinaBilhetes(double preco)
    {
        this.preco = preco;
        this.saldo = 0;
        this.total = 0;
    }
    
    // -------------------------------------
    
    public double getPreco()
    {
        return this.preco;
    }
    
    public double getSaldo()
    {
        return this.saldo;
    }
    
    public double getTotal()
    {
        return this.total;
    }
    
    public void setPreco(double p)
    {
        this.preco = p;
    }
    
    public void setSaldo(double s)
    {
        this.saldo = s;
    }
    
    public void setTotal(double t)
    {
        this.total = t;
    }
    
    // -------------------------------------
    
    public void inserir_dinheiro(double valor)
    {
        this.saldo += valor;
    }
    
    public void imprimir_bilhete()
    {
        if (this.saldo < this.preco)
        {
            System.out.println("\nSaldo insuficiente. Nao e possivel comprar o bilhete");
            return;
        }
        
        String preco_formatado = String.format("%.2f", this.preco);
        
        System.out.println("###################");
        System.out.println("# Bilhete de Trem #");
        System.out.println("# Preço R$ " + preco_formatado + "  #");
        System.out.println("###################");
        
        this.total += this.preco;
        this.saldo -= this.preco;
    }
}
