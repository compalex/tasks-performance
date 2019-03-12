package myTask7;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Task7 {

    private static final String[] MAIN_MENU = { 
            "What do you wanna see, dude?", 
            "1.\tList of books",
            "2.\tList of orders", 
            "3.\tList of book requests", 
            "4.\tList of completed orders for a period of time",
            "5.\tAmount of money earned over a period of time", 
            "6.\tNumber of completed orders for a period of time",
            "7.\tList of \"stale\" books being unsold for over 6 months", 
            "8.\tDetails of the order",
            "9.\tDescription of the book" 
    };
    private static final String[] MENU_1 = {
            "How do you wanna sort the list of books, dude?",
            "1.\tSort the list alphabetically",
            "2.\tSort by date of publication",
            "3.\tSort by price",
            "4\tSort by stock availability"
    };
    private static final String[] MENU_2 = {
            "How do you wanna sort the list of orders, dude?",
            "1.\tSort by order date",
            "2.\tSort by price of the order",
            "3.\tSort by the status of the order"
    };
    private static final String[] REPEAT_PROMPT = {
            "Wanna try program again or just stop it?",
            "1.\tYeah, why not. I'm gonna repeat",
            "2.\tNah, Imma be done for now. Take it easy"
    };
    private static final String INPUT_ERROR_2 = "Come on! It's gonna be the integer number between 1 and ";
    private static final String INPUT_ERROR = "Error! Wrong input! ";  
    private static final String DATE_STRING = "yyyy/MM/dd";
    private static final String LINE = "_________________________________________";
    private static final String GOODBYE = "All right then, see you next time, dude";
    private static final String BOOK_TITLE_1 = "Think Java";
    private static final String BOOK_TITLE_2 = "Think as God by Alex Compalex";
    private static final String BOOK_TITLE_3 = "Java. A beginner's guide";
    private static final String BOOK_TITLE_4 = "Dictionary";
    private static final String BOOK_TITLE_5 = "Easy Way To Stop Smoking";
    private static final String ORDER_STATUS_1 = "COMPLETED";
    private static final String ORDER_STATUS_2 = "PROCESSING";
    private static final String ORDER_STATUS_3 = "CANCELED";
    
    
    private static DateFormat dateFormat = new SimpleDateFormat(DATE_STRING);
    private static ArrayList<Book> booksList;
    private static ArrayList<Order> ordersList;
    
    private static boolean needToRepeat = true;

    public static void main(String[] args) {
        createListOfBooks();
        createListOfOrders();
        
        while(needToRepeat) {
            //let's get a choice from the main menu
            showMenu(MAIN_MENU);
            int choice1 = getInput(MAIN_MENU);
            System.out.println(MAIN_MENU[choice1]);
            System.out.println();
            //let's get a choice from the secondary menu (zero if there's no need to receive a choice)
            int choice2 = getChoice2(choice1);
            System.out.println();
            //now sort list of <choice1> in comparator of <choice2>
            if(choice1 == 1) {
                Collections.sort(booksList, new MyBookSorter(choice2));
                printListOfBooks(); 
            } else if(choice1 == 2) {
                Collections.sort(ordersList, new MyOrderSorter(choice2));
                printListOfOrders(); 
            }
            needToRepeat = doAgain();
        }
        System.out.println(GOODBYE);
        
    }

    private static void showMenu(String[] menu) {
        for (String line : menu) {
            System.out.println(line);
        }
    }
    
    private static int getChoice2(int choice) {
        int choice2;
        switch(choice) {
        case 1:
            showMenu(MENU_1);
            choice2 = getInput(MENU_1);
            System.out.println(MENU_1[choice2]);
            return choice2;
        case 2:
            showMenu(MENU_2);
            choice2 = getInput(MENU_2);
            System.out.println(MENU_2[choice2]);
            return choice2;
        case 3:
            return 0;
        case 4:
            return 0;
        case 5:
            return 0;
        case 6:
            return 0;
        case 7:
            return 0;
        case 8:
            return 0;
        case 9:
            return 0;
        default:
            return 0;
        }          
        
    }

    private static int getInput(String[] inputPrompt) {
        Scanner sc = new Scanner(System.in);

        try {
            int choice = sc.nextInt();
            if (choice < 1 || choice >= inputPrompt.length) {
                System.out.println(INPUT_ERROR_2 + (inputPrompt.length - 1));
                return getInput(inputPrompt);
            } else
                return choice;

        } catch (InputMismatchException e) {
            System.out.print(INPUT_ERROR);
            return getInput(inputPrompt);
        } finally {
           //sc.close();
           // System.out.println("!!!sc closed!!!");
        }
    }
    
    private static boolean doAgain() {
        showMenu(REPEAT_PROMPT);
        if(getInput(REPEAT_PROMPT) == 1) return true;
        else if(getInput(REPEAT_PROMPT) == 2) return false;
        else return doAgain();
    }

    private static void createListOfBooks() {
        booksList = new ArrayList<Book>();          
        booksList.add(new Book(BOOK_TITLE_1, new GregorianCalendar(1998, 11, 24), 35, true));
        booksList.add(new Book(BOOK_TITLE_2, new GregorianCalendar(2018, 8, 26), 135, false));
        booksList.add(new Book(BOOK_TITLE_3, new GregorianCalendar(1992, 2, 3), 70, true));
        booksList.add(new Book(BOOK_TITLE_4, new GregorianCalendar(1954, 12, 3), 12, false));
        booksList.add(new Book(BOOK_TITLE_5, new GregorianCalendar(1982, 2, 5), 23, true));
    }
    
    private static void createListOfOrders() {
        ordersList = new ArrayList<Order>();          
        ordersList.add(new Order(new GregorianCalendar(2019, 3, 11), 170, ORDER_STATUS_3));
        ordersList.add(new Order(new GregorianCalendar(2018, 8, 1), 135, ORDER_STATUS_1));
        ordersList.add(new Order(new GregorianCalendar(2019, 2, 3), 40, ORDER_STATUS_2));
        ordersList.add(new Order(new GregorianCalendar(2017, 12, 3), 88, ORDER_STATUS_2));
        ordersList.add(new Order(new GregorianCalendar(2018, 12, 15), 65, ORDER_STATUS_1));
    }
    
    private static void printListOfBooks() {
        for (Book next : booksList) {
            System.out.println(LINE);
            System.out.println(next.getTitle());
            System.out.println(dateFormat.format(next.getPublicationDate().getTime()));
            System.out.println(next.getPrice());
            System.out.println(next.getStockAvailability());
            System.out.println();
            System.out.println(LINE);
        }
    }
    
    private static void printListOfOrders() {
        for (Order next : ordersList) {
            System.out.println(LINE);
            System.out.println(dateFormat.format(next.getOrderDate().getTime()));
            System.out.println(next.getPrice());
            System.out.println(next.getStatus());
            System.out.println();
            System.out.println(LINE);
        }
    }
    
    
}
