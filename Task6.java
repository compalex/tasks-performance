package myTasks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The program remove numbers from the text
 * @version 1.0 
 * @author compalex
 */
public class Task6 {
    private static final String INPUT_PROMPT = "Input text:"; 
    private static final String theRegex = "\\d"; 
    
    public static void main(String[] args) {             
        printWithoutNos(getText());
    }
    
    private static String getText() {
        Scanner sc = new Scanner(System.in);   
        System.out.println(INPUT_PROMPT);
        String inputText = sc.nextLine();
        sc.close();
        return inputText;
    }
    
    private static void printWithoutNos(String text) {   
        Pattern pattern = Pattern.compile(theRegex);
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.replaceAll(""));
    }
}
