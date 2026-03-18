package loja;

public class Produto 
{
    protected String nome;
    protected double preco;
    
    Produto () {}
    
    public Produto(String nome, double preco)
    {
        this.nome = nome;
        this.preco = preco;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public double getPreco()
    {
        return this.preco;
    }
    
    public boolean ehCaro()
    {
        return (preco > 100);
    }
}
