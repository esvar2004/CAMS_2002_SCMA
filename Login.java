import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    static Scanner sc = new Scanner(System.in);
    static String username = "";

    public static String login(){

        while (!searchStaff(username) && !searchStudent(username)){
            username = "*";
            while (contains_special(username)){
                input_username();
            }
        }
        if (searchStudent(username)) return "student " + username;
        else{
            return "staff " + username;
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

    public static void input_username(){        

        while ((contains_special(username))){
            if (username != "*") System.out.println("Please input a valid username!");
            System.out.println("Input Your Username: ");
            username = sc.next();
        }
    }

    public static boolean searchStudent(String s) {
      try (BufferedReader reader2 = new BufferedReader(new FileReader("student.txt"))) {
  
          String line;
  
          reader2.readLine(); // Skip the first line
          while ((line = reader2.readLine()) != null) {
              if (s.equalsIgnoreCase(getusername(line).trim())) {
                  return true;
              }
          }
          return false;
  
      } catch (IOException e) {
          e.printStackTrace();
      }
  
      return false;
 }

public static boolean searchStaff(String s) {
    try (BufferedReader reader1 = new BufferedReader(new FileReader("staff.txt"))) {
  
        String line;
        reader1.readLine(); // Skip the first line
        while ((line = reader1.readLine()) != null) {
            if (s != "" && s.equalsIgnoreCase(getusername(line).trim())) {
                return true;
            }
        }
        return false;
  
    }   catch (IOException e) {
            e.printStackTrace();
        }
  
    return false;
}

public static String getusername(String s) {

    String[] parts = s.split("\t");
    if (parts.length == 3) {
        String email = parts[1];
        int index = email.indexOf('@');
        if (index != -1) {
            String username = email.substring(0, index);
            return username;
        }
    }else if (parts.length == 1){
        String email = s;
        int index = email.indexOf('@');
        if (index != -1) {
            String username = email.substring(0, index);
            return username;
        }
    }
    
    System.out.println("Can't get username from line " + parts[0]);
    return ""; // Return an empty string 
}

  public static String[] getList(String username, boolean staff) {
    String file;
    if (staff){
        file = "staff.txt";
    }else{
        file = "student.txt";
    }

    try  (BufferedReader reader = new BufferedReader(new FileReader(file))){
    {
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            // Split the line into components using tab as the delimiter
            String[] parts = line.split("\t");
            if (parts.length == 3) {
                String name = parts[0];
                String email = parts[1];
                String faculty = parts[2];

                // Compare the given email with the email in the file (case-insensitive)
                if (username.equalsIgnoreCase(getusername(email).trim())) {
                    return new String[]{name, email, faculty};
                }
            }
        }
    }
        
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}

}

