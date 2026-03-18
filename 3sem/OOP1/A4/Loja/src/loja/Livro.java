package loja;

public class Livro extends Produto 
{
    private String autor;
    private int paginas;
    
    public Livro(String nome, double preco, String autor, int paginas)
    {
        super(nome, preco);
        
        this.autor   = autor;
        this.paginas = paginas;
    }
    
    public String getAutor()
    {
        return this.autor;
    }
    
    public int getPaginas()
    {
        return this.paginas;
    }
    
    public boolean ehGrande()
    {
        return (paginas > 200);
    }
}
