import java.util.*;
public class StaffControllerSwitch
{
    private Staff staff;
    public StaffControllerSwitch(Staff staff)
    {
        this.staff = staff;
    }

    public void main()
    {
        Scanner sc = new Scanner(System.in);
        StaffController control = new StaffController(staff);
        int choice = 6; //Initializing Choice to Exit to Enter the do-while loop
        do{
            System.out.println("Select from the given list of options.");
            System.out.println("1. Manage Camps");
            System.out.println("2. View Camps");
            System.out.println("3. Manage Enquiries");
            System.out.println("4. Manage Suggestions");
            System.out.println("5. Report Generation");
            System.out.println("6. Exit");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1: 
                control.manageCamps();
                break;

                case 2: 
                control.viewCamps();
                break;

                case 3:
                control.manageEnquiries();
                break;

                case 4:
                control.manageSuggestions();

                case 5:
                control.reportGeneration();
                
                default:
                System.out.println("You have exited the staff interface.");
            }
        } while(choice >= 1 && choice <= 5);
    }
}
