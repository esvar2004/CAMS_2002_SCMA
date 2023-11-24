import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Initialize {
    Scanner sc = new Scanner(System.in);
    static String username = "";
    protected static ArrayList<Student> studentDetails = new ArrayList<Student>(); // Name Username Faculty Password Visited
    protected static ArrayList<Staff> staffDetails = new ArrayList<Staff>();
    

    public static void createAllData() {
        InitializeStudentData("src/student.txt");
        InitializeStaffData("src/staff.txt");
        Camp.campList = new ArrayList<Camp>();
        System.out.println("Data Arrays Initialized!");
    }

    public static void InitializeStudentData(final String studentFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(studentFile))) {
        
            String line;

            reader.readLine(); // Skip the first line
            while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length == 3) {
                studentDetails.add(new Student(parts[0], parts[1], parts[2]));
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void InitializeStaffData(final String staffFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(staffFile))) {
        
            String line;

            reader.readLine(); // Skip the first line
            while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length == 3) {
                staffDetails.add(new Staff(parts[0], parts[1], parts[2]));
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

