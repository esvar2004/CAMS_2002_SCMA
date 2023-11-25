import java.util.*;
public class StudentController 
{
    private Student student;

    public StudentController(Student student)
    {
        this.student = student;
    }

    public void viewCamps()
    {
        Scanner sc = new Scanner(System.in);
        StudentCampViewer viewer = new StudentCampViewer(student);
        int campChoice = 0;
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("Select from the given list of options.");
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
                    if (viewer.viewAvailableCamps(student.getFaculty()).size() == 0) {
                        System.out.println("There are no camps you can view!");
                        break;
                    }else if(viewer.viewAvailableCamps(student.getFaculty()).size() == 1){
                        System.out.println("You can only view one camp:");
                        Time.pause(1);
                        viewer.viewCampDetails(viewer.viewAvailableCamps(student.getFaculty()).get(0));
                        break;
                    }
                    System.out.println("Which camp's details would you like to view? (1 - " + viewer.viewAvailableCamps(student.getFaculty()).size() + ")");
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
                    viewer.viewCampDetails(viewer.viewAvailableCamps(student.getFaculty()).get(campChoice - 1));
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
        StudentCampViewer viewer = new StudentCampViewer(student);
        StudentEnquiryManager enquiryManager = new StudentEnquiryManager(student);
        int campChoice = 0;
        int enquiryChoice = 0;
        String question = "";
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("Select from the given list of options.");
            System.out.println("1. View Enquiries");
            System.out.println("2. Submit Enquiries");
            System.out.println("3. Edit Enquiries");
            System.out.println("4. Delete Enquiries");
            System.out.println("5. Exit");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1: 
                    enquiryManager.viewEnquiries();
                    break;

                case 2: 
                    System.out.println("To which camp would you like to submit an enquiry? (1 - " + viewer.viewAvailableCamps(student.getFaculty()).size() + ")");
                    viewer.viewYourCamps();
                    campChoice = sc.nextInt();
                    System.out.println("What is your question?");
                    question = sc.nextLine();
                    enquiryManager.submitEnquiry(viewer.viewAvailableCamps(student.getFaculty()).get(campChoice), question);
                    break;

                case 3: 
                    System.out.println("Which of your enquiries would you like to edit? (1 - " + student.getEnquiries().size() + ")");
                    enquiryManager.viewEnquiries();
                    enquiryChoice = sc.nextInt();
                    System.out.println("What is your updated question?");
                    question = sc.nextLine();
                    enquiryManager.editEnquiry(student.getEnquiries().get(enquiryChoice), question);
                    break;

                case 4:
                    System.out.println("Which of your enquiries would you like to delete?");
                    enquiryManager.viewEnquiries();
                    enquiryChoice = sc.nextInt();
                    enquiryManager.deleteEnquiry(student.getEnquiries().get(enquiryChoice));
                    break;

                default:
                    System.out.println("Please select an appropriate option next time.");
            }
        } while(choice >= 1 && choice <= 4);
    }

    public void viewProfile()
    {
        System.out.println("Profile:");
		System.out.println("Name: " + student.getName());
		System.out.println("Faculty: " + student.getFaculty());
		System.out.println("Registered Camps: " + student.getRegisteredCamps());
		System.out.println("End of Profile");
    }

    public void manageRegistration()
    {
        Scanner sc = new Scanner(System.in);
        StudentCampViewer viewer = new StudentCampViewer(student);
        CampRegistrationManager registrationManager = new CampRegistrationManager(student);
        int campChoice = 0;
        int roleChoice = 0;
        String role = "";
        int choice = 4; //Initializing Choice to Exit to Enter the do-while loop
        do
        {
            System.out.println("Select from the given list of options.");
            System.out.println("1. View Registered Camps");
            System.out.println("2. Register for Camp");
            System.out.println("3. Withdraw from Camp");
            System.out.println("4. Exit");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1: 
                    registrationManager.viewRegisteredCamps();
                    break;

                case 2:
                    System.out.println("Which camp would you like to register for? (1 - " + viewer.viewAvailableCamps(student.getFaculty()).size() + ")");
                    viewer.viewAllCamps();
                    campChoice = sc.nextInt();
                    System.out.println("What role do you want to register for?");
                    System.out.println("(1) Attendee");
                    System.out.println("(2) Committee Member");
                    if(sc.nextInt() == 1) role = "Attendee";
                    else if(sc.nextInt() == 2) role = "committee";
                    registrationManager.registerForCamp(viewer.viewAvailableCamps(student.getFaculty()).get(campChoice - 1), this.student, role);
                    break;

                case 3:
                    System.out.println("Which camp would you like to Withdraw from? (1 - " + student.getRegisteredCamps().size() + ")");
                    viewer.viewYourCamps();
                    campChoice = sc.nextInt();
                    registrationManager.withdrawFromCamp(student.getRegisteredCamps().get(campChoice - 1), this.student);
                    break;

                default:
                    System.out.println("Please select an appropriate option next time.");
            }

        } while(choice >= 1 && choice <= 3);
    }
}

