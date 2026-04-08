package cadastroprodutos;

public class Produto 
{
    protected String descricao;
    protected double valor;
    
    public Produto(String desc, double valor)
    {
        this.descricao = desc;
        this.valor     = valor;
    }
    
    public double calcularValorFinal()
    {
        return this.valor;
    }
    
    public void exibir()
    {
        System.out.println("DESCRICAO:\t" + this.descricao);
        System.out.println("VALOR:\t\t" + this.valor);
    }
    
    // --------------------------------------------------
    
    public String getDescricao()
    {
        return this.descricao;
    }
    
    public double getValor()
    {
        return this.valor;
    }
    
    public void setDescricao(String desc)
    {
        this.descricao = desc;
    }
    
    public void setValor(double valor)
    {
        this.valor = valor;
    }
}
