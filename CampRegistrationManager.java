import java.util.ArrayList;

public class CampRegistrationManager {
	
	private Student student;
	private ArrayList<Camp> registeredCamps;
	
	public CampRegistrationManager(Student student) {
		this.student = student;
		this.registeredCamps = student.getRegisteredCamps();
	}
	
    public void viewRegisteredCamps(){
        for(Camp camp: registeredCamps)
        {
            System.out.println("Camp Name: " + camp.getName());
        }
    }

	public void registerForCamp(Camp camp, Student student, String role) {
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
    		camp.assignRole(student, role);
    	}
    	else if (role.equals("committee"))
    	{
    		if (!student.getCommMember())
    		{
    			registeredCamps.add(camp);
    			student.setCommMember(true);
    			camp.assignRole(student, role);
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

        student.getRegisteredCamps().add(camp);
		camp.addAttendee(student);
        System.out.println("Successfully registered for the '" + camp.getName() + "' camp.");
	}
	
	public void withdrawFromCamp(Camp camp, Student student) {
		if (student.getRegisteredCamps().contains(camp)) 
        {
            student.getRegisteredCamps().remove(camp);
            camp.removeAttendee(student);
            System.out.println("Withdrew from the '" + camp.getName() + "' camp.");
        } else 
        {
            System.out.println("You are not registered for the '" + camp.getName() + "' camp.");
        }
	}
	
	public void listRegisteredCamps(Student student) {
		System.out.println("Registered Camps:");
        for (Camp camp : student.getRegisteredCamps()) 
        {
            System.out.println(camp.getName() + ": " + camp.getName() + " (" + camp.getRoleOfStudent(student) + ")");
        }
	}
}
