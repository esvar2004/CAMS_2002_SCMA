import java.util.Scanner;

public class Main extends Login{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        createAllData(); //Uses the function in Initialize.java to invoke everything within the function
        boolean systemRunning = true;

        while(systemRunning)
        {
            login();
            while (!Password.inputPassword()){
                login();
            }

            if(getType() == "student")
            {
                Student student = (Student) LoginSuccess();
                StudentControllerSwitch control = new StudentControllerSwitch(student);
                control.main();
            }
            else if(getType() == "staff")
            {
                Staff staff = (Staff) LoginSuccess();
                StaffControllerSwitch control = new StaffControllerSwitch(staff);
                control.main();
            }
            else
            {
                CampCommitteeMember commMember = (CampCommitteeMember) LoginSuccess();
                CampCommControllerSwitch control = new CampCommControllerSwitch(commMember);
                control.main();
            }
            
            System.out.println("Do you want the system to continue running? (Y/N)");
            char choice = sc.next().charAt(0);
            if(choice == 'N')
                systemRunning = false;
        }
    }
}