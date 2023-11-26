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
        /*CampCommCampViewer viewer = new CampCommCampViewer(commMember);
        int campChoice = 0;
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. View Specific Details of a Camp");
            System.out.println("2. View All Camps");
            System.out.println("3. View Your Registered Camps");
            System.out.println("4. Exit");
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
                    if (viewer.viewAvailableCamps(commMember.getFaculty()).size() == 0) {
                        System.out.println("There are no camps you can view!");
                        break;
                    }else if(viewer.viewAvailableCamps(commMember.getFaculty()).size() == 1){
                        System.out.println("You can only view one camp:");
                        Time.pause(1);
                        viewer.viewCampDetails(viewer.viewAvailableCamps(commMember.getFaculty()).get(0));
                        break;
                    }
                    System.out.println("Which camp's details would you like to view? (1 - " + viewer.viewAvailableCamps(commMember.getFaculty()).size() + ")");
                    viewer.viewAllCamps();
                    
                    while (true) {
                        try {
                            campChoice = sc.nextInt();
                            if (campChoice <= 0) {
                                System.out.println("Error: Please enter a positive integer.");
                            } else {
                                break; 
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid integer.");
                            sc.nextLine(); // clear buffer
                        }
                    }
                    viewer.viewCampDetails(viewer.viewAvailableCamps(commMember.getFaculty()).get(campChoice - 1));
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
        } while(choice >= 1 && choice <= 3);*/
    }

    public void manageCampCommEnquiries()
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
                    enquiryManager.viewEnquiries();
                    enquiryChoice = sc.nextInt();
                    System.out.println("What is your response?");
                    sc.nextLine();
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
                    sc.nextLine();
                    suggestion = sc.nextLine();
                    suggestionManager.submitSuggestion(suggestion);
                    break;

                case 3:
                    System.out.println("Which of your suggestions would you like to edit? (1 - " + commMember.getSuggestions().size() + ")");
                    suggestionManager.viewSuggestions();
                    suggestionChoice = sc.nextInt();
                    System.out.println("What is your updated suggestion?");
                    sc.nextLine();
                    suggestion = sc.nextLine();
                    suggestionManager.editSuggestion(commMember.getSuggestions().get(suggestionChoice - 1), suggestion);
                    break;

                case 4:
                    System.out.println("Which of your suggestions would you like to delete? (1 - " + commMember.getSuggestions().size() + ")");
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
        CampCommCampViewer viewer = new CampCommCampViewer(commMember); // Assuming 'staff' is the current Staff object
        CampCommEnquiryManager enquiryManager = new CampCommEnquiryManager(commMember);
        ReportGenerator reportGenerator = new ReportGenerator(); // Assuming this is how you instantiate ReportGenerator
        int choice = 3;
        do {
            System.out.println("\nSelect the report you want to generate:");
            System.out.println("1. Generate Camp Report");
            System.out.println("2. Generate Enquiry Report");
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
    
            switch (choice) {
                case 1:
                reportGenerator.generateCampReport(commMember.getCamp());

                case 2:
                reportGenerator.generateEnquiryReport(commMember.getEnquiries());

                case 3:
                System.out.println("Exiting report generation module.");
                break;
            }
        } while (choice != 3);
    }
    }
}
