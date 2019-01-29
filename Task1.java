package myTasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {

    public static void main(String args[]) {
        int inputNumber = getInput();

        for (int i = 0; i <= inputNumber; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static int getInput() {
        
        while(true) {
            Scanner sc = new Scanner(System.in);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error, input an integer number");
            } finally {
                sc.close();
            }
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
