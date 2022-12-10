package APCompsci.Homework;

public class Movie
{
    private String title;
    private double length;
    private String[] actors = new String[1];
    private int rating;

    Movie()
    {
        title = "";
        length = 0.0;
        actors[0] = "";
        rating = 0;
        
    }

    //constructors
    Movie(String title)
    {
        this.title=title;
    }
    Movie(double length)
    {
        this.length=length;
    }
    Movie(String[] actors)
    {
        this.actors=actors;
    }
    Movie(int rating)
    {
        this.rating=rating;
    }
    Movie(String title, double length)
    {
        this.title=title;
        this.length=length;
    }
    Movie(String title, double length, String[] actors, int rating)
    {
        this.title=title;
        this.length=length;
        this.actors=actors;
        this.rating=rating;
    }
    
    //getters
    public String getTitle()
    {
    	return this.title;
    }
    public double getLength()
    {
    	return this.length;
    }
    public String[] getActors()
    {
    	return this.actors;
    }
    public int getRating()
    {
    	return this.rating;
    }
    //setters
    public void setTitle(String title)
    {
    	this.title=title;
    }
    public void setLength(double length)
    {
    	this.length=length;
    }
    public void setActors(String[] actors)
    {
    	this.actors=actors;
    }
    public void setRating(int rating)
    {
    	this.rating=rating;
    }
    
    //other methods

}
