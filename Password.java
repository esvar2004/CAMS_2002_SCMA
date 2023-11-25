import java.util.Scanner;

public class Password {
    static Scanner sc = new Scanner(System.in);
    public static boolean inputPassword(){

        System.out.println("Input Password: ");

        for (int i = 0; i < 3; i++){

            char[] passwordChars = System.console().readPassword(); // Masked input
            // Convert char array to a string
            String password = new String(passwordChars);
            if (password.equals("password")) {
                return true;
            }
            System.out.println("Wrong Password!");
        }
        System.out.println("You have entered an incorrect password 3 times.");
        return false;
    }
    public static boolean checkDefaultPassword(User user) {

        return user.getPassword().equals("password");
    }

    public static void changePassword(User user) {

        System.out.println("Please enter your new password:");

        String newPassword = sc.nextLine();

        // If new password meets the criteria
        if (isValidPassword(newPassword)) {
            user.setPassword(newPassword);
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Password does not meet criteria.");
        }
    }
   
    private static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            System.out.println("Password must have at least one uppercase letter.");
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            System.out.println("Password must have at least one lowercase letter.");
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            System.out.println("Password must have at least one number.");
            return false;
        }
        
        if (!password.matches(".*[!@#$%^&*()].*")) { 
            System.out.println("Password must have at least one special character.");
            return false;
        }
    
        return true;
    }
}
