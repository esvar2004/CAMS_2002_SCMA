import java.util.Scanner;

public class Main extends Login{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        createAllData(); //Uses the function in Initialize.java to invoke everything within the function
        boolean systemRunning = true;

        while(systemRunning)
        {
            if (!StudentController.justMadeComm){
                login();
                while (!Password.inputPassword()){
                    login();
                }
            }else{
                System.out.println("You have been promoted to a Camp Committee Member!");
                StudentController.justMadeComm = false;
            }

            if(getType() == "student")
            {     
                Student student = (Student) LoginSuccess();
                if (!student.getCommMember()){
                    StudentControllerSwitch control = new StudentControllerSwitch(student);
                    System.out.println("Welcome "+ student.getName()+ "!");
                    control.main();
                }else{
                    CampCommitteeMember commMember = new CampCommitteeMember(student.getName(), student.getEmail(),
                        student.getFaculty(), student.getCampCommMemberOf(), student.getRegisteredCamps(), student.getEnquiries(), student.getSuggestions(), student.pointsManager);
                    CampCommControllerSwitch control = new CampCommControllerSwitch(commMember);
                    System.out.println("Welcome "+ commMember.getName() + "!");
                    control.main();
                }
                
            }
            else if(getType() == "staff")
            {
                Staff staff = (Staff) LoginSuccess();
                StaffControllerSwitch control = new StaffControllerSwitch(staff);
                System.out.println("Welcome "+ staff.getName()+ "!");
                control.main();
            }
            if (!StudentController.justMadeComm){
                System.out.println("Do you want the system to continue running? (Y/N)");
                char choice = sc.next().toUpperCase().charAt(0);
                if(choice == 'N')
                    systemRunning = false;
            }
            
        }
    }
}