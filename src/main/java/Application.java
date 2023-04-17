import model.Employee;

public class Application {

    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
        Employee employeeTest = new Employee("Test", "Test", "Test", 18, 1);
        try {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//            employeeDAO.returnAllEmployee().forEach(System.out::println);
//            System.out.println(employeeDAO.returnEmployeeById(19));
            employeeDAO.addEmployee(employeeTest);
            employeeDAO.updateEmployee(employeeTest,2);
            HibernateSessionUtil.getSessionFactory().close();
        } catch (Exception i) {
            i.printStackTrace();
        }
    }
}
