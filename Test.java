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
public class Test {

    public static void main(String[] args) {

        Texte texte1 = new Texte("Text_integral.txt");
        Texte texte2 = new Texte("Text_abrege.txt");
        Citation resultat = new Citation();

        texte1.coupeParagraphes();
        texte1.coupePhrases();
        texte2.coupeParagraphes();
        texte2.coupePhrases();
        resultat.comparer(texte1, texte2);
    }
}
