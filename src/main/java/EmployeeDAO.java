import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee returnEmployeeById(int id);
    List<Employee> returnAllEmployee();
    void updateEmployee(Employee employee, int id);
    void deleteEmployee(Employee employee);

}
