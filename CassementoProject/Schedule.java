package CassementoProject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Schedule
{
    private ArrayList<Course> courses = new ArrayList<>();
    private int year;
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    
}
