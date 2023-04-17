import model.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    private final Session session;
    public CityDAOImpl(Session session) {
        this.session = session;
    }
    @Override
    public void addCity(City city) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
    }
    @Override
    public City returnCityById(Long id) {
        return session.get(City.class, id);
    }
    @Override
    public List<City> returnAllCity() {
            return session.createNamedQuery("City_all", City.class).list();
    }
    @Override
    public void updateCity(City city, Long id) {
            Transaction transaction = session.beginTransaction();
            city.setCityId(id);
            session.update(city);
            transaction.commit();
    }
    @Override
    public void deleteCity(City city) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
    }
}
