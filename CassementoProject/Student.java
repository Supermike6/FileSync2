package CassementoProject;

import java.util.ArrayList;

public class Student
{
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private String studentID;
    private String name;
    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }
    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
    public String getStudentID() {
        return studentID;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Student(ArrayList<Schedule> schedules, String studentID, String name) {
        this.schedules = schedules;
        this.studentID = studentID;
        this.name = name;
    }
    public Student() {
        this.schedules = new ArrayList<Schedule>();
        this.studentID = "";
        this.name = "";
    }


}
