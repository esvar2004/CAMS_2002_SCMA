import java.util.*;
public class CampCommControllerSwitch
{
    private CampCommitteeMember commMember;
    public CampCommControllerSwitch(CampCommitteeMember commMember)
    {
        this.commMember = commMember;
    }

    public void main()
    {
        Scanner sc = new Scanner(System.in);
        CampCommController control = new CampCommController(commMember);
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
                control.viewCamps();
                break;

                case 2:
                control.manageEnquiries();
                break;

                case 3:
                control.manageSuggestions();
                break;

                case 4:
                control.reportGeneration();
                break;

                default:
                System.out.println("You have exited the committee member interface.");
            }
        } while(choice >= 1 && choice <= 4);
    }
}

