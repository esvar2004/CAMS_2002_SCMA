import java.util.Scanner;

public class Login extends Initialize{
    static Scanner sc = new Scanner(System.in);
    static String username = "";
    static String type;

    public static void login(){
        System.out.println("Input Username: ");
        while (true){
            username = sc.next();
            if (contains_special(username)){
                System.out.println("Please Input a valid username!");
            }else{
                if (Search.searchStudent(username) != null) {
                    type = "student";
                    return;
                }
                else if (Search.searchStaff(username) != null){
                    type = "staff";
                    return;
                }
                else{
                    System.out.println("User not found, please try again: ");
                }
            }
        }
    }

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
        System.out.println("You have entered an incorrect password 3 times. Begone");
        return false;
        
    }
    public static User LoginSuccess(){
        User user = null;
        if (type == "staff"){
            user= (Staff)Search.searchStaff(username);
        }else if (type == "student"){
            user = (Student)Search.searchStudent(username);
        }
        return user;
    }

    public static boolean contains_special(String s){
        for (int i = 0; i < s.length(); i++){

            if (!(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))){
                return true;
            }
        }
        return false;
    }

    public static String getType(){
        return type;
    }

    

}