/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IT10
 */
public class PublisherList extends EntityList<Publisher>{
    private ArrayList<Publisher> publisherList;

    @Override
    public Publisher getNewInstance(ResultSet resultSet) {
        Publisher publisher = null;
        
        try {
            String name = resultSet.getString("name");
            int id = resultSet.getInt("id");
            publisher = new Publisher(name);
            publisher.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(PublisherList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return publisher;
    }
    
    public ArrayList<Publisher> getPublisherList() {
        if (publisherList == null)
            publisherList = getList("publisher", "", "name", "*");
        return publisherList;
    }
    

}
