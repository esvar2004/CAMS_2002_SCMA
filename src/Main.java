import java.util.Scanner;

public class Main extends Login{
    // Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Initialize data = new Initialize();
        String user = Login.login();
        Login.inputPassword();

        
        if (user.charAt(2) == 'a'){
            
            // String[] list = Login.getList(username, true);
            // for (int i = 0; i < list.length; i++){
            //     System.out.println(list[i]);
            // }
            
            // Staff staff = new Staff(list[0], list[1], list[2]);
            // Code for "What commands do you wanna do?"
        }else{
            // student stuff
            String[] list = getUserDetails();
            Student student = new Student(list[0], list[2]);
            System.out.println(student.getFaculty());
        }
    }
}

/*
 *                 User
 *                  
 *            student   staff
 *           comm
 * 
 * 
 * 
 */