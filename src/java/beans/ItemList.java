/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.Database;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    
    public ArrayList<T> getItems(String table, String field, Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
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
                item = getItemInstance(clazz, name);
                
                itemList.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.itemList;
    }
    
    private T getItemInstance(Class<T> clazz, String name) {
        T item = null;
        try {
            item = clazz.newInstance();
            
            Method setName = clazz.getMethod("setName", String.class);
            setName.invoke(item, name);
                
        } catch (InstantiationException ex) {
            Logger.getLogger(ItemList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ItemList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ItemList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ItemList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ItemList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ItemList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }
}
