import java.util.*;
public class StudentControllerSwitch
{
    private Student student;
    public StudentControllerSwitch(Student student)
    {
        this.student = student;
    }

    public void main()
    {
        Scanner sc = new Scanner(System.in);
        StudentController control = new StudentController(student);
        int choice = 5; //Initializing Choice to Exit to Enter the do-while loop
        do{
            System.out.println("Select from the given list of options.");
            System.out.println("1. View Camps");
            System.out.println("2. Submit Enquiries");
            System.out.println("3. View Profile");
            System.out.println("4. Register for Camps");
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
                control.viewProfile();
                break;

                case 4:
                control.manageRegistration();
                break;
                
                default:
                System.out.println("You have exited the student interface.");
            }
        } while(choice >= 1 && choice <= 4);
    }
}

