package myTasks;

import java.awt.geom.Line2D;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The program determines whether two segments intersect each other or not
 * @version 1.0
 * @author compalex
 */
public class Task3 {
    private static final String INPUT_PROMPT_1 = "Input coordinates of 1st line -> x1, y1, x2, y2";
    private static final String INPUT_PROMPT_2 = "Input coordinates of 2nd line -> x3, y3, x4, y4";
    private static final String INPUT_ERROR = "Error! Wrong input!";
    private static final String QUESTION = "Do they cross?";    

    public static void main(String[] args) {
        Line2D line1 = getLine(INPUT_PROMPT_1);
        Line2D line2 = getLine(INPUT_PROMPT_2);        
        System.out.println(QUESTION + line1.intersectsLine(line2));
    }

    private static Line2D getLine(String prompt) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(prompt);
            return new Line2D.Double(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        } catch (InputMismatchException e) {
            System.out.println(INPUT_ERROR);
            return getLine(prompt);
        } finally {
            sc.close();
        }
    }
}
