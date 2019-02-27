package myTasks;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The program finds GCD and LCM of two numbers
 * 
 * @version 1.0
 * @author compalex
 */
public class Task4 {
    private static final String INPUT_PROMPT_1 = "Input the first number:";
    private static final String INPUT_PROMPT_2 = "Input the second number:";
    private static final String INPUT_ERROR = "Error! Wrong input!";
    private static final String DISPLAY_GCD = "The greatest common divisor of %d and %d equals %d%n";
    private static final String DISPLAY_LCM = "The least common multiple of %d and %d equals %d%n";
    private static int num1;
    private static int num2;

    public static void main(String[] args) {
        getNumbers();
        System.out.printf(DISPLAY_GCD, num1, num2, getGCD(num1, num2));
        System.out.printf(DISPLAY_LCM, num1, num2, getLCM(num1, num2));
    }

    private static void getNumbers() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(INPUT_PROMPT_1);
            num1 = sc.nextInt();
            System.out.println(INPUT_PROMPT_2);
            num2 = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(INPUT_ERROR);
            getNumbers();
        } finally {
            sc.close();
        }
    }

    private static int getGCD(int num1, int num2) { // greatest common divisor
        for (int i = 2; i <= num1 || i <= num2; i++) {
            if (num1 % i == 0 & num2 % i == 0) {
                return i * getGCD(num1 / i, num2 / i);
            }
        }
        return 1;
    }

    private static int getLCM(int num1, int num2) { // least common multiple
        return num1 * num2 / getGCD(num1, num2);
    }
}
