
package agora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Yara
 */
public class InfoClients {
    
    private Socket serviceClientSocket;
    private String couleur;
    
    private final BufferedReader reader;

    
    private final PrintWriter writer;
    
    public InfoClients(Socket s) throws IOException {
        serviceClientSocket=s;
        reader = getInput(s);
        writer = getoutput(s);
        couleur=null;
    }

    final BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    final PrintWriter getoutput(Socket p) throws IOException {
        return new PrintWriter(new OutputStreamWriter(p.getOutputStream()),true);
    }
    
    public Socket getServiceClientSocket() {
        return serviceClientSocket;
    }

    public void setServiceClientSocket(Socket serviceClientSocket) {
        this.serviceClientSocket = serviceClientSocket;
    }
public String getCouleur() {
        return couleur;
    }
  public void setCouleur(String Couleur) {
        this.couleur = Couleur;
    }
    
    public BufferedReader getReader() {
        return reader;
    }

   
    public PrintWriter getWriter() {
        return writer;
    }

}
