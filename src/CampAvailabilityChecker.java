import java.util.ArrayList;

public class CampAvailabilityChecker {
	
	private ArrayList<Camp> campList;
	private Student student;
	
	public CampAvailabilityChecker(ArrayList<Camp> campList, Student student) {
		this.campList = campList;
		this.student = student;
	}
	
	void checkCampAvailability(Camp camp) {//check for registration deadline
		if(camp.isPastRegistrationDeadline()) {//check if past registration deadline
			System.out.println("The registration deadline has passed");
		}
		else if(!camp.hasAvailableSlots()) {//check if there is remaining slots
			System.out.println("There is no more available slots");
		}
		else {
			System.out.println("This camp is available for registration");
		}
	}
	
	void listAvailableCamps(Student student) {
		for (int i = 0; i < campList.size(); i++) 
		{
			if(campList.get(i).getVisibility() //show visible camps
					&&(campList.get(i).getSchool().equals(student.getFaculty()) //check for matching school
					|| campList.get(i).getSchool().equals("NTU"))) // check if camp is open to whole school
			{
				System.out.print(campList.get(i));
				System.out.println("   Remaining Slots: " + (campList.get(i).getTotalSlots()- campList.get(i).getCurrentSlots()));
			}
		}
	}
}
