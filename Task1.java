package myTasks;

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

    static int getInput() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }

    static boolean isPrime(int currentNumber) {
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
