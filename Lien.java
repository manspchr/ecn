/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezoombook;

import java.io.*;
import java.util.*;

/**
 *
 * @author PETESCH, SEPPECHER
 */
public class Lien {

    public static void main(String[] args) {
        //variables utiles a la lecture du fichier
        String phrase1;
        String phrase2;
        String texte1 = "";
        String texte2 = "";
        ArrayList<String> List1;
        ArrayList<String> List2;
        ArrayList<String> ListPhrases1 = new ArrayList<>();
        ArrayList<String> ListPhrases2 = new ArrayList<>();
        String delimiteur = ".!?";
        StringTokenizer tokenizer;
        BufferedReader fichier1;
        BufferedReader fichier2;
        BufferedWriter fichierW1;
        BufferedWriter fichierW2;
        String nomFichier1;
        String nomFichier2;
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Nom du premier fichier ?");
        nomFichier1 = sc.nextLine();
        System.out.println("Nom du deuxieme fichier ?");
        nomFichier2 = sc.nextLine();*/
        nomFichier1 = "Text_integral.txt";
        nomFichier2 = "Text_abrege.txt";

        try {
            fichier1 = new BufferedReader(new FileReader(nomFichier1));
            fichier2 = new BufferedReader(new FileReader(nomFichier2));

            //on lit les deux textes
            String m1 = fichier1.readLine();
            while (m1 != null) {
                texte1 = texte1 + m1;
                m1 = fichier1.readLine();
            }
            String m2 = fichier2.readLine();
            while (m2 != null) {
                texte2 = texte2 + m2;
                m2 = fichier2.readLine();
            }
            fichier1.close();
            fichier2.close();

            //on coupe selon la chaine de caracteres "<p"
            delimiteur = "<p>";
            List1 = new ArrayList(Arrays.asList(texte1.split(delimiteur)));
            List2 = new ArrayList(Arrays.asList(texte2.split(delimiteur)));

            //on coupe chaque element du tableau selon "</p>"
            delimiteur = "</p>";
            for (int i = 0; i < List1.size(); i++) {
                ListPhrases1.addAll(new ArrayList(Arrays.asList(List1.get(i).split(delimiteur))));
            }
            for (int i = 0; i < List2.size(); i++) {
                ListPhrases2.addAll(new ArrayList(Arrays.asList(List2.get(i).split(delimiteur))));
            }
            
            //on cherche les phrases communes entre ListPhrases1 et ListPhrases2
            //quand on a trouve une phrase du texte citation (phrase2) associe a une phrase du texte integral (phrase 1),
            //on cree les chaine de caractere ajout1 et ajout2 qui vont remplacer phrase1 et phrase2.
        /*    String ajout1;
            String ajout2;
            
            ajout1 = "<a id =\"ANCRE\">"+phrase1+"</a>";
            ajout2 = "<a href ='....#idANCRE'>"+phrase2+"</a>";
        */    
             
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
