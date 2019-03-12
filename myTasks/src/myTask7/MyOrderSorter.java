package myTask7;

import java.util.Comparator;

public class MyOrderSorter implements Comparator<Order>{
    
    private final String COMPLETED = "COMPLETED";
    private final String PROCESSING = "PROCESSING";
    private int sortNum;

    MyOrderSorter(int sortNum) {
        this.sortNum = sortNum;
    }
    
     public int compare(Order a, Order b) {
         if(sortNum == 1) {
             if(a.getDateInMillisec() < b.getDateInMillisec()) return 1;
             else if(a.getDateInMillisec() == b.getDateInMillisec()) return 0;
             else return -1;
         } else if(sortNum == 2) {
             return b.getPrice() - a.getPrice();
         } else if(sortNum == 3) {
             if(a.getStatus() == COMPLETED) {
                 if(b.getStatus() != COMPLETED) return -1;
                 else return 0;
             } else if(b.getStatus() == COMPLETED) {
                 if(a.getStatus() != COMPLETED) return 1;
                 else return 0;
             } else if(a.getStatus() == PROCESSING) {
                 if(b.getStatus() != PROCESSING) return -1;
                 else return 0;
             } else if(b.getStatus() == PROCESSING) {
                 if(a.getStatus() != PROCESSING) return 1;
                 else return 0;
             } else return 0;
         } else return 0;
    }
}

