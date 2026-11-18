package observer;

public class Principal 
{
    public static void main(String[] args) 
    {
        Canal canal = new Canal();
        Usuario u1 = new Usuario("Ana");
        Usuario u2 = new Usuario("Bruno");
        Usuario u3 = new Usuario("Carlos");

        canal.inscrever(u1);
        canal.inscrever(u2);
        canal.inscrever(u3);
        
        canal.publicar("Nova aula de Java disponível!");
    }
    
}
