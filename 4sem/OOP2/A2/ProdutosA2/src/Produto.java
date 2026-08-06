public class Produto 
{
    private String nome;
    private double preco;
    
    public Produto(String nome, double preco)
    {
        this.nome = nome;
        this.preco = preco;
    }
    
    @Override
    public String toString()
    {
        return this.nome + " | preco: " + this.preco;
    }
    
    public String getNome() { return this.nome; }
    public double getPreco() { return this.preco; }
    
    public void setNome(String n) { this.nome = n; }
    public void setPreco(Double p) { this.preco = p; }
}
