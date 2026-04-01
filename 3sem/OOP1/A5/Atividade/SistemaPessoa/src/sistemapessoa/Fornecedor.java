package sistemapessoa;

public class Fornecedor extends Pessoa
{
    private double valorCredito;
    private double valorDivida;
    
    public Fornecedor(String nome, String endereco, String telefone, double vcred, double vdiv)
    {
        super(nome, endereco, telefone);
        this.valorCredito = vcred;
        this.valorDivida  = vdiv;
    }
    
    public double getValorCredito()
    {
        return this.valorCredito;
    }
    
    public double getValorDivida()
    {
        return this.valorDivida;
    }
    
    public void setValorCredito(double vcred)
    {
        this.valorCredito = vcred;
    }
    
    public void setValorDivida(double vdiv)
    {
        this.valorDivida = vdiv;
    }
    
    // ---------
    
    public double obterSaldo()
    {
        return this.valorCredito - valorDivida;
    }
    
    @Override
    public void escrever()
    {
        super.escrever();
        System.out.println("Valor Credito: " + this.valorCredito);
        System.out.println("Valor Divida:  " + this.valorDivida);
        System.out.println("Saldo:         " + obterSaldo());
    }
    
    @Override
    public String toString()
    {
        super.toString();
        return "Fornecedor{vCred: " + this.valorCredito + ", vDiv: " + this.valorDivida + ", saldo: " + this.obterSaldo() + "}";
    }
    
}
