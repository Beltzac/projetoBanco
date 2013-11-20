package A03_1_jdbc.livroautor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/exercicio", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
