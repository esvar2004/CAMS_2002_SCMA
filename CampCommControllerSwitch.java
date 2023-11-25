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
            while (true){
                try {
                choice = sc.nextInt();
                if (choice <= 0) {
                    System.out.println("Error: Please enter a positive integer.");
                } else {
                    break; 
                }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid integer.");
                    sc.nextLine(); // clear buffer
                }
            }

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

                case 5:
                System.out.println("You have exited the committee member interface.");
                break;

                default:
                System.out.println("Please enter a valid input");
            }
        } while(choice != 5);
    }
}

