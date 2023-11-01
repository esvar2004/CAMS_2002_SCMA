import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Date;
import java.util.Calendar;

public class Camp
{
    private String name;
    private Date openDate;
    private Date closeDate;
    private Date regClose;
    private String school;
    private int totSlots;
    private int commSlots;
    private String desc;
    private String nameOfStaff;
    private boolean visibility;
    private ArrayList<Student> campList;
    private int currentSlots;
    private Date now = new Date();
    private HashMap<Student, String> rolesMap = new HashMap<>();
    private int numCommitteeMembers; //NEW

    public Camp(String name, Date openDate, Date closeDate, Date regClose, String school, int totSlots, int commSlots, String desc, String nameOfStaff)
    {
        this.name = name;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.regClose = regClose;
        this.school = school;
        this.totSlots = totSlots;
        this.commSlots = commSlots;
        this.desc = desc;
        this.nameOfStaff = nameOfStaff;
        this.visibility = true;
        campList = new ArrayList<Student>();
        this.currentSlots = 0;
        this.numCommitteeMembers = 0;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOpenDate(Date openDate)
    {
        this.openDate = openDate;
    }

    public void setCloseDate(Date closeDate)
    {
        this.closeDate = closeDate;
    }

    public void setRegDate(Date regClose)
    {
        this.regClose = regClose;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }

    public void setTotSlots(int totSlots)
    {
        this.totSlots = totSlots;
    }

    public void setCommSlots(int commSlots)
    {
        this.commSlots = commSlots;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public void setVisibility(boolean visibility)
    {
        this.visibility = visibility;
    }

    public String getName()
    {
        return this.name;
    }
    
    public Date getOpenDate()
    {
        return this.openDate;
    }
    
    public Date getCloseDate()
    {
        return this.closeDate;
    }
    
    public Date getRegDate()
    {
        return this.regClose;
    }

    public String getSchool()
    {
        return this.school;
    }

    public int getTotSlots()
    {
        return this.totSlots;
    }

    public int getCommSlots()
    {
        return this.commSlots;
    }

    public String getStaffName()
    {
        return this.nameOfStaff;
    }
    
    public String getDesc()
    {
        return this.desc;
    }

    public ArrayList<Student> getList()
    {
        return this.campList;
    }
    public int getCurrentSlots()
    {
    	return this.currentSlots;
    }
    public void addAttendee(Student student) 
	{
        if (this.hasAvailableSlots()) { // Only add if there's an available slot.
            this.campList.add(student);
            this.currentSlots++;
            // If attendee is a committee member, you might increase the numCommitteeMembers here depending on your logic.
        }
        // You might want to add else logic here to handle the scenario when there are no available slots.
    }
    public void removeAttendee(Student student) 
	{
		campList.remove(student);
		this.currentSlots -= 1;
		campList.add(student);
	}

	public boolean isPastRegistrationDeadline() 
	{
		if (now.after(this.closeDate)) return true;
		return false;
	}

	public boolean hasDateClash(Camp camp) 
	{
		if(!(this.openDate.after(camp.getCloseDate())||camp.getOpenDate().after(this.closeDate))) return true;// have date clash
		else return false;
	}
	
	// Method to assign roles to students within the camp
    public void assignRole(Student student, String role) 
    {
        rolesMap.put(student, role);
    }
    
    // Method to retrieve the role of a specific student in the camp
    public String getRoleOfStudent(Student student) 
    {
        return rolesMap.get(student);
    }
    
    // NEW method to check if there are available slots for new attendees.
    public boolean hasAvailableSlots() {
        // Check if the current slots filled (including committee members) are less than the total available slots.
        return this.currentSlots + this.numCommitteeMembers < this.totSlots;
    }
    
    // Method to add a committee member to the camp, assuming they occupy a regular slot.
    public void addCommitteeMember(Student committeeMember) {
        if (this.hasAvailableSlots()) { // Only add if there's an available slot.
            this.campList.add(committeeMember);
            this.currentSlots++;
            this.numCommitteeMembers++; // Increase the number of committee members.
        } else {
            // Handle the case when there are no available slots.
            System.out.println("Cannot add committee member: no available slots."); // Again, this is a simple message.
        }
    }

    // If the committee member is removed, you should also update the count.
    public void removeCommitteeMember(Student committeeMember) {
        if (this.campList.remove(committeeMember)) { // Only remove if the member is in the list.
            this.currentSlots--;
            this.numCommitteeMembers--; // Decrease the number of committee members.
        }else {
            // Handle the case when the committee member isn't found.
            System.out.println("Committee member not found in the list."); // Simple message for the situation.
        }
    }
    
    // Method to get the number of slots available for committee members.
    public int getAvailableCommitteeSlots() {
        // Assuming committee members are included in the total slots, the available slots for them would be:
        return this.commSlots - this.numCommitteeMembers;
    }

    // Example (you should adjust according to your exact logic):
    public int getTotalSlots() {
        // If committee members are counted in total slots, just return the original total slots.
        return this.totSlots;
    }

    public int getOccupiedSlots() {
        // This would be the sum of regular occupants and committee members.
        return this.currentSlots + this.numCommitteeMembers;
    }


    
    
}