package CassementoProject;

public class Course
{
    private String classID;    
    private String description;    
    private Requirement requirement;    

    public Course()
    {
        this.classID = "";
        this.description = "";
        this.requirement = null; 
    }

    public Course(String classID, String description, String requirement) {
        this.classID = classID;
        this.description = description;
        this.requirement = requirement;
    }
}
