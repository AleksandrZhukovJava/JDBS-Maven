package dbObjects;

import java.util.Objects;

public class Employee {
    private final int id;
    public String first_name;
    public String last_name;
    public String gender_name;
    public int age;
    public int city_id;

    public Employee(int id, String first_name, String last_name, String gender_name, int age, int city_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender_name = gender_name;
        this.age = age;
        this.city_id = city_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender_name(String gender_name) {
        this.gender_name = gender_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender_name() {
        return gender_name;
    }

    public int getAge() {
        return age;
    }

    public int getCity_id() {
        return city_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age && id == employee.id && first_name.equals(employee.first_name) && last_name.equals(employee.last_name) && gender_name.equals(employee.gender_name) && Objects.equals(city_id, employee.city_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender_name='" + gender_name + '\'' +
                ", age=" + age +
                ", city_id=" + city_id +
                "}\n";
    }
}
