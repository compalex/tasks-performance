package myTasks;

import java.util.Scanner;
import java.util.InputMismatchException;

class Task2 {

    public static void main(String[] args) {
        int inputNumber = getInput();
        
        for (int i = 0; getFibo(i) <= inputNumber; i++) {
            System.out.print (getFibo(i) + " ");
        }
    }

    private static int getInput() {
        Scanner sc = new Scanner(System.in);

        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error, input an integer number");
            return 0;
        } finally {
            sc.close();
        }
    }

    private static int getFibo(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        return getFibo(i - 1) + getFibo(i - 2);
    }
}
