package myTasks;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The program check a word for palindrome
 * @version 1.0 
 * @author compalex
 */
public class Task5 {

    public static void main(String[] args) {             
        System.out.println("Is word a palindrome? --> " + isItPalindrome(getWord()));
    }

    private static String getWord() {
        Scanner sc = new Scanner(System.in);       
        try {
            System.out.println("Input word:");
            return sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error, input an integer number.");
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