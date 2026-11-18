public class ItemNota 
{
    private int idItem;
    private String descricao;
    private int quantidade;
    private double precoUnitario;

    public ItemNota(int idItem, String descricao, int quantidade, double precoUnitario) 
    {
        this.idItem = idItem;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
    
    

    public int getIdItem() { return idItem; }
    public String getDescricao() { return descricao; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }

    public void setIdItem(int idItem) { this.idItem = idItem; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }
    
    
}
