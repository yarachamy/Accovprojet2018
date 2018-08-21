
package agora;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yara
 */
public class GestionListeClients {
    List<InfoClients> listeClients;
    int waintingcount;
    
    public GestionListeClients() {
        listeClients = new ArrayList<>();
        waintingcount=0;
    }
    
    public void add(InfoClients c){
        listeClients.add(c);
    }
    public int getwaiting() {
        return waintingcount;
    }
  public void addwaiting( ) {
     waintingcount++;
    }
    public void remove(InfoClients c) throws IOException{
        c.getReader().close();
        c.getWriter().close();
        c.getServiceClientSocket().close();
        listeClients.remove(c);
    }
    
    public synchronized void mutate(InfoClients icc,String Couleur) {
        for (InfoClients ic : listeClients ) {
            if (ic.getCouleur()!=null){
                if(ic.getCouleur().equals(Couleur)){
                    ic.getWriter().println(Couleur);
                     icc.getWriter().println(Couleur);
                     System.out.println("Mutation Completed... New Color : "+ Couleur);
                      ic.setCouleur(null);
                waintingcount--;
                }
                else if((Couleur.equals("Red") && ic.getCouleur().equals("Blue")) || (Couleur.equals("Blue") && ic.getCouleur().equals("Red")) ){
                  ic.getWriter().println("Yellow");
                     icc.getWriter().println("Yellow");
                        System.out.println("Mutation Completed... New Color : "+"Yellow");
                         ic.setCouleur(null);
                 waintingcount--;
            }
                     else if((Couleur.equals("Yellow") && ic.getCouleur().equals("Blue")) || (Couleur.equals("Blue") && ic.getCouleur().equals("Yellow")) ){
                  ic.getWriter().println("Red");
                     icc.getWriter().println("Red");
                     System.out.println("Mutation Completed... New Color : "+"Red");
                      ic.setCouleur(null);
                 waintingcount--;
            }
                   else if((Couleur.equals("Yellow") && ic.getCouleur().equals("Red")) || (Couleur.equals("Red") && ic.getCouleur().equals("Yellow")) ){
                  ic.getWriter().println("Blue");
                     icc.getWriter().println("Blue");
                     System.out.println("Mutation Completed... New Color : "+"Blue");
                      ic.setCouleur(null);
                waintingcount--;
            }
               
            }    
        }
    }
}
