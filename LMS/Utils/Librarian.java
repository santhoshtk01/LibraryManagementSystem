package LMS.Utils;

import LMS.Books.Book;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Librarian{
    String[][] books = {
            {"978-0-678901-23-4", "Artificial Intelligence Revolution", "Computer Science", "Quantum Computing Press", "English", "Sophia Mindforge"},
            {"978-0-789012-34-5", "Cloud Computing Unleashed", "Computer Science", "Cloud Tech LMS.Books", "English", "Ethan Skylink"},
            {"978-0-890123-45-6", "Network Security Fundamentals", "Computer Science", "NetGuard Publishers", "English", "Vanessa Firewall"},
            {"978-0-901234-56-7", "Programming Paradigms", "Computer Science", "CodeWorld Press", "English", "Oliver Codeman"},
            {"978-0-123456-78-0", "Human-Computer Interaction: Design Principles", "Computer Science", "Interface Publications", "English", "Laura Interaction"},
            {"978-0-234567-89-1", "Software Engineering Essentials", "Computer Science", "CodeCraft Press", "English", "Daniel Codeforge"},
            {"978-0-345678-90-2", "Big Data Analytics Handbook", "Computer Science", "Data Crunchers Publishing", "English", "Ava Analytics"},
            {"978-0-456789-01-3", "Cybernetic Systems Design", "Computer Science", "Cyberspace Publishers", "English", "Xavier Cyberman"},
            {"978-0-567890-12-4", "IoT: Connecting the Future", "Computer Science", "Connectivity LMS.Books", "English", "Zoe Linkmaster"},
            {"978-0-678901-23-5", "Quantum Computing: A Practical Guide", "Computer Science", "Quantum Tech Publishing", "English", "Quantum Expert"},
            {"978-0-123456-78-9", "Algorithms Unleashed", "Computer Science", "Byte LMS.Books", "English", "Alan Codebreak"},
            {"978-0-234567-89-0", "Data Structures Demystified", "Computer Science", "TechPress", "English", "Cynthia Bytecraft"},
            {"978-0-345678-90-1", "Machine Learning Mastery", "Computer Science", "AI Innovations", "English", "Maxwell Insight"},
            {"978-0-456789-01-2", "Cybersecurity Essentials", "Computer Science", "Secure Solutions", "English", "Emily Firewall"},
            {"978-0-567890-12-3", "Web Development Wonders", "Computer Science", "CodeCraft Publications", "English", "Jason Webster"}
    };
    /*
    * The `bookCounts` and `books` rows are associated.
    * */
    int[] bookCounts = {10, 5, 7, 9, 13, 18, 20, 22, 18, 22, 9, 8, 9, 7, 12};
    Book[] book;
    String dueDate;

    Librarian(){
        this.book = new Book[15];
        this.dueDate = null;
    }

    private static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }

    void addBookItem(){
        String borrowedDate = formatDate(LocalDate.now());
        this.dueDate = formatDate((LocalDate.now().plusDays(15)));

        // Add books
        for(int i = 0; i < 15; i++){
            this.book[i] = new Book(books[i][0], books[i][1], books[i][2], books[i][3], books[i][4], 1012, borrowedDate,
                    dueDate, 1024.00, true, books[i][5], "");
        }
    }

    String getDueDate(){
        return this.dueDate;
    }

    void blockMember(String id){

    }

    void unblockMember(String id){

    }

}

