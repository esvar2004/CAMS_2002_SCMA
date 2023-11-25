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
        int choice = 3; //Initializing Choice to Exit to Enter the do-while loop
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
                    System.out.println("Which enquiry would you like to respond to? (1 - " + staff.getCreatedCamps().get(campChoice - 1).getEnquiries().size() + ")");
                    enquiryChoice = sc.nextInt();
                    System.out.println("What is your response?");
                    String response = sc.nextLine();
                    enquiryManager.editEnquiry(staff.getCreatedCamps().get(campChoice - 1).getEnquiries().get(enquiryChoice - 1), response);
                    break;

                default:
                    System.out.println("Please select an appropriate option next time.");
            }
        } while(choice >= 1 && choice <= 2);
    }

    public void manageSuggestions()
    {
        Scanner sc = new Scanner(System.in);
        StaffCampViewer viewer = new StaffCampViewer(staff);
        StaffSuggestionManager suggestionManager = new StaffSuggestionManager(staff);
        int campChoice = 0;
        int suggestionChoice = 0;
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("Select from the given list of options.");
            System.out.println("1. View All Suggestions");
            System.out.println("2. Approve Suggestions");
            System.out.println("3. View Approved Suggestions");
            //Possible Delete Suggestion Mechanism to be Implemented if they have approved and proceeded with the suggestion.
            System.out.println("4. Exit");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1: 
                    suggestionManager.viewSuggestions();
                    break;

                case 2: 
                    System.out.println("Which camp's suggestions would you like to look at? (1 - " + staff.getCreatedCamps().size() + ")");
                    viewer.viewYourCamps();
                    campChoice = sc.nextInt();
                    System.out.println("Which suggestion would you like to approve? (1 - " + staff.getCreatedCamps().get(campChoice - 1).getSuggestions().size() + ")");
                    suggestionChoice = sc.nextInt();
                    suggestionManager.approveSuggestion(staff.getCreatedCamps().get(campChoice - 1).getSuggestions().get(suggestionChoice - 1));
                    break;

                case 3:
                    suggestionManager.viewApprovedSuggestions();
                    break;

                default:
                    System.out.println("Please select an appropriate option next time.");
            }
        } while(choice >= 1 && choice <= 3);
    }

    public void reportGeneration() {
        Scanner sc = new Scanner(System.in);
        StaffCampViewer viewer = new StaffCampViewer(staff); // Assuming 'staff' is the current Staff object
        ReportGenerator reportGenerator = new ReportGenerator(); // Assuming this is how you instantiate ReportGenerator
        int choice = 3;
        do {
            System.out.println("Select the report you want to generate:");
            System.out.println("1. Generate Camp Report");
            System.out.println("2. Generate Performance Report for Committee Member");
            System.out.println("3. Exit");
            choice = sc.nextInt();
    
            switch (choice) {
                case 1:
                    // Display the list of camps
                    System.out.println("Select a camp to generate its report:");
                    viewer.viewYourCamps();
                    ArrayList<Camp> createdCamps = staff.getCreatedCamps();

                    // Check if there are any created camps
                    if (createdCamps.isEmpty()) {
                        System.out.println("No camps have been created.");
                        break;
                    }
        
                    // Taking user input for camp selection
                    int campIndex = sc.nextInt();
                    // Adjusting campIndex to match array indexing (if necessary)
                    
                    // Check if the campIndex is valid
                    if (campIndex < 1 || campIndex > createdCamps.size()) {
                        System.out.println("Invalid camp selection.");
                        break;
                    }
        
                    // Retrieving the selected camp
                    Camp selectedCamp = createdCamps.get(campIndex - 1);

                    // Generate the camp report
                    reportGenerator.generateCampReport(selectedCamp);
                    break;

                case 2:
                    List<CampCommitteeMember> committeeMembers = Camp.getAllCommitteeMembers();
                        // Check if there are any committee members
                    if (committeeMembers.isEmpty()) {
                        System.out.println("There are no committee members.");
                        break;
                    }                    
                    // Display the list of committee members
                    for (int i = 0; i < committeeMembers.size(); i++) {
                        System.out.println((i + 1) + ". " + committeeMembers.get(i).getName());
                    }
        
                    // Taking user input for committee member selection
                    System.out.println("Select a committee member to generate a report:");
                    int memberIndex = sc.nextInt();
                        
                        // Validate the input
                    if (memberIndex < 1 || memberIndex > committeeMembers.size()) {
                        System.out.println("Invalid selection.");
                        break;
                    }
                        // Retrieve the selected member
                    CampCommitteeMember selectedMember = committeeMembers.get(memberIndex - 1);
        
                        // Generate the performance report
                    reportGenerator.generatePerformanceReport(selectedMember);
                    break;

                case 3:
                    System.out.println("Exiting report generation module.");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (choice >= 1 && choice <= 2);
    }
}
