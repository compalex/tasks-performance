package myTask7;

import java.util.GregorianCalendar;

public class Book{
    
    private String title;
    private GregorianCalendar publicationDate;
    private int price;
    private boolean stockAvailability;
    
    Book(String title, GregorianCalendar publicationDate, int price, boolean stockAvailability) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.price = price;
        this.stockAvailability = stockAvailability;
    }
    
    public String getTitle() {
        return title;
    }
    
    public GregorianCalendar getPublicationDate() {
        return publicationDate;
    }
    
    public int getPrice() {
        return price;
    }
    
    public boolean getStockAvailability() {
        return stockAvailability;
    }
    
    //this method is exceptionally for MyBookSorter
    public long getDateInMillisec() {
        return publicationDate.getTimeInMillis();
    }
}
