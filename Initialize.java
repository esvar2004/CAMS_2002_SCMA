import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Initialize {
    static Scanner sc = new Scanner(System.in);
    static String username = "";
    protected static ArrayList<String []> studentDetails = new ArrayList<String[]>(); // Name Username Faculty Password visited
    protected static ArrayList<String[]> staffDetails = new ArrayList<String[]>();
    

    public Initialize() {
        InitializeData("student.txt", studentDetails);
        InitializeData("staff.txt", staffDetails);
        System.out.println("Data Arrays Initialized!");
    }

public static void InitializeData(String file, final ArrayList<String[]> arrayDetails) {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
    
          String line;
  
          reader.readLine(); // Skip the first line
          while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length == 3) {
                arrayDetails.add(new String[]{parts[0], getusername(parts[1]), parts[2], "password", "n"});
            }
        }
      } catch (IOException e) {
          e.printStackTrace();
      }
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

    System.out.println("Something wrong here getUsername...");
    return ""; // Return an empty string 
}

}

