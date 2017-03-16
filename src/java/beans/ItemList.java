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
public class ItemList<T> {
    private ArrayList<T> itemList;
    
    public ArrayList<T> getItems(String table, String field, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        this.itemList = new ArrayList<>();
        
        Connection conn = Database.getConnection();
        String query = "SELECT * FROM `" + table + "` ORDER BY `" + field + "`";
        
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
             ) {
            T item;
            while (rs.next()) {
                String name = rs.getString(field);
                item = clazz.newInstance();
                clazz.
                itemList.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.itemList;
    }
}
