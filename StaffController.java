import java.util.*;
public class StaffController 
{
    private Staff staff;

    public StaffController(Staff staff)
    {
        this.staff = staff;
    }

    public void manageCamps()
    {
        Scanner sc = new Scanner(System.in);
        CampManager manager = new CampManager(staff);
        StaffCampViewer viewer = new StaffCampViewer(staff);
        int campChoice = 0;
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do{
            System.out.println("Select from the given list of options.");
            System.out.println("1. Create Camp");
            System.out.println("2. Edit Camp");
            System.out.println("3. Delete Camp");
            System.out.println("4. Exit");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1: 
                manager.createCamp();
                break;

                case 2: 
                System.out.println("Which camp's details would you like to edit? (1 - " + staff.getCreatedCamps().size() + ")");
                viewer.viewYourCamps();
                campChoice = sc.nextInt();
                manager.editCamp(staff.getCreatedCamps().get(campChoice - 1));
                break;

                case 3:
                System.out.println("Which camp's details would you like to delete? (1 - " + staff.getCreatedCamps().size() + ")");
                viewer.viewYourCamps();
                campChoice = sc.nextInt();
                manager.editCamp(staff.getCreatedCamps().get(campChoice - 1));
                break;
                
                default:
                System.out.println("Please select an appropriate option next time.");
            }
        } while(choice >= 1 && choice <= 3);
    }

    public void viewCamps()
    {
        Scanner sc = new Scanner(System.in);
        StaffCampViewer viewer = new StaffCampViewer(staff);
        int campChoice = 0;
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("Select from the given list of options.");
            System.out.println("1. View Specific Details of a Camp");
            System.out.println("2. View All Camps");
            System.out.println("3. View Your Created Camps");
            System.out.println("4. Exit");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1: 
                System.out.println("Which camp's details would you like to view? (1 - " + staff.getCreatedCamps().size() + ")");
                viewer.viewYourCamps();
                campChoice = sc.nextInt();
                viewer.viewCampDetails(staff.getCreatedCamps().get(campChoice - 1));
                break;

                case 2: 
                viewer.viewAllCamps();
                break;

                case 3:
                viewer.viewYourCamps();
                break;

                default:
                System.out.println("Please select an appropriate option next time.");
            }
        } while(choice >= 1 && choice <= 3);
    }

    public void manageEnquiries()
    {
        Scanner sc = new Scanner(System.in);
        StaffCampViewer viewer = new StaffCampViewer(staff);
        StaffEnquiryManager enquiryManager = new StaffEnquiryManager(staff);
        int campChoice = 0;
        int enquiryChoice = 0;
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("Select from the given list of options.");
            System.out.println("1. View Enquiries");
            System.out.println("2. Submit Response/Edit Response");
            System.out.println("3. Exit");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1: 
                enquiryManager.viewEnquiries();
                break;

                case 2: 
                System.out.println("To which camp would you like to submit an enquiry response? (1 - " + staff.getCreatedCamps().size() + ")");
                viewer.viewYourCamps();
                campChoice = sc.nextInt();
                System.out.println("Which enquiry would you like to respond to? (1 - " + staff.getCreatedCamps().get(campChoice).getEnquiries().size() + ")");
                enquiryChoice = sc.nextInt();
                System.out.println("What is your response?");
                String response = sc.nextLine();
                enquiryManager.editEnquiry(staff.getCreatedCamps().get(campChoice).getEnquiries().get(enquiryChoice), response);
                break;

                default:
                System.out.println("Please select an appropriate option next time.");
            }
        } while(choice >= 1 && choice <= 2);
    }
}
