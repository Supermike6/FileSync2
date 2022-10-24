package Homework;

import java.util.Objects;

public class Course
{
    private Integer roomNumber;
    private String Name;
    private String startTime;
    private String endTime;

    public Course(Integer roomNum, String Name, String startTime, String endTime)
    {
        this.roomNumber = roomNum;
        this.Name = Name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Course()
    {
        this.roomNumber = 0;
        this.Name = "";
        this.startTime = "00:00";
        this.endTime = "00:00";
    }

    public Course(String string, String name2, int i, int j)
    {
        
    }
    public Integer getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Course)) {
            return false;
        }
        Course course = (Course) o;
        return Objects.equals(roomNumber, course.roomNumber) && Objects.equals(Name, course.Name) && Objects.equals(startTime, course.startTime) && Objects.equals(endTime, course.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, Name, startTime, endTime);
    }


    @Override
    public String toString() {
        return "{" +
            " roomNumber='" + getRoomNumber() + "'" +
            ", Name='" + getName() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            "}";
    }

}
