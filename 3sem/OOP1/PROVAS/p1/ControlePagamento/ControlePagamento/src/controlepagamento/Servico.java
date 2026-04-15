package controlepagamento;

public class Servico 
{
    protected String descricao;
    protected double valor_base;

    //construtores
    public Servico()
    {}
    
    public Servico(String descricao, double valor_base) 
    {
        this.descricao  = descricao;
        this.valor_base = valor_base;
    }

    // getters
    public String getDescricao() 
    {
        return this.descricao;
    }

    public double getValor_base() 
    {
        return this.valor_base;
    }

    // setters
    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }

    public void setValor_base(double valor_base) 
    {
        this.valor_base = valor_base;
    }
    
    // calcular pagamento
    public double calcularPagamento()
    {
        return this.valor_base;
    }
    
    public void escrever()
    {
        System.out.println("Descricao: " + this.descricao);
        System.out.println("Valor base: " + this.valor_base);
    }
}
