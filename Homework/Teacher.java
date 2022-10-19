package Homework;

import java.util.ArrayList;
import java.util.Objects;

public class Teacher
{
    String fisrtName;
    String lastName;
    Integer id;
    ArrayList<Course> schedule;   
    static Integer NextId = 0; 

    public Teacher(String lastName, String firstName)
    {
        this.fisrtName = firstName;
        this.lastName = lastName;
        this.id = NextId;
        this.schedule = new ArrayList<Course>();
    }
    public Teacher(String fullName)
    {
        this.fisrtName = fullName.substring(0,fullName.indexOf(" "));
        this.lastName = fullName.substring(fullName.indexOf(" ")+1);
        this.id = NextId;
        this.schedule = new ArrayList<Course>();
    }
    public Teacher(String lastName, String firstName, Integer id, ArrayList<Course> schedule)
    {
        this.fisrtName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.schedule = schedule;
    }

    public String getFisrtName() {
        return this.fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Course> getSchedule() {
        return this.schedule;
    }

    public void setSchedule(ArrayList<Course> schedule) {
        this.schedule = schedule;
    }
    @Override
    public String toString() {
        return "{" +
            " fisrtName='" + getFisrtName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", id='" + getId() + "'" +
            ", schedule='" + getSchedule() + "'" +
            "}";
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Teacher)) {
            return false;
        }
        Teacher teacher = (Teacher) o;
        return Objects.equals(fisrtName, teacher.fisrtName) && Objects.equals(lastName, teacher.lastName) && Objects.equals(id, teacher.id) && Objects.equals(schedule, teacher.schedule);
    }
    @Override
    public int hashCode() {
        return Objects.hash(fisrtName, lastName, id, schedule);
    }

}
