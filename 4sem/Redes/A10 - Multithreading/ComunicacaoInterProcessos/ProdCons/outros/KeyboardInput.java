import java.io.*;

public class KeyboardInput {
   public static void main(String[] args) { 
//      String s;
      Integer c;
      String s = new String();
      InputStreamReader ir = new InputStreamReader(System.in);
      BufferedReader in = new BufferedReader(ir);
//      InputStreamReader in = new InputStreamReader(System.in);
      System.out.println("Type ctrl-x to exit");
      try {
//         s = in.readLine();
         c = in.read();
         while(c != -1 ) {
            s = c.toString();
            System.out.println("Read " + s);
//            s = in.readLine();
            c = in.read();
         }
//         while((s = in.readLine()) != null) {
         in.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}