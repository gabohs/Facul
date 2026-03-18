package loja;

public class Loja 
{
    public static void main(String[] args) 
    {
        Livro livro = new Livro("Java", 99.90, "Pedrinho", 600);
        Produto prod = new Produto("Bicicleta com rodas quadradas", 999.90);
        
        System.out.println("LIVRO: " + livro.getNome());
        System.out.println("Por: " + livro.getAutor());
        System.out.print("Paginas: " + livro.getPaginas() + "\t");
        System.out.println("Grande? " + (livro.ehGrande() ? "Sim" : "Nao") );
        
        System.out.print("Preco: " + livro.getPreco() + "\t");
        System.out.println("Caro?: " + (livro.ehCaro() ? "Sim\n" : "Nao\n") );
        
        // --------------------------------------------------------------------------
        
        System.out.println("PRODUTO: " + prod.getNome());
        System.out.println("Preco: " + prod.getPreco() + "\t");
        System.out.print("Caro?: " + (prod.ehCaro() ? "Sim\n" : "Nao\n") );    
    }
    
}
