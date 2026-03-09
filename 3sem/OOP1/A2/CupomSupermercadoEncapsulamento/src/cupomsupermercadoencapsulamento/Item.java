package cupomsupermercadoencapsulamento;

public class Item 
{
    private String codigo;
    private String descricao;
    private int    quantidade;
    private double desconto;
    private double preco_unitario;
    
    public Item(String codigo, String descricao, int quantidade, double desconto, double preco_unitario)
    {
        this.codigo         = codigo;
        this.descricao      = descricao;
        this.quantidade     = quantidade;
        this.desconto       = desconto;
        this.preco_unitario = preco_unitario;
    }
    
    public Item()
    {
    }
    
    public Item(String codigo, String descricao)
    {
        this.codigo         = codigo;
        this.descricao      = descricao;
        this.quantidade     = 0;
        this.desconto       = 0;
        this.preco_unitario = 0;
    }
    
    // --------------------------------------------------------------------------------
    
    public String getCodigo()
    {
        return this.codigo;
    }
    
    public String getDescricao()
    {
        return this.descricao;
    }
    
    public int getQuantidade()
    {
        return this.quantidade;
    }
    
    public double getDesconto()
    {
        return this.desconto;
    }
    
    public double getPrecoUnitario()
    {
        return this.preco_unitario;
    }
    
    // --------------------------------------------------------------------------------
    
    public void setCodigo(String s)
    {
        this.codigo = s;
    }
    
    public void setDescricao(String s)
    {
        this.descricao = s;
    }
    
    public void setQuantidade(int q)
    {
        this.quantidade = q;
    }
    
    public void setDesconto(double d)
    {
        this.desconto = d;
    }
    
    public void setPrecoUnitario(double p)
    {
        this.preco_unitario = p;
    }
    
    // --------------------------------------------------------------------------------
    
    public double calcular_valor_bruto()
    {
        return this.quantidade * this.preco_unitario;
    }
    
    public double calcular_desconto()
    {
        return this.calcular_valor_bruto() * (this.desconto / 100);
    }
    
    public double calcular_valor_final()
    {
        return this.calcular_valor_bruto() - this.calcular_desconto();
    }
}

