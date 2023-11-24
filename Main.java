import java.util.Scanner;

public class Main extends Login{
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        createAllData(); //Uses the function in Initialize.java to invoke everything within the function
        login();
        while (!Password.inputPassword()){
            login();
        }
        
        User user;
        // Lots of downcasting
        if (getType() == "student"){
            user = (Student) LoginSuccess();
        }else{
            user = (Staff) LoginSuccess();
        }

        // Can do whatever... best to call some sort of
        System.out.println("User " + user.getName() + "with UserID " + Getter.getusername(user) + " from " 
        + user.getFaculty() + " has logged in!");
    }
}