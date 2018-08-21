/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientagora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Yara
 */
public class ClientAgora {

    private static BufferedReader getInput(InputStream is) throws IOException {
        return new BufferedReader(new InputStreamReader(is));
    }

    private static BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    private static PrintWriter getoutput(Socket p) throws IOException {
        
        return new PrintWriter(new OutputStreamWriter(p.getOutputStream()), true);
    }

    
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket l = null;
        try {
            l = new Socket("localhost", 2010);
            System.out.println(l.getLocalSocketAddress());
            BufferedReader ir = getInput(l);
            PrintWriter envoyer = getoutput(l);
            String Couleur=args[0];
            System.out.println(Couleur);
            Thread lireSockStdOut= 
                    new Thread (new ServiceInOut(ir, envoyer, ".",Couleur));
          
            lireSockStdOut.start();
     
            lireSockStdOut.join();
        } finally {
            if (l != null) {
                l.close();
            }
        }
    }

}
