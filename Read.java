import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {
    public static void main(String[] args) {

    }

    public static boolean search(String s) {
      try (BufferedReader reader1 = new BufferedReader(new FileReader("staff.txt"));
           BufferedReader reader2 = new BufferedReader(new FileReader("student.txt"))) {
  
          String line;
          reader1.readLine(); // Skip the first line
          while ((line = reader1.readLine()) != null) {
              if (s.equalsIgnoreCase(getusername(line).trim())) {
                  return true;
              }
          }
  
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

    public static String getusername(String s) {
      String[] parts = s.split("\t");
      String email = parts[1];
      int index = email.indexOf('@');
      email = email.substring(0,index);
      return email; 
  }
}
