//package a2002Assignment;

import java.util.ArrayList;

public class StudentCampViewer {
    private Student student;
    private ArrayList<Camp> registeredCamps;

    public StudentCampViewer(Student student, ArrayList<Camp> registeredCamps) {
        this.student = student;
        this.registeredCamps = registeredCamps;
    }

    public void viewCampDetails(Camp camp) {
        System.out.println("Camp Details for: " + camp.getName());
        System.out.println("Open Date: " + camp.getOpenDate());
        System.out.println("Close Date: " + camp.getCloseDate());
        System.out.println("Description: " + camp.getDesc());
        // More details can be added as needed
    }

    public void viewAllCamps() {
        for (Camp camp : registeredCamps) {
            System.out.println("Camp Name: " + camp.getName());
            // Additional camp details can be displayed here
        }
    }
}
