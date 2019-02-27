package myTasks;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Search for fibonacci numbers
 * @version 1.0
 * @author compalex
 */
public class Task2 {
    private static final String INPUT_PROMPT = "Input an integer number:";
    private static final String INPUT_ERROR = "Error! Wrong input! ";

    public static void main(String[] args) {
        printFibo(getInput());
    }

    private static int getInput() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(INPUT_PROMPT);
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.print(INPUT_ERROR);
            return getInput();
        } finally {
            sc.close();
        }
    }

    private static void printFibo(int inputNumber) {
        if(inputNumber < 0) return;        
        int numBefore = 0;

        for (int i = 1; numBefore <= inputNumber; i += numBefore) {
            System.out.print(numBefore + " ");
            numBefore = i - numBefore;
        }
    }
}
