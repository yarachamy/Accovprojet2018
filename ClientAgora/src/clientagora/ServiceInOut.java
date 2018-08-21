
package clientagora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yara
 */
public class ServiceInOut implements Runnable {

    private final String _arret;
    private final PrintWriter _out;
    private final BufferedReader _in;
    private  String Couleur ;

    public ServiceInOut(BufferedReader in, PrintWriter out,String arret,String Couleur) {
        _in = in;
        _out = out;
        _arret=arret;
        this.Couleur=Couleur;
    }

    @Override
    public void run() {
        while(true){
        try {
            System.out.println("I am Eating Honey suckle and Training");
              try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServiceInOut.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("I am going to the mail");
              try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServiceInOut.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("I am going to mute And My color is : "+Couleur);
              try {
                Thread.sleep(2500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServiceInOut.class.getName()).log(Level.SEVERE, null, ex);
            }
            String line;
            _out.printf("%s\n", Couleur);
            _out.flush();
            if ((line = _in.readLine()) != null) {               
                this.Couleur=line;
                System.out.println("Mutation Completed... My new color is : "+Couleur);
              
            }
        } catch (IOException ex) {
            Logger.getLogger(ServiceInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        }
    }

}
