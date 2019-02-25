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

    public static void main(String[] args) {
        Line2D line1 = new Line2D.Double();
        Line2D line2 = new Line2D.Double();
        getLines(line1, line2);
        System.out.println("Do they cross? -> " + line1.intersectsLine(line2));
    }

    private static void getLines(Line2D l1, Line2D l2) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(INPUT_PROMPT_1);
            l1.setLine(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            System.out.println(INPUT_PROMPT_2);
            l2.setLine(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        } catch (InputMismatchException e) {
            System.out.println(INPUT_ERROR);
            getLines(l1, l2);
        } finally {
            sc.close();
        }
    }
}
