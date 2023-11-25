import java.util.*;
public class StudentControllerSwitch
{
    public static Scanner sc = new Scanner(System.in);
    private Student student;
    
    public StudentControllerSwitch(Student student)
    {
        this.student = student;
    }

    public void main()
    {
        StudentController control = new StudentController(student);
        int choice = 5; //Initializing Choice to Exit to Enter the do-while loop
        do{
            System.out.println("\nSelect from the given list of options.");
            System.out.println("1. View Camps");
            System.out.println("2. Submit Enquiries");
            System.out.println("3. View Profile");
            System.out.println("4. Register for Camps");
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
                control.viewProfile();
                break;

                case 4:
                control.manageRegistration();
                break;
                
                case 5:
                System.out.println("You have exited the Student Interface.");
                Time.pause(1);
                break;

                default:
                System.out.println("Please enter a valid input.");
            }
        } while(choice != 5);
    }
}

