/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author IT10
 */
public class BookList {
    private ArrayList<Book> bookList;
    
    private ArrayList<Book> getBooks() {
        ItemList<String> itemList = new ItemList<>();
        ArrayList<String> items = itemList.getItems("book", "name", null);
        
        bookList = new ArrayList<>();
        
        for (String item : items) {
            Book book = new Book(item);
            bookList.add(book);
        }

        return bookList;
    }
    
    public ArrayList<Book> getBookList() {
        if (bookList == null)
            bookList = getBooks();
        return bookList;
    }
}
