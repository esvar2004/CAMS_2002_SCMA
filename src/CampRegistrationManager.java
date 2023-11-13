
import java.util.ArrayList;

public class CampRegistrationManager {
	
	private Student student;
	private ArrayList<Camp> registeredCamps;
	
	public CampRegistrationManager(Student student, ArrayList<Camp> registeredCamps) {
		this.student = student;
		this.registeredCamps = registeredCamps;
	}
	
	public void registerForCamp(Camp camp, Student student) {
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
    	
        registeredCamps.add(camp);
		camp.addAttendee(student);
        System.out.println("Successfully registered for the '" + camp.getName() + "' camp.");
	}
	
	public void withdrawFromCamp(Camp camp) {
		if (registeredCamps.contains(camp)) 
        {
            registeredCamps.remove(camp);
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
