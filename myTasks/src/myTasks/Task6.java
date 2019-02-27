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
    private static final String INPUT_ERROR = "Error! Wrong input! ";
    private static final String CHANGE_WHAT = "[0-9]";
    private static final String CHANGE_HOW = "";

    public static void main(String[] args) {
        System.out.println(getText().replaceAll(CHANGE_WHAT, CHANGE_HOW));
    }

    private static String getText() {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println(INPUT_PROMPT);
            return sc.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println(INPUT_ERROR);
            return getText();
        } finally {
            sc.close();
        }
    }
}
