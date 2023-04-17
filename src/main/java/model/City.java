package model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(name = "City_all",
                query = "from City") //почему то, не видит orm.xml с этими настройками
})
@NoArgsConstructor
@Data
@EqualsAndHashCode (of = "cityId")
@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;
    @Column(name = "city_name", length = 168, nullable = false)
    private String cityName;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList = new ArrayList<>();
    public City(String cityName) {
        this.cityName = cityName;
    }
    public void addEmployee(Employee employee){
        employee.setCity(this);
        employeeList.add(employee);
    }
    public void removeEmployee(Employee employee){
        employee.setCity(null);
        employeeList.remove(employee);
    }
    @Override
    public String toString() {
        return "City {" +
                "cityId = " + cityId +
                ", cityName = '" + cityName + '\'' +
                ", employees id = " + (employeeList.stream().map(x -> String.valueOf(x.getId())).collect(Collectors.joining(", "))) +
                '}';
    }
}

