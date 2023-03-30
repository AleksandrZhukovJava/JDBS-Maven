import dbObjects.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void createEmployee(String name, String lastname, String gender, int age, int city_id) throws SQLException;
    Employee returnEmployeeById(int id) throws SQLException;
    List<Employee> readAllEmployee() throws SQLException;
    void updateEmployeeById(int id, String... array) throws SQLException;
    void deleteEmployeeById(int id) throws SQLException;

}
