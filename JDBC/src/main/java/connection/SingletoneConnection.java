package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletoneConnection {
    private String url = "jdbc:mysql://localhost:3306/mydb";
    private String userName = "elsawy";
    private String password = "123456789Mm";

    private SingletoneConnection(){}

    private static SingletoneConnection connection = null;

    public static SingletoneConnection getInstance(){
        if (connection == null)
            connection =  new SingletoneConnection();
        return connection;
    }
    
    public Connection startConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
