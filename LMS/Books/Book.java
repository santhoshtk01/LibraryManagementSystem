package LMS.Books;

public class Book extends BookItem {

    String ISBN;
    String title;
    String subject;
    String publisher;
    String language;
    int noOfPages;
    Author author;

    public Book(String ISBN, String title, String subject, String publisher, String language, int noOfPages,
         String borrowedDate, String dueDate, Double price, boolean bookStatus, String name, String description){

        super(borrowedDate, dueDate, price, bookStatus);
        this.ISBN = ISBN;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.noOfPages = noOfPages;
        this.author = new Author(name, description);
    }

    public String getTitle(){
        return this.title;
    }

}
