package dbObjects;

import java.util.Objects;

public class City {
    private final int cityId;
    private String cityName;

    public City(int city_id, String city_name) {
        this.cityId = city_id;
        this.cityName = city_name;
    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return cityId == city.cityId && cityName.equals(city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
