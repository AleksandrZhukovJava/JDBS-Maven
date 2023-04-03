package model;

import lombok.*;
import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
@Table (name = "employee")
public class Employee {
    @Id
    @Column (name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column (name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column (name = "gender", length = 6, nullable = false)
    private String gender;
    @Column (name = "age", nullable = false)
    private int age;
    @Column (name = "city_id")
    private Integer cityId;

    public Employee(String firstName, String lastName, String gender, int age, Integer cityId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
    }
}
