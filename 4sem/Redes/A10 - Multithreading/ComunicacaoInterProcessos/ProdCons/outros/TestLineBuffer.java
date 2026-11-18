import java.io.*;

public class TestLineBuffer {
   public static void main(String[] args) {
// Console é implementada como padrão Singleton
      Console meuConsole = Console.getConsole();

      LineBuffer meuBuffer = new LineBuffer();

      SyncFileManager gerenteArquivo = SyncFileManager.getSyncFileManager("ArquivoTeste.txt");

      KeyBoardReader leitorteclado = new KeyBoardReader(meuConsole, meuBuffer);
      MyFileWriter gravadorarquivo = new MyFileWriter(meuBuffer, gerenteArquivo);
      FileDumper mostrador = new FileDumper(gerenteArquivo, meuConsole);
      Thread tl = new Thread (leitorteclado);
      Thread tg = new Thread (gravadorarquivo);
      Thread tm = new Thread (mostrador);
      
      tl.start();
      tg.start();
      tm.start();
      
      tl.join();
      gravadorarquivo.stopRunning();
      mostrador.stopRunning();
      
/*
      gerenteArquivo.writeLine("Alexandro Adário");
      meuConsole.showLine( "Primeira Escrita" );
      meuConsole.showLine( gerenteArquivo.readLine() );
      gerenteArquivo.writeLine("Daniela Adário");
      meuConsole.showLine( "Segunda Escrita" );
      gerenteArquivo.writeLine("João Adário");
      meuConsole.showLine( "Terceira Escrita" );
      meuConsole.showLine( gerenteArquivo.readLine() );
      gerenteArquivo.writeLine("URI - Campus de Erechim");
      meuConsole.showLine( "Quarta Escrita" );

      meuConsole.showLine( gerenteArquivo.readLine() );
      meuConsole.showLine( gerenteArquivo.readLine() );

      gerenteArquivo3.writeLine("URI - Campus de Erechim");
      meuConsole.showLine( gerenteArquivo3.readLine() );
           
      meuBuffer.put( meuConsole.getLine() );
      meuBuffer.put("Nova linha mesmo, numero 2 no buffer");
      meuBuffer.put( meuConsole.getLine() );

      meuConsole.showLine( meuBuffer.get() );
      meuBuffer.put("Outra nova linha, numero 4 no buffer");

      meuConsole.showLine( meuBuffer.get() );

      meuBuffer.put( meuConsole.getLine() );

      meuConsole.showLine( meuBuffer.get() );
      meuConsole.showLine( meuBuffer.get() );
      meuConsole.showLine( meuBuffer.get() );
*/
   }
}