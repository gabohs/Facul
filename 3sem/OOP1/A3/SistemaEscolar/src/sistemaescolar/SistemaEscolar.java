package sistemaescolar;

import java.util.Scanner;

public class SistemaEscolar 
{
    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Numero de disciplinas de cada aluno: ");
        int n_disc = teclado.nextInt();
        
        System.out.print("Numero de notas por disciplina: ");
        int n_notas = teclado.nextInt();
        teclado.nextLine();
        
        String continuar = "SIM";
        while (!continuar.equalsIgnoreCase("NAO"))
        {
            System.out.println("\n=== ADICIONAR ALUNO ==="); 
            Aluno a = new Aluno(n_disc, n_notas);
            
            System.out.print("Nome do aluno: ");
            a.setNome(teclado.nextLine());
            
            System.out.print("Num. da matricula: ");
            a.setNMatricula(teclado.nextLine());
            
            System.out.print("Nome do curso do aluno: ");
            a.setCurso(teclado.nextLine());
            
            String[] disciplinas = new String[a.getNumDisciplinas()];
            for (int i = 0; i < a.getNumDisciplinas(); i++)
            {
                System.out.print("Nome da Disciplina " + (i + 1) + ": ");
                disciplinas[i] = teclado.nextLine();
            }
            
            a.setDisciplinas(disciplinas);
            
            double[][] notas = new double[a.getNumDisciplinas()][a.getNumNotas()];
            for (int i = 0; i < a.getNumDisciplinas(); i++)
            {
                System.out.println("Digite as " + n_notas + " notas da disciplina " + disciplinas[i]);
                for (int j = 0; j < a.getNumNotas(); j++)
                {
                    notas[i][j] = teclado.nextDouble();
                }
                teclado.nextLine();
            }
            
            a.setNotas(notas);
            
            a.print_aluno();

            System.out.print("Voce quer inserir outro aluno?: ");
            continuar = teclado.nextLine();
        }
    }
    
}
