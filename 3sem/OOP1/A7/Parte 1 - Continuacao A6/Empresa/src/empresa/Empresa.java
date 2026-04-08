package empresa;

public class Empresa 
{
    public static void main(String[] args) 
    {
        Funcionario f1 = new Funcionario();
        f1.setNome("Adario Dario Ernani Andre da Silva");
        f1.setCpf("12345678901");
        f1.setSalario(100);
        
        f1.escrever();
        System.out.println("Bonificação: " + f1.calcularBonificacao());
        System.out.println("");
        
        // ------------------------------------------------------------------
        
        Gerente f2 = new Gerente();
        f2.setNome("Ricardo Emanuel Diogo Pereira");
        f2.setCpf("20660491014");
        f2.setSalario(200);
        
        f2.setSenha(123);
        if (f2.autentica(123))   
        {
            System.out.println("Gerente");
            f2.escrever();
            System.out.println("Bonificação: " + f2.calcularBonificacao());
        } 
        else 
            System.out.println("A senha está incorreta");
        
        // ------------------------------------------------------------------
        
        ControleDeBonificacoes controle = new ControleDeBonificacoes();
        controle.registra(f1);
        controle.registra(f2);
        
        System.out.println("");
        System.out.println("O total de bonificacoes eh: " + controle.getTotalDeBonificacoes());
        
    }
}
