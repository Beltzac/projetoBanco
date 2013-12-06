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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Codification
 */
class Config {
    
    static Properties prop;

    static void load() {
            prop = new Properties();
 if(!new File("config.properties").exists()){
                        //set the properties value
    		prop.setProperty("database", "//localhost/projetoJava");
    		prop.setProperty("dbuser", "root");
    		prop.setProperty("dbpassword", "");
                prop.setProperty("persistence", "sgbd");
                prop.setProperty("file", "File.txt");
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
                prop.setProperty("persistence", "sgbd");
                prop.setProperty("file", "File.txt");
 
    		//save properties to project root folder
    		prop.store(new FileOutputStream("config.properties"), null);
                }
 
               //get the property value and print it out
                System.out.println(prop.getProperty("database"));
    		System.out.println(prop.getProperty("dbuser"));
    		System.out.println(prop.getProperty("dbpassword"));
                System.out.println(prop.getProperty("file"));
                System.out.println(prop.getProperty("persistence"));
 
    	} catch (IOException ex) {
        }
    
    }

    public Config() {
    

}
    
    
}
