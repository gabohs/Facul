package cupomsupermercado;


public class Item 
{
    // ATRIBUTOS ---------------------------------------------------------------
    String codigo;
    String descricao;
    int quantidade;
    double desconto;
    double preco_unitario;
    
    //METODOS ------------------------------------------------------------------
    // construtor
    public Item(String codigo, String descricao, int quantidade, double desconto, double preco_unitario)
    {
        this.codigo         = codigo;
        this.descricao      = descricao;
        this.quantidade     = quantidade;
        this.desconto       = desconto;
        this.preco_unitario = preco_unitario;
    }
    
    public double calcular_valor_bruto()
    {
        return this.quantidade * this.preco_unitario;
    }
    
    public double calcular_desconto()
    {
        return (this.quantidade * this.preco_unitario) * (this.desconto / 100);
    }
    
    public double calcular_valor_final()
    {
        return this.calcular_valor_bruto() - this.calcular_desconto();
    }
}
