package LMS.Books;

public class Author{
    // Members of the author.
    String name;
    String description;

    Author(String name, String description){
        this.name = name;
        this.description = description;
    }

    String getName(){
        return this.name;
    }
}
