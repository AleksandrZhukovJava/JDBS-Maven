package model;

import lombok.*;
import javax.persistence.*;

@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(name = "Employee_all",
                query = "from Employee") //почему то, не видит orm.xml с этими настройками
        })
@NoArgsConstructor
@Data
@EqualsAndHashCode (of = "id")
@Entity
@Table (name = "employee")
public class Employee {
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column (name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column (name = "gender", length = 6, nullable = false)
    private String gender;
    @Column (name = "age", nullable = false)
    private int age;
    @ManyToOne (cascade = CascadeType.PERSIST, fetch = FetchType.LAZY) //Почему то в базу не добавляется город при добавлении сотрудника
    @JoinColumn (name = "city_id")
    private City city;
    public Employee(String firstName, String lastName, String gender, int age, City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }
    @Override
    public String toString() {
        return "Employee {" +
                "id = " + id +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", gender = '" + gender + '\'' +
                ", age = " + age +
                ", city = " + (city == null ? "unknown" : city.getCityName()) +
                '}';
    }
}
