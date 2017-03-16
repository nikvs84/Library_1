/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author IT10
 */
public class AuthorList {
    private ArrayList<Author> authorList;

    public ArrayList<Author> getAuthors() {
        
        this.authorList = new ArrayList<>();
        
        Connection conn = Database.getConnection();
        
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `author` ORDER BY `fio`")) {
            
            while (rs.next()) {
                String authorName = rs.getString("fio");
                authorList.add(new Author(authorName));
            }
//            authorList.sort(new Comparator<Author>() {
//                @Override
//                public int compare(Author o1, Author o2) {
//                    return o1.getName().compareToIgnoreCase(o2.getName());//To change body of generated methods, choose Tools | Templates.
//                }
//            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return authorList;
    }
    
    public ArrayList<Author> getAuthorList(){
        if (this.authorList == null)
            this.authorList = getAuthors();
        return this.authorList;
    }
}
