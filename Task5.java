package myTasks;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The program check a word for palindrome
 * @version 1.0 
 * @author compalex
 */
public class Task5 {
    
    private static final String INPUT_PROMPT = "Input a word:"; 
    private static final String INPUT_ERROR = "Error! Wrong input! "; 
    private static final String QUESTION = "Is the word is a palindrome? --> "; 

    public static void main(String[] args) {             
        System.out.println(QUESTION + isItPalindrome(getWord()));
    }

    private static String getWord() {
        Scanner sc = new Scanner(System.in);       
        try {
            System.out.println(INPUT_PROMPT);
            return sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println(INPUT_ERROR);
            return sc.nextLine();
        } finally {
            sc.close();
        }      
    }

    private static boolean isItPalindrome(String word) {
        char[] wordArr = word.toCharArray();
        
        for(int i = 0; i<wordArr.length/2; i++) {
            if(wordArr[i] != wordArr[wordArr.length-1-i]) {
                return false;
            } 
        }
        return true;
    }
}
