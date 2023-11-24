import java.util.*;
public class CampCommControllerSwitch extends CampCommController
{
    public CampCommControllerSwitch(CampCommitteeMember commMember)
    {
        super(commMember);
    }

    public void main()
    {
        Scanner sc = new Scanner(System.in);
        int choice = 5; //Initializing Choice to Exit to Enter the do-while loop
        do{
            System.out.println("Select from the given list of options.");
            System.out.println("1. View Camps");
            System.out.println("2. Manage Enquiries");
            System.out.println("3. Manage Suggestions");
            System.out.println("4. Report Generation");
            System.out.println("5. Exit");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1: 
                viewCamps();
                break;

                case 2:
                manageEnquiries();
                break;

                case 3:
                manageSuggestions();
                break;

                case 4:
                reportGeneration();
                break;

                default:
                System.out.println("You have exited the committee member interface.");
            }
        } while(choice >= 1 && choice <= 4);
    }
}

