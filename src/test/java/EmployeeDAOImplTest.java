import model.Employee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EmployeeDAOImplTest {
    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Test
    public void shouldSaveTheEmployee(){
        Employee employeeTest = new Employee("Test", "Test", "Test", 20, 1);
        employeeDAO.addEmployee(employeeTest);
        assertTrue(employeeDAO.returnAllEmployee().contains(employeeTest));
    }
    @Test
    public void shouldDeleteTheEmployee(){
        Employee employeeTest = new Employee("Test", "Test", "Test", 20, 1);
        employeeDAO.addEmployee(employeeTest);
        employeeDAO.deleteEmployee(employeeTest);
        assertFalse(employeeDAO.returnAllEmployee().contains(employeeTest));
    }
}
