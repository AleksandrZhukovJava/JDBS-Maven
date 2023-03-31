package dbObjects;

import java.util.Objects;

public class Employee {
    private final int id;
    public String firstName;
    public String lastName;
    public String genderName;
    public int age;
    public int cityId;

    public Employee(int id, String firstName, String lastName, String gender_name, int age, int cityId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.genderName = gender_name;
        this.age = age;
        this.cityId = cityId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGenderName() {
        return genderName;
    }

    public int getAge() {
        return age;
    }

    public int getCityId() {
        return cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age && id == employee.id && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && genderName.equals(employee.genderName) && Objects.equals(cityId, employee.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", gender_name='" + genderName + '\'' +
                ", age=" + age +
                ", cityId=" + cityId +
                "}\n";
    }
}
