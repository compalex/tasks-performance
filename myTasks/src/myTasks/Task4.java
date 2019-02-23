package myTasks;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The program finds GCD and LCM of two numbers
 * @version 1.0 
 * @author compalex
 */
public class Task4 {
    static int num1;
    static int num2;
    private static final String INPUT_PROMPT_1 = "Input the first number:"; 
    private static final String INPUT_PROMPT_2 = "Input the second number:"; 
    private static final String INPUT_ERROR = "Error! Wrong input!"; 

    public static void main(String[] args) {

        getNumbers();
        
        System.out.printf("The greatest common divisor of %d and %d is: %d%n", num1, num2, gcd(num1, num2));
        System.out.printf("The least common multiple of %d and %d is: %d%n", num1, num2, lcm(num1, num2));        
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
    
    private static int gcd(int a, int b) {      //greatest common divisor
        for(int i=2; i<=a; i++) {
            if(a%i==0 & b%i==0) {
                return i*gcd(a/i, b/i);
            } 
        }
        return 1;
    }
    
    private static int lcm(int a, int b) {      //least common multiple
        for(int i=2; i<=a; i++) {
            if(a%i==0 & b%i==0) {
                return i*lcm(a/i, b/i);
            } 
        }
        return a*b;
    }
}