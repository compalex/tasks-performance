package myTasks;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The program remove numbers from the text
 * @version 1.0
 * @author compalex
 */
public class Task6 {
    private static final String INPUT_PROMPT = "Input text:";

    public static void main(String[] args) {
        System.out.println(getText().replaceAll("[0-9]", ""));
    }

    private static String getText() {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println(INPUT_PROMPT);
            return sc.nextLine();
        } catch (NoSuchElementException e) {
            return sc.nextLine();
        } finally {
            sc.close();
        }
    }
}
