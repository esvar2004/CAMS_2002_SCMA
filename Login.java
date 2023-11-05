import java.util.Scanner;

public class Login extends Initialize{
    static Scanner sc = new Scanner(System.in);
    static String username = "";

    public static String login(){
        System.out.println("Input Username: ");
        while (true){
            username = sc.next();
            if (contains_special(username)){
                System.out.println("Please Input a valid username!");
            }else{
                if (searchStudent(username)) {
                    return "student " + username;
                }
                else if (searchStaff(username)){
                    return "staff " + username;
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
            if (password.equals(getPasswordOfUser())) {
                LoginSuccess();
                return true;
            }
            System.out.println("Wrong Password!");
        }
        System.out.println("You have entered an incorrect password 3 times. Begone");
        return false;
        
    }
    private static void LoginSuccess(){
        String[] user = getUserDetails();
        if(user[4].equals("n")){
            // For now, need to change it later...

            for (String[] list : studentDetails){
                if (list[1].equalsIgnoreCase(user[1])) {
                    list[4] = "y";
                    Student student = new Student(user[1], user[2]);
                    System.out.println(user[0] + " has logged in");
                }
            }
            for (String[] list : staffDetails){
                if (list[1].equalsIgnoreCase(username)) {
                    list[4] = "y";
                    Staff staff = new Staff(user[0], user[1]+"NTU.EDU.SG", user[2]);
                    System.out.println(user[0] + "has logged in!");
                }
            }
        }
    }

    public static boolean contains_special(String s){
        for (int i = 0; i < s.length(); i++){

            if (!(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))){
                return true;
            }
        }
        return false;
    }

    public static String[] getUserDetails(){
        for (String[] list : studentDetails){
            if (list[1].equalsIgnoreCase(username)) return list;
        }
        for (String[] list : staffDetails){
            if (list[1].equalsIgnoreCase(username)) return list;
        }
        System.out.println("Something wrong here... getUserDetails");
        return new String[]{};
    }

    public static String getPasswordOfUser(){
        
        return getUserDetails()[3];
    }

    public static boolean searchStudent(String s) {
        for (String[] list : studentDetails){
            if (list[1].equalsIgnoreCase(s)) return true;
        }
        return false;
    }

    public static boolean searchStaff(String s) {
        for (String[] list : staffDetails){
                if (list[1].equalsIgnoreCase(s)) return true;
            }
            return false;
    }

}

