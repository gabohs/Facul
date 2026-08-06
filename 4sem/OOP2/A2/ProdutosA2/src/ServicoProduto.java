import java.util.ArrayList;

public class ServicoProduto 
{
    private ArrayList<Produto> lista = new ArrayList();
    
    public void adicionarProduto(Produto p)
    {
        lista.add(p);
    }
    
    public Produto buscarProduto(int indice)
    {
        return lista.get(indice - 1);
    }
    
    public ArrayList<Produto> listarProduto()
    {
        return lista;
    }
    
    public void removerProduto(int indice)
    {
        lista.remove(indice - 1);
    }
    
    public void limparLista()
    {
        lista.clear();
    }
}
