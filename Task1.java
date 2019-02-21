package myTasks;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Search for prime numbers
 * @version 1.0 
 * @author compalex
 */
public class Task1 {
    
    private static final String INPUT_PROMPT = "Input an integer number:"; 
    private static final String INPUT_ERROR = "Error! Wrong input! "; 

    public static void main(String args[]) {
        int inputNumber = getInput();

        for (int i = 0; i <= inputNumber; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
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

    private static boolean isPrime(int currentNumber) {
        if (currentNumber < 2) {
            return false;
        }

        for (int i = 2; i < currentNumber; i++) {
            if (currentNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
