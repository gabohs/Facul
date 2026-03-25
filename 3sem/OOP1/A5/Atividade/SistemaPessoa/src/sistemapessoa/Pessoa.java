package sistemapessoa;

public class Pessoa 
{
    private String nome;
    private String endereco;
    private String telefone;
    
    public Pessoa(String nome, String endereco, String telefone)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getEndereco()
    {
        return this.endereco;
    }
    
    public String getTelefone()
    {
        return this.telefone;
    }
    
    public void setNome(String n)
    {
        this.nome = n;
    }
    
    public void setEndereco(String e)
    {
        this.endereco = e;
    }
    
    public void setTelefone(String t)
    {
        this.telefone = t;
    }
    
    // -----------------------------------
    
    public void escrever()
    {
        System.out.println("Nome:     " + this.nome);
        System.out.println("Endereco: " + this.endereco);
        System.out.println("Telefone: " + this.telefone);
    }
}
