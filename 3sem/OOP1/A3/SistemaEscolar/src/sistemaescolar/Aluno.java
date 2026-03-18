package sistemaescolar;

public class Aluno 
{
    private String nome;
    private String num_matricula;
    private String curso;
    
    private int num_disciplinas;
    private String[] disciplinas;
    
    private int num_notas;
    private double[][] notas;
    

    public Aluno(int num_disciplinas, int num_notas)
    {        
        this.num_disciplinas = num_disciplinas;
        this.num_notas = num_notas;
        
        this.disciplinas = new String[num_disciplinas];
        this.notas = new double[num_disciplinas][num_notas];
    }
    
    // ----------------------------------------------------------------------
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getMatricula()
    {
        return this.num_matricula;
    }
    
    public String getCurso()
    {
        return this.curso;
    }
    
    public int getNumDisciplinas()
    {
        return this.num_disciplinas;
    }
    
    public int getNumNotas()
    {
        return this.num_notas;
    }
    
    public String[] getDisciplinas()
    {
        return this.disciplinas;
    }
    
    public double[][] getNotas()
    {
        return this.notas;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setNMatricula(String matr)
    {
        this.num_matricula = matr;
    }
    
    public void setCurso(String curso)
    {
        this.curso = curso;
    }
    
    public void setDisciplinas(String[] disciplinas)
    {
        this.disciplinas = disciplinas;
    }
    
    public void setNotas(double[][] notas)
    {
        this.notas = notas;
    }
    
    // ----------------------------------------------------------------------
    
    public double calcula_media_disciplina(int num_disciplina)
    {
        double soma_notas = 0;
        for (int i = 0; i < num_notas; i++)
        {
            soma_notas += notas[num_disciplina][i];
        }
        
        double media = soma_notas / num_notas;
        
        return media;
    }
    
    public boolean esta_aprovado_disciplina(int num_disciplina)
    {
        if ( calcula_media_disciplina(num_disciplina) < 7)
            return false;
        
        return true;         
    }
    
    public void print_aluno()
    {
        System.out.println("=================================");
        System.out.println("## Info do aluno ##");
        System.out.println("Nome:         " + this.nome);
        System.out.println("N. Matricula: " + this.num_matricula);
        System.out.println("Curso:        " + this.curso);
        
        System.out.println("\n----- BOLETIM de " + this.nome + " -----");
        for (int i = 0; i < this.num_disciplinas; i++)
        {
            System.out.println("Disciplina: " + this.disciplinas[i]);
            
            
            for (int j = 0; j < this.num_notas; j++)
            {
                System.out.print("Nota " + (j + 1) + "\t");
            }
            
            System.out.println("MEDIA\t" + "Status");  
            
            for (int j = 0; j < this.num_notas; j++)
            {
                System.out.print(String.format("%.2f", notas[i][j]) + "\t");
            }
            
            System.out.print(String.format("%.2f", this.calcula_media_disciplina(i)) + "\t" + (this.esta_aprovado_disciplina(i) ? "Aprovado" : "Reprovado"));
            
            System.out.print("\n");
        }
        
        System.out.println("=================================");
    }
    
}
