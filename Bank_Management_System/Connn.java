package Bank_Management_System;
import java.sql.*;
public class Connn {
    Connection connection;
    Statement statement;
    public Connn() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmSystem", "root", "Shrawan3067%");
            statement = connection.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
