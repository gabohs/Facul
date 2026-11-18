import java.io.*;

public class KeyboardInput2 {
   public static void main(String[] args) { 
      int c;
      int num;
      char s = '0';

      InputStreamReader ir = new InputStreamReader(System.in);
      System.out.println("Type ctrl-x to exit");
      try {
         while( s != '-') {
            if( (num = System.in.available()) > 0) {
                System.out.println(num);
                c =  ir.read();
                s = (char) c;
                System.out.println("\nRead " + s);
            }
         }
/*         c =  ir.read();
         while(c >= 0 ) {
            s = (char) c;
            System.out.print("Read " + s);
            c = ir.read();
         }
*/
         ir.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}