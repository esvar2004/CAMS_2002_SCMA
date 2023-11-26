import java.util.ArrayList;

abstract public class User {
	private String name;
	private String email;
    private String password = "password";
    private String faculty;
    
    public User(String name, String email, String faculty) 
    {
    	this.name = name;
    	this.email = email;
    	this.faculty = faculty;
    }
    
    public String getName() 
    {
        return this.name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    protected String getPassword()
    {
    	return this.password;
    }
    
    protected void setPassword(String password)
    {
    	this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getFaculty() 
    {
        return this.faculty;
    }

    public void setFaculty(String faculty) 
    {
        this.faculty = faculty;
    }
    
    public void viewCamps(ArrayList<Camp> campList)
    {
        for(int i = 0; i < campList.size(); i++)
        {
            System.out.println(campList.get(i));
        }
    }
}
