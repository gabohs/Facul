public class Produto implements Exibivel 
{
    private String nome;
    private double preco;
    
    public Produto(String nome, double preco)
    {
        this.nome = nome;
        this.preco = preco;
    }
    
    @Override
    public String mostrarDados()
    {
        return "Nome: " + this.nome + "  |  Preco: " + this.preco;
    }
    
    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public double getPreco() { return this.preco; }
    public void setPreco(double preco) { this.preco = preco; }
}
