/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IT10
 */
public class BookList {
    private ArrayList<Book> bookList;
    
    private ArrayList<Book> getBooks() {
        
        bookList = new ArrayList<>();
        
        Connection conn = Database.getConnection();
        String query = "SELECT * FROM `book` ORDER BY `name`";
        
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                ){
            while (rs.next()) {              
                String name = rs.getString("name");
                bookList.add(new Book(name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bookList;
    }
    
    public ArrayList<Book> getBookList() {
        if (bookList == null)
            bookList = getBooks();
        return bookList;
    }
}
