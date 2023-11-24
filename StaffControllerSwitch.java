import java.util.*;
public class StaffControllerSwitch extends StaffController
{
    public StaffControllerSwitch(Staff staff)
    {
        super(staff);
    }

    public void main()
    {
        Scanner sc = new Scanner(System.in);
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
                manageCamps();
                break;

                case 2: 
                viewCamps();
                break;

                case 3:
                manageEnquiries();
                break;

                case 4:
                manageSuggestions();

                case 5:
                reportGeneration();
                
                default:
                System.out.println("You have exited the staff interface.");
            }
        } while(choice >= 1 && choice <= 5);
    }
}
