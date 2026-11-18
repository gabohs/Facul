package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class iterator
{
    public static void main(String[] args) 
    {
        ArrayList<String> alunos = new ArrayList<>();
        alunos.add("Ana");
        alunos.add("Bruno");
        alunos.add("Carlos");
        
        Iterator<String> it = alunos.iterator();
        
        while (it.hasNext()) 
        {
            String aluno = it.next();
            System.out.println(aluno);
        }
    }
    
}
