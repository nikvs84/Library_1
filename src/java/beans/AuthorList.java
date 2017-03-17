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
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IT10
 */
public class AuthorList extends EntityList<Author>{
    private ArrayList<Author> authorList;
  
    public ArrayList<Author> getAuthorList(){
        if (this.authorList == null)
            this.authorList = getList("author", "", "fio", "*");
        return this.authorList;
    }

    @Override
    public Author getNewInstance(ResultSet resultSet) {
        Author author = null;
        try {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("fio");
            Date birthday = resultSet.getDate("birthday");
            
            author = new Author(name);
            author.setId(id);
            author.setBirthday(birthday);
        } catch (SQLException ex) {
            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return author;
    }
}
