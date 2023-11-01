import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String user = Login.login();

        // What to do about passwords 🥲
        
        if (user.charAt(2) == 'a'){
            // Staff stuff
        }else{
            // student stuff
        }
    }
}
