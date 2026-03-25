package sistemapessoa;

public class Fornecedor extends Pessoa
{
    private double valor_credito;
    private double valor_divida;
    
    public Fornecedor(String nome, String endereco, String telefone, double vcred, double vdiv)
    {
        super(nome, endereco, telefone);
        this.valor_credito = vcred;
        this.valor_divida  = vdiv;
    }
    
    public double getValorCredito()
    {
        return this.valor_credito;
    }
    
    public double getValorDivida()
    {
        return this.valor_divida;
    }
    
    public void setValorCredito(double vcred)
    {
        this.valor_credito = vcred;
    }
    
    public void setValorDivida(double vdiv)
    {
        this.valor_divida = vdiv;
    }
    
    // ---------
    
    public double obterSaldo()
    {
        return this.valor_credito - valor_divida;
    }
    
    @Override
    public void escrever()
    {
        super.escrever();
        System.out.println("Valor Credito: " + this.valor_credito);
        System.out.println("Valor Divida:  " + this.valor_divida);
        System.out.println("Saldo:         " + obterSaldo());
    }
    
}
