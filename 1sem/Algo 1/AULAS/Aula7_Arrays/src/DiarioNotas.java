import java.util.Scanner;

public class DiarioNotas
{
    public static void main(String[] args)
    {   
        Scanner leitor = new Scanner(System.in);
        
        String[] alunos = new String[5];
        double[][] notas = new double[5][3];
        
        for (int n_aluno = 0; n_aluno < alunos.length; n_aluno++)
        {
            System.out.println("Nome do(a) aluno(a) " + n_aluno + ": ");
            alunos[n_aluno] = leitor.nextLine();
        }  
        
        for (int n_aluno = 0; n_aluno < alunos.length; n_aluno++)
        {   
            System.out.println("\n=== Notas do(a) estudante " + alunos[n_aluno] + " ===");
            for (int n_nota = 0; n_nota < notas[n_aluno].length; n_nota++)
            {
                System.out.print("> Nota  " + n_nota + ": ");
                notas[n_aluno][n_nota] = leitor.nextDouble();
            }
        }
        
        // Calculo da media por estudante
        double[] medias = new double[5];
        
        for (int n_aluno = 0; n_aluno < alunos.length; n_aluno++)
        {   
            double media = 0;
            for (int n_nota = 0; n_nota < notas[n_aluno].length; n_nota++)
            {
                media += notas[n_aluno][n_nota];
            }
            media /= notas[n_aluno].length; 
            medias[n_aluno] = media;
        }
        
        // Calculo da media por avalicao
        double[] medias_avaliacao = new double[3];
        
        for (int n_nota = 0; n_nota < medias_avaliacao.length; n_nota++)
        {   
            double media = 0;
            for (int n_aluno = 0; n_aluno < notas.length; n_aluno++)
            {
                media += notas[n_aluno][n_nota];
            }
            media /= medias_avaliacao.length; 
            medias_avaliacao[n_nota] = media;
        }
        
        // relatorio do diario de notas
        for (int n_aluno = 0; n_aluno < alunos.length; n_aluno++)
        {   
            System.out.printf("%-25s ", alunos[n_aluno]);
            for (int n_nota = 0; n_nota < notas[n_aluno].length; n_nota++)
            {
                System.out.printf("%4.1f ", notas[n_aluno][n_nota]);
            }
            System.out.printf("%4.1f \n", medias[n_aluno]);
        }
    }   
}
