
import java.util.ArrayList;


public class Student 
{
	private String userId;
    private String password;
    private String faculty;
    private String role;
    private boolean committeeMember;
    private ArrayList<Camp> registeredCamps;
    private ArrayList <String> enquires;



	public Student(String userId, String password, String faculty) 
	{
		this.userId = userId;
		this.password = password;
		this.faculty = faculty;
		this.role = "Attendee"; // Default role is "Attendee"
		this.committeeMember = false; // Default is false
		this.registeredCamps = new ArrayList<Camp>();
		this.enquires = new ArrayList<String>();

	}

    public String getUserID() 
    {
        return this.userId;
    }

    public void setUserID(String userId) 
    {
        this.userId = userId;
    }
    
    public String getPassword()
    {
    	return this.password;
    }
    
    public void setPassword(String password)
    {
    	this.password = password;
    }

    public String getFaculty() 
    {
        return this.faculty;
    }

    public void setFaculty(String faculty) 
    {
        this.faculty = faculty;
    }

    public String getRole() 
    {
        return this.role;
    }

    public void setRole(String role) 
    {
        this.role = role;
    }
    
    
	public void viewCamps(ArrayList<Camp> campList)// view the list of camps open to the student and the remaining slots available
	{
		for (int i = 0; i < campList.size(); i++) 
		{
			{
				System.out.print(campList.get(i));
				System.out.println("   Remaining Slots: " + viewRemainingSlots(campList.get(i)));
			}
		}
	}
	
	public int viewRemainingSlots(Camp camp) //view remaining slots of camp
	{
		return camp.getTotSlots() - camp.getCurrentSlots();
	}

	// Method to manage inquiries related to a camp
    public void showEnquiry() 
    {
    	System.out.println(this.enquires);
    }
    
    public void addEnquiry(Camp camp, String enquiry)
    {
    	this.enquires.add(camp.getName() + "  :" + enquiry);
    }
    
    public void delEnquiry(Camp camp, String enquiry)
    {
    	for (int i = 0; i < this.enquires.size(); i++)//find the enquiry to delete
    	{
    		if (this.enquires.get(i).equals(camp.getName() + "  :" + enquiry))
    		{
    			this.enquires.remove(i);
    		}
    	}
    }
	
	
    // Method to register for a camp
    public void registerForCamp(Camp camp, String role) 
    {
    	if (camp == null)//check for non-existant camp
    	{
    		System.out.println("Camp do not exist");
    		return;
    	}
    	
    	if (camp.getTotSlots() - camp.getCurrentSlots() == 0) //check for empty slots
    	{
            System.out.println("This camp is already full. Registration is closed.");
            return;
    	}
    	
    	if ((camp.getList()).contains(this)) //check for previous registration
    	{
    		System.out.println("Unable to register for a camp you withdrawn");
    		return;
    	}
    	
    	if (camp.isPastRegistrationDeadline()) //check if registration is passed the deadline
    	{
            System.out.println("Registration deadline for this camp has passed.");
            return;
        }
        
        for (Camp registeredCamp : registeredCamps)
        {
            if (camp.hasDateClash(registeredCamp)) //check for date clashes with other camps
            {
                System.out.println("You have a date clash with another camp.");
                return;
            }
            if (registeredCamp.equals(camp)) //check if registering for the same camp
            {
                System.out.println("You are already registered for this camp.");
                return;
            }
        }
    	if (role.equals("Attendee")) 
    	{
    		registeredCamps.add(camp);
    		camp.assignRole(this, role);
    	}
    	else if (role.equals("committee"))
    	{
    		if (!this.committeeMember)
    		{
    			registeredCamps.add(camp);
    			committeeMember = true;
    			camp.assignRole(this, role);
    			//insert function for committee member
    		}
    		else
    		{
    			System.out.println("Every Student can only be a committee member of one camp");
    			return;
    		}
    	}
    	else // check for invalid roles
    	{
    		System.out.println("Enter a valid role");
    		return;
    	}
    	
        registeredCamps.add(camp);
        camp.addAttendee(this);
        System.out.println("Successfully registered for the '" + camp.getName() + "' camp.");
    }

    // Method to withdraw from a camp
    public void withdrawFromCamp(Camp camp) 
    {
        if (registeredCamps.contains(camp)) 
        {
            registeredCamps.remove(camp);
            camp.removeAttendee(this);
            System.out.println("Withdrew from the '" + camp.getName() + "' camp.");
        } else 
        {
            System.out.println("You are not registered for the '" + camp.getName() + "' camp.");
        }
    }
	
	public void viewRegisteredCamps(Student student) 
	{
        System.out.println("Registered Camps:");
        for (Camp camp : registeredCamps) 
        {
            System.out.println(userId + ": " + camp.getName() + " (" + camp.getRoleOfStudent(student) + ")");
        }
    }

}
