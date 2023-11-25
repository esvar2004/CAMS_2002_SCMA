import java.util.*;
public class CampCommController extends StudentController
{
    private CampCommitteeMember commMember;
    public static Scanner sc = new Scanner(System.in);

    public CampCommController(CampCommitteeMember commMember)
    {
        super(commMember);
        this.commMember = commMember;
    }

    public void viewCamps()
    {
        super.viewCamps();
    }

    public void manageEnquiries()
    {
        CampCommEnquiryManager enquiryManager = new CampCommEnquiryManager(commMember);
        int enquiryChoice = 0;
        int choice = 3; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. View Enquiries");
            System.out.println("2. Submit Response/Edit Response");
            System.out.println("3. Exit");
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
                    enquiryManager.viewEnquiries();
                    break;

                case 2: 
                    System.out.println("Which enquiry would you like to respond to? (1 - " + commMember.getCamp().getEnquiries().size() + ")");
                    enquiryChoice = sc.nextInt();
                    System.out.println("What is your response?");
                    String response = sc.nextLine();
                    enquiryManager.editEnquiry(commMember.getCamp().getEnquiries().get(enquiryChoice - 1), response);
                    break;

                case 3:
                    System.out.println("Returning to Menu...");
                    Time.pause(2);
                    break;

                default:
                    System.out.println("Please enter a valid input");
            }
        } while(choice != 3);
    }

    public void manageSuggestions()
    {
        //StaffCampViewer viewer = new StaffCampViewer(staff);
        CampCommSuggestionManager suggestionManager = new CampCommSuggestionManager(commMember);
        int suggestionChoice = 0;
        String suggestion = "";
        int choice = 5; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. View Your Suggestions");
            System.out.println("2. Submit Suggestion");
            System.out.println("3. Edit Suggestion");
            System.out.println("4. Delete Suggestion");
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
                    suggestionManager.viewSuggestions();
                    break;

                case 2: 
                    System.out.println("What is the suggestion you would like to make?");
                    suggestion = sc.nextLine();
                    suggestionManager.submitSuggestion(suggestion);
                    break;

                case 3:
                    System.out.println("Which of your suggestions would you like to edit? (1 - " + commMember.getSuggestions().size() + ")");
                    suggestionManager.viewSuggestions();
                    suggestionChoice = sc.nextInt();
                    System.out.println("What is your updated suggestion?");
                    suggestion = sc.nextLine();
                    suggestionManager.editSuggestion(commMember.getSuggestions().get(suggestionChoice - 1), suggestion);
                    break;

                case 4:
                    System.out.println("Which of your suggestions would you like to delete?");
                    suggestionManager.viewSuggestions();
                    suggestionChoice = sc.nextInt();
                    suggestionManager.deleteSuggestion(commMember.getSuggestions().get(suggestionChoice - 1));
                    break;

                    case 5:
                    System.out.println("Returning to Menu...");
                    Time.pause(1);
                    break;

                default:
                    System.out.println("Please enter a valid input");
            }
        } while(choice != 5);
    }

    public void reportGeneration() {
        ReportGenerator reportGenerator = new ReportGenerator();
        System.out.println("Generate performance report for the committee member?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int choice = -1;
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

        switch (choice) {
            case 1:
                // Generate the performance report for commMember
                reportGenerator.generatePerformanceReport(commMember);
                System.out.println("Performance report generated for " + commMember.getName());
                break;

            case 2:
                // Exit without generating the report
                System.out.println("Exiting report generation module.");
                Time.pause(1);
                break;

            default:
                System.out.println("Invalid option, please try again.");
        }
    }
}
