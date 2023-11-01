import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    static Scanner sc = new Scanner(System.in);
    static String username = "";

    public static String login(){
        while (!searchStudent(username) && !searchStaff(username)){
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
              if (s.equalsIgnoreCase(getusername(line).trim())) {
                  return true;
              }
          }
  
      } catch (IOException e) {
          e.printStackTrace();
      }
  
      return false;
 }

    public static String getusername(String s) {
      String[] parts = s.split("\t");
      String email = parts[1];
      int index = email.indexOf('@');
      String username = email.substring(0,index);
      return username; 
  }

}