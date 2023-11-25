
public class StaffCampViewer implements CampViewerInterface
{
    private Staff staff;

    public StaffCampViewer(Staff staff) {
        this.staff = staff;
    }

    public void viewCampDetails(Camp camp) {
        System.out.println("Camp Details for: " + camp.getName());
        System.out.println("Open Date: " + camp.getOpenDate());
        System.out.println("Close Date: " + camp.getCloseDate());
        System.out.println("Description: " + camp.getDesc());
        // More details can be added as needed
    }

    public void viewAllCamps() //Able to view all camps that are created. (Distinguishing it from the Student View)
    {
        for(Camp camp: Camp.campList)
        {
            System.out.println("Camp Name: " + camp.getName());
        }
    }

    public void viewYourCamps() { //Able to view the list of created camps.
        for (Camp camp : staff.getCreatedCamps()) {
            System.out.println("Camp Name: " + camp.getName());
            // Additional camp details can be displayed here
        }
    }
}
