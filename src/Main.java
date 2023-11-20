import java.util.Scanner;

public class Main extends Login{
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        createAllData();
        login();
        while (!Login.inputPassword()){
            login();
        }
        User user;
        // Lots of downcasting
        if (getType() == "student"){
            user = (Student)LoginSuccess();
        }else{
            user = (Staff)LoginSuccess();
        }

        // Can do whatever... best to call some sort of
        System.out.println("User " + user.getName() + " with UserID " + Getter.getusername(user) + " from " 
        + user.getFaculty() + " has logged in!");        
        
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