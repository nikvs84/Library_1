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
public class GenreList extends EntityList<Genre>{
    private ArrayList<Genre> genreList;
    
    public ArrayList<Genre> getGenreList() {
        if (genreList == null)
            genreList = getList("genre", "", "name", "*");
        return genreList;
    }

    @Override
    public Genre getNewInstance(ResultSet resultSet) {
        Genre genre = null;
        
        try {    
            String name = resultSet.getString("name");
            int id = resultSet.getInt("id");
            
            genre = new Genre(name);
            genre.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return genre;
    }
    
}
