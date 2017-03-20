/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Database;
import java.sql.Connection;
import java.sql.Date;
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
public class BookList extends EntityList<Book>{
    private ArrayList<Book> bookList;
    
    public ArrayList<Book> getBookList() {
        String query = "SELECT b.id, b.name, b.isbn, b.page_count, b.publish_year, \n" +
        "p.name AS publisher, a.fio AS author, g.name AS genre\n" +
        "FROM \n" +
        "`book` AS b INNER JOIN `author` AS a ON b.author_id=a.id\n" +
        "INNER JOIN `genre` AS g on b.genre_id=g.id\n" +
        "INNER JOIN `publisher` AS p ON b.publisher_id=p.id\n" +
        "LIMIT 0,5;";
        if (bookList == null)
            bookList = getList(query);
        return bookList;
    }
    
    public ArrayList<Book> getBooksByGenre(long id) {
        String query = "SELECT b.id, b.name, b.isbn, b.page_count, b.publish_year, \n" +
        "p.name AS publisher, a.fio AS author, g.name AS genre\n" +
        "FROM \n" +
        "`book` AS b INNER JOIN `author` AS a ON b.author_id=a.id\n" +
        "INNER JOIN `genre` AS g on b.genre_id=g.id\n" +
        "INNER JOIN `publisher` AS p ON b.publisher_id=p.id\n" +
        "WHERE\n" +
        "b.genre_id=%d\n" +
        "ORDER BY b.name\n" +
        "LIMIT 0,5;";
        return getList(String.format(query, id));
    }

    @Override
    public Book getNewInstance(ResultSet resultSet) {
         Book book = new Book();
        try {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            int pageCount = resultSet.getInt("page_count");
            String isbn = resultSet.getString("isbn");
            String genre = resultSet.getString("genre");
            String author = resultSet.getString("author");
            Date publishYear = resultSet.getDate("publish_year");
            String publisher = resultSet.getString("publisher");
            
            book.setId(id);
            book.setName(name);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
