import model.Employee;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee returnEmployeeById(Long id);
    List<Employee> returnAllEmployee();
    void updateEmployee(Employee employee, Long id);
    void deleteEmployee(Employee employee);

}
