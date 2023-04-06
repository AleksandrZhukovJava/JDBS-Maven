import model.City;
import java.util.List;

public interface CityDAO {
    void addCity(City city);
    City returnCityById(Long id);
    List<City> returnAllCity();
    void updateCity(City city, Long id);
    void deleteCity(City city);

}

