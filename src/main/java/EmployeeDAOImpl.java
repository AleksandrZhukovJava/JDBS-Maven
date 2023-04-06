import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final Session session;
    public EmployeeDAOImpl(Session session) {
        this.session = session;
    }
    @Override
    public void addEmployee(Employee employee) {
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
    }
    @Override
    public Employee returnEmployeeById(Long id) {
            return session.get(Employee.class, id);
    }
    @Override
    public List<Employee> returnAllEmployee() {
            return session.createNamedQuery("Employee_all", Employee.class).list();
    }
    @Override
    public void updateEmployee(Employee employee, Long id) {
            Transaction transaction = session.beginTransaction();
            employee.setId(id);
            transaction.commit();
    }
    @Override
    public void deleteEmployee(Employee employee) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
    }
}
