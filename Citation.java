/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezoombook;

import java.util.*;

/**
 *
 * @author PETESCH, SEPPECHER
 */
public class Citation {

    private ArrayList<String> ListCitations;

    /**
     * Getter
     * @return liste des citations
     */
    public ArrayList<String> getListCitations() {
        return ListCitations;
    }

    /**
     * Setter
     * 
     * @param ListCitations 
     */
    public void setListCitation(ArrayList<String> ListCitations) {
        this.ListCitations = ListCitations;
    }
    
    /**
     * Constructeur
     */
    public Citation(){
        ListCitations = new ArrayList<>();
    }
    
    /**
     * Comparer deux textes
     *
     * @param texte1
     * @param texte2
     */
    public void comparer(Texte texte1, Texte texte2) {
        try {
            String phrase1 = "";
            String phrase2 = "";
            Boolean trouve = false;
            //on compare les phrases du texte2 aux phrases du texte1
            System.out.println("Comparaison des deux textes :");
            Iterator<String> It1 = texte1.getListPhrases().iterator();
            Iterator<String> It2 = texte2.getListPhrases().iterator();
            while (It2.hasNext()) {
                //on parcourt la liste des phrases du texte1
                phrase2 = It2.next();
                while ((It1.hasNext()) && (trouve == false)) {
                    //on parcourt la liste des phrases du texte 1 et on compare les deux phrases
                    phrase1 = It1.next();
                    if (phrase2.equals(phrase1)) {
                        //si on trouve une égalité, alors le phrase2 est une citation
                        System.out.println("La phrase " + phrase2 + " est une citation");
                        trouve = true;
                        ListCitations.add(phrase2);
                    }
                }
                if (trouve == false) {
                    //si on ne trouve pas la phrase2 dans le texte 1, alors ce n'est pas une citation
                    System.out.println("La phrase " + phrase2 + " n'est pas une citation");
                }
                It1 = texte1.getListPhrases().iterator();
                trouve = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
