package myTasks;

import java.util.NoSuchElementException;
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
        StringBuilder strBuilder = new StringBuilder();
        String word = getWord();
        strBuilder.append(word);
        strBuilder.reverse();
        System.out.println(QUESTION + word.equals(strBuilder.toString()));
    }

    private static String getWord() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(INPUT_PROMPT);
            return sc.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println(INPUT_ERROR);
            return sc.nextLine();
        } finally {
            sc.close();
        }
    }
}
