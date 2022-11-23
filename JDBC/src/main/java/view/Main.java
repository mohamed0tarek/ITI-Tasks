package view;

import operation.Operations;
import table.Employee;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Employee emp1 = new Employee(4, "mazen", 1234);
        Employee emp2 = new Employee(5, "ali", 909090);

        Operations op = new Operations();

        op.insertEmp(emp1);
        op.insertEmp(emp2);

        op.getAllInfo();
    }
}
