import model.City;
import model.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDAOImplTest {
    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl(Application.session);
    private final CityDAO cityDAO = new CityDAOImpl(Application.session);
    private final City cityTest = new City("TEST_CITY");
    private final Employee employeeTestOne = new Employee("TestGuy", "Number1", "male", 18, cityTest);
    private final Employee employeeTestTwo = new Employee("TestGuy", "Number2", "male", 18, cityTest);
    private final Employee employeeTestThree = new Employee("TestGuy", "Number3", "male", 18, cityTest);
    @Test
    @DisplayName("Employee adding test")
    public void shouldSaveTheEmployee() {
        cityDAO.addCity(cityTest);
        employeeDAO.addEmployee(employeeTestOne);
        assertTrue(employeeDAO.returnAllEmployee().contains(employeeTestOne));
        employeeDAO.deleteEmployee(employeeTestOne);
        cityDAO.deleteCity(cityTest);
    }
    @Test
    @DisplayName("City adding test")
    public void shouldSaveTheCity() {
        cityDAO.addCity(cityTest);
        assertTrue(cityDAO.returnAllCity().contains(cityTest));
        cityDAO.deleteCity(cityTest);
    }
    @Test
    @DisplayName("Employee deleting test")
    public void shouldDeleteTheEmployee() {
        employeeDAO.addEmployee(employeeTestOne);
        employeeDAO.deleteEmployee(employeeTestOne);
        assertFalse(employeeDAO.returnAllEmployee().contains(employeeTestOne));
    }
    @Test
    @DisplayName("City deleting test")
    public void shouldDeleteTheCity() {
        cityDAO.addCity(cityTest);
        cityDAO.deleteCity(cityTest);
        assertFalse(cityDAO.returnAllCity().contains(cityTest));
    }
    @Test
    @DisplayName("Employee auto adding after city adding test")
    public void shouldAddEmployeesAfterCity() {
        cityTest.addEmployee(employeeTestTwo);
        cityTest.addEmployee(employeeTestOne);
        cityDAO.addCity(cityTest);
        assertTrue(employeeDAO.returnAllEmployee().contains(employeeTestOne)
                && employeeDAO.returnAllEmployee().contains(employeeTestTwo));
        cityDAO.deleteCity(cityTest);

    }
    @Test
    @DisplayName("Employee auto changing after city changing test")
    public void shouldChangeBDAfterCityChanging() {
        cityTest.addEmployee(employeeTestTwo);
        cityTest.addEmployee(employeeTestOne);
        cityDAO.addCity(cityTest);
        cityTest.removeEmployee(employeeTestOne);
        cityTest.addEmployee(employeeTestThree);
        cityDAO.updateCity(cityTest, cityTest.getCityId());
        assertTrue(employeeDAO.returnAllEmployee().contains(employeeTestThree)
                && employeeDAO.returnAllEmployee().contains(employeeTestTwo)
                && !employeeDAO.returnAllEmployee().contains(employeeTestOne));
        cityDAO.deleteCity(cityTest);
    }
    @Test
    @DisplayName("Employee auto creating and deleting after city deleting")
    public void shouldAddCityAndEmployee() {
        cityDAO.addCity(cityTest);
        cityTest.addEmployee(employeeTestTwo);
        cityTest.addEmployee(employeeTestOne);
        cityDAO.updateCity(cityTest,cityTest.getCityId());
        assertTrue(employeeDAO.returnAllEmployee().contains(employeeTestTwo) && employeeDAO.returnAllEmployee().contains(employeeTestOne));
        cityDAO.deleteCity(cityTest);
        assertFalse(employeeDAO.returnAllEmployee().contains(employeeTestOne) && employeeDAO.returnAllEmployee().contains(employeeTestTwo));

    }
}
