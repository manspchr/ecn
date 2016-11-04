/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezoombook;

import java.io.*;
import java.text.BreakIterator;
import java.util.*;

/**
 *
 * @author PETESCH, SEPPECHER
 */
public class Texte {

    //attributs pour la lecture du fichier
    private ArrayList<String> ListParagraphes;
    private String nomFichier;

    //attributs utiles pour la coupe
    private ArrayList<String> ListPhrases;

    /**
     * Getter
     *
     * @return listes des paragraphes
     */
    public ArrayList<String> getListParagraphes() {
        return ListParagraphes;
    }

    /**
     * Setter
     *
     * @param ListParagraphes
     */
    public void setListParagraphes(ArrayList<String> ListParagraphes) {
        this.ListParagraphes = ListParagraphes;
    }

    /**
     * Getter
     *
     * @return nom du fichier
     */
    public String getNomFichier() {
        return nomFichier;
    }

    /**
     * Setter
     *
     * @param nomFichier
     */
    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    /**
     * Getter
     *
     * @return listes des phrases
     */
    public ArrayList<String> getListPhrases() {
        return ListPhrases;
    }

    /**
     * Setter
     *
     * @param ListPhrases
     */
    public void setListPhrases(ArrayList<String> ListPhrases) {
        this.ListPhrases = ListPhrases;
    }

    /**
     * Constructeur
     *
     * @param nom1 fichier 1
     */
    public Texte(String nom1) {
        nomFichier = nom1;
        ListParagraphes = new ArrayList<>();
        ListPhrases = new ArrayList<>();
    }

    /**
     * Coupe le fichier en paragraphes
     */
    public void coupeParagraphes() {
        try {
            //variables utiles
            BufferedReader fichier1;

            //on transforme les fichiers textes en liste de paragraphes
            fichier1 = new BufferedReader(new FileReader(nomFichier));
            String m1 = fichier1.readLine();
            while (m1 != null) {
                ListParagraphes.add(m1);
                m1 = fichier1.readLine();
            }
            fichier1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Coupe chaque paragraphe en phrases
     */
    public void coupePhrases() {
        //variables utiles pour le découpage de mots
        BreakIterator breakIterator = BreakIterator.getSentenceInstance(Locale.FRENCH);
        String paragraphe;
        String phrase;
        int boundaryIndex = 0;
        int start = 0;
        int end = 0;
        int p = 1;
        int s = 1;

        //on découpe chaque paragraphe du texte en phrases
        System.out.println("Texte :" + "\n");
        Iterator<String> listIt = ListParagraphes.iterator();
        while (listIt.hasNext()) {
            //on analyse le paragraphe numéro p
            System.out.println("paragraphe n° " + p);
            paragraphe = listIt.next();
            breakIterator.setText(paragraphe);
            boundaryIndex = breakIterator.first();
            start = boundaryIndex;
            boundaryIndex = breakIterator.next();
            end = boundaryIndex;
            while (boundaryIndex != BreakIterator.DONE) {
                //on découpe le paragraphe en phrases
                phrase = paragraphe.substring(start, end);
                Boolean test = false;
                // on extrait les deux derniers charactères
                String result = phrase.substring(phrase.length() - 2);
                // on teste la valeur de ces deux derniers charactères
                if (result.equalsIgnoreCase(". ")) {
                    test = true;
                    // on extrait et copie la phrase sans le dernier espace
                    phrase = phrase.substring(0, phrase.length() - 1);
                }
                ListPhrases.add(phrase);
                System.out.println("phrase n° " + s);
                System.out.println(phrase);
                boundaryIndex = breakIterator.next();
                start = end;
                end = boundaryIndex;
                s++;
            }
            s = 1;
            p++;
            System.out.println("");
        }
    }
}
