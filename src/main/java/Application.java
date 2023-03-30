import java.sql.*;

public class Application {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/skypro";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "helloskypro";

    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {

        //task 1
        printnEmployeeById(2);

        //task 2
        try (Connection connection = doConnection()) {
            EmployeeDAO employeeDAO = new EmployeeDaoImpl(connection);
            employeeDAO.updateEmployeeById(14, "first_name = 'hello'", "last_name = 'done'");
            employeeDAO.createEmployee("scanner", "willbe", "here", 31, 4);
            System.out.println(employeeDAO.returnEmployeeById(14).toString());
            System.out.println(employeeDAO.readAllEmployee());
            employeeDAO.deleteEmployeeById(13);
            employeeDAO.deleteEmployeeById(14);

        } catch (SQLException i) {
            i.printStackTrace();
        }
    }

    private static Connection doConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static void printnEmployeeById(int id) {
        try (Connection connection = doConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT first_name, last_name, gender, age, c.city_name  FROM employee e LEFT JOIN city c on c.city_id = e.city_id WHERE e.id = ?;")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            System.out.printf("Name - %s %s, gender - %s, age - %d, city - %s\n",
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5));
        } catch (SQLException ignored) {
        }
    }
}
