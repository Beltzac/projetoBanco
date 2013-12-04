/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Codification
 */
public class ConnectionFactory {

    public Connection getConnection() {
        Properties prop = new Properties();
 if(!new File("config.properties").exists()){
                        //set the properties value
    		prop.setProperty("database", "//localhost/projetoJava");
    		prop.setProperty("dbuser", "root");
    		prop.setProperty("dbpassword", "");
            try {
                //save properties to project root folder
                prop.store(new FileOutputStream("config.properties"), null);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
 }
    	try {
               //load a properties file
    		prop.load(new FileInputStream("config.properties"));
                if (prop.isEmpty()){
                    //set the properties value
    		prop.setProperty("database", "//localhost/projetoJava");
    		prop.setProperty("dbuser", "root");
    		prop.setProperty("dbpassword", "");
 
    		//save properties to project root folder
    		prop.store(new FileOutputStream("config.properties"), null);
                }
 
               //get the property value and print it out
                System.out.println(prop.getProperty("database"));
    		System.out.println(prop.getProperty("dbuser"));
    		System.out.println(prop.getProperty("dbpassword"));
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
        
        try {
            return DriverManager.getConnection("jdbc:mysql:"+prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
