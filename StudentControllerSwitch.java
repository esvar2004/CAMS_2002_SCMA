import java.util.*;
public class StudentControllerSwitch extends StudentController
{
    public StudentControllerSwitch(Student student)
    {
        super(student);
    }

    public void main()
    {
        Scanner sc = new Scanner(System.in);
        int choice = 5; //Initializing Choice to Exit to Enter the do-while loop
        do{
            System.out.println("Select from the given list of options.");
            System.out.println("1. View Camps");
            System.out.println("2. Manage Enquiries");
            System.out.println("3. View Profile");
            System.out.println("4. Manage Registration");
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
                viewProfile();
                break;

                case 4:
                manageRegistration();
                break;
                
                default:
                System.out.println("You have exited the student interface.");
            }
        } while(choice >= 1 && choice <= 4);
    }
}

