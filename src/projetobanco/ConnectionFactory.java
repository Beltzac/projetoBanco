/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Codification
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/projetoJava", "root", "@PowerRangers2013");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
