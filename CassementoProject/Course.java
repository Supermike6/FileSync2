package CassementoProject;

public class Course
{
    private String classID;    
    private String description;    
    private String requirement;

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

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    
}
