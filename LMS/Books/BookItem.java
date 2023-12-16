package LMS.Books;

public class BookItem{

    String borrowedDate;
    String dueDate;
    Double price;
    boolean bookStatus;

    BookItem(String borrowedDate, String dueDate, Double price, boolean bookStatus){
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.price = price;
        this.bookStatus = bookStatus;
    }

    void checkOut(){}
}
