package myTasks;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The program determines whether two segments intersect each other or not
 * @version 1.0 
 * @author compalex
 */
public class Task3 {
    private static final String INPUT_PROMPT_X = "Input coordinate of x"; 
    private static final String INPUT_PROMPT_Y = "Input coordinate of y"; 
    private static final String INPUT_ERROR = "Error! Wrong input!"; 

    public static void main(String[] args) {
	    
        double arrayOfCoordinates[] = getCoordinates();               //gets an Array with coordinates {x1, y1, x2, y2, x3, y3, x4, y4}    
		
        double xCoord = pointOfIntersection(arrayOfCoordinates);      //intersection point like if it were 2 lines instead of segments		

        System.out.println("Do they cross? -> " + doSegmentsIntersect(xCoord, arrayOfCoordinates));
	}

    private static double pointOfIntersection(double[] coord) {                                                         //just a formula
        return ((coord[6] - coord[4]) * (coord[0] * coord[3] - coord[2] * coord[1])                                     //   X-X1       Y-Y1             
               + (coord[2] - coord[0]) * (coord[6] * coord[5] - coord[4] * coord[7]))                                   //  ------  =  ------
               / ((coord[3] - coord[1]) * (coord[6] - coord[4]) - (coord[2] - coord[0]) * (coord[7] - coord[5]));       //   X2-X1      Y2-Y1
    }
    
    private static boolean doSegmentsIntersect(double point, double[] coord) {
        if (point <= coord[0] & point >= coord[2] | point >= coord[0] & point <= coord[2]) {
            if (point <= coord[4] & point >= coord[6] | point >= coord[4] & point <= coord[6]) {
                return true;
            } else {
                return false;
            }
        }   return false;
    }

    private static double[] getCoordinates() {
        Scanner sc = new Scanner(System.in);
     
        try {
            double[] coord = new double[8];
         
            for(int i=0; i<8; i++) {
                System.out.println(INPUT_PROMPT_X + (1 + i/2));
                coord[i] =  sc.nextDouble();
                i++;
                System.out.println(INPUT_PROMPT_Y + (1 + i/2));
                coord[i] =  sc.nextDouble();             
            }
        return coord;
        } catch (InputMismatchException e) {
            System.out.println(INPUT_ERROR);
            return getCoordinates();
        } finally {
            sc.close();
        }      
    }
}

