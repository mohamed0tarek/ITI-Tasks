package operation;

import connection.SingletoneConnection;
import table.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operations {


    public boolean insertEmp(Employee emp) throws SQLException {
        SingletoneConnection getConnection = SingletoneConnection.getInstance();
        try (Connection conn = getConnection.startConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO mydb.employee VALUES(?,?,?)")) {
            ps.setInt(1, emp.id());
            ps.setString(2, emp.name());
            ps.setInt(3, emp.phoneNumber());
            ps.executeUpdate();
        }
        return true;
    }

    public boolean deleteEmp(Employee emp) throws SQLException {
        SingletoneConnection getConnection = SingletoneConnection.getInstance();
        try (Connection conn = getConnection.startConnection();
             PreparedStatement ps = conn.prepareStatement("delete from mydb.employee where id=?")) {
            ps.setInt(1, emp.id());
            ps.executeUpdate();
        }
        return true;
    }

    public boolean updateEmp(Employee emp, String newName, int newPhoneNumber) throws SQLException {
        SingletoneConnection getConnection = SingletoneConnection.getInstance();
        try (Connection conn = getConnection.startConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE mydb.employee set name=?,phoneNumber=? WHERE id=?")) {
            ps.setInt(3, emp.id());
            ps.setString(1, newName);
            ps.setInt(2, newPhoneNumber);
            ps.executeUpdate();
        }
        return true;
    }

    public boolean searchEmp(int id) throws SQLException {
        SingletoneConnection getConnection = SingletoneConnection.getInstance();
        try (Connection conn = getConnection.startConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM mydb.employee WHERE id=" + id);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next())
                System.out.println(rs.getInt("id") + " " + rs.getString("name")
                        + " " + rs.getInt("phoneNumber"));
        }
        return true;
    }

    public boolean getAllInfo() throws SQLException {
        SingletoneConnection getConnection = SingletoneConnection.getInstance();
        try (Connection conn = getConnection.startConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM mydb.employee");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next())
                System.out.println(rs.getInt("id") + " " + rs.getString("name")
                        + " " + rs.getInt("phoneNumber"));
        }
        return true;
    }
}
