package observer;

import java.util.ArrayList;
import java.util.List;

public class Canal
{
    private List<Observer> observadores = new ArrayList<>();

    public void inscrever(Observer observador) 
    {
        observadores.add(observador);
    }

    public void publicar(String mensagem) 
    {
        System.out.println("\nNova mensagem publicada!");

        for (Observer observador : observadores) 
            observador.atualizar(mensagem);
    }
}
