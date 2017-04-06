

import java.io.File;
import java.io.IOException;
import static java.lang.Math.E;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.Scanner;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tongtong
 */
public class SpellChecker {

    private static Object word;
    
    
       
    public static void main(String[] args) throws Exception {
        int[] count = new int[1];
        double wordsFound = 0;
        double wordsNotFound = 0;
        double compsFound = 0;
        double compsNotFound = 0;
        double avgcompswordsfound = 0;
        double avgcompswordsnotfound = 0;
        
        
        MyLinkedList[] list = new MyLinkedList[26];
        for (int i = 0; i < list.length; i++) {
            list[i]= new MyLinkedList<String>();
        }
        
        java.io.File f= new java.io.File("random_dictionary.txt");
        String inputWord;

        try {

            Scanner in = new Scanner(f);

            while (in.hasNext()) {

                inputWord = in.next();

                inputWord = inputWord.toLowerCase();

                int i = (inputWord.charAt(0) - 97);

                list[i].addLast(inputWord);

            }

            System.out.println("Processing complete: ");

            in.close();

        } catch (IOException e) {

            System.out.println("Unable to read file");

        }

        File oliver = new File("oliver.txt");

        try {
            Scanner in = new Scanner(oliver);

            while (in.hasNext()) {

                inputWord = in.next();

                inputWord = inputWord.toLowerCase();
                if (Character.isLetter(inputWord.charAt(0))) {
                    int i = (inputWord.charAt(0) - 97);

                    if (list[i].contains(inputWord)) {
                        System.out.println("The list contains: " + inputWord);
                        wordsFound++;
                        compsFound += list[i].indexOf(inputWord);
                    } else {
                        System.out.println("The list does not contain: " + inputWord);
                        compsNotFound++;
                        compsNotFound += list[i].size();
                    }
                }
            }

            System.out.println("Processing complete ");

            in.close();

        } catch (IOException e) {

            System.out.println("Unable to read file");

        }   
        
        System.out.println("-------------------------------");
        
        avgcompswordsfound = compsFound / wordsFound;// ( avg # of comps per word) 
        avgcompswordsnotfound = compsNotFound / wordsNotFound;//(avg # of comps per word not found)
                
        System.out.println("Average number of compaarisons for wors found: " + avgcompswordsfound);
        System.out.println("Average number of compaarisons for wors not found: " + avgcompswordsnotfound);
        
    }

}
        
    
      
        
         
    


        
        
        
    
    
    
    

