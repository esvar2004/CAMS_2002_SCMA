//package a2002Assignment;

import java.util.ArrayList;
import java.util.List;
import java.io.*; 

public class CampCommitteeMember extends Student {
    
    private List<String> suggestions;
    private int points; // Points for replying to enquiries and suggestions
    
    public CampCommitteeMember(String userId, String password, String faculty) {
        super(userId, password, faculty); // Assuming these are fields from the Student class
        this.suggestions = new ArrayList<>();
        this.points = 0;
    }

    // Allows a committee member to view details of the camp they registered for
    public void viewCampDetails(Camp camp) {
        // Implementation depends on how Camp's information is accessed
        // Assuming there are getter methods in Camp to retrieve details
        System.out.println("Camp Details:");
        System.out.println("Name: " + camp.getName());
        // other details here...
    }

    // Submit suggestions for changes to camp details
    public void submitSuggestion(String suggestion, Camp camp) {
        // Logic to submit suggestion
        // Maybe add to a list of suggestions for the camp to review
        this.suggestions.add(suggestion);
        this.points++; // Assuming they get a point for a suggestion

        // Notify staff or store suggestion for staff review
        // This may involve adding the suggestion to a list within the Camp object, for example
    }

    // Reply to enquiries from students
    public void replyToEnquiry(Enquiry enquiry, String response) {
        // Logic to post a reply to an enquiry
        // Assuming Enquiry is a class with its own fields like 'question', 'answer', 'postedBy', etc.
        enquiry.setResponse(response); // For example, if the Enquiry class has such a method.
        this.points++; // Assuming they get a point for a reply
    }

    // Generate a report for the camp
    public void generateReport(Camp camp) {
        // Logic depends on what's meant by "report" and how data is stored/structured
        // If it's a file, you might create a .txt or .csv file here
        // Below is a very simplified example of creating a text file.

        try {
            FileWriter writer = new FileWriter(camp.getName() + "_report.txt");
            
            // Write details to the file
            writer.write("Report for " + camp.getName() + "\n");
            // Add more camp details here...
            
            // Example: List all students
            for (Student student : camp.getList()) {
                writer.write(student.getUserID() + "\n"); // Assuming getUserId exists
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Additional methods for points, suggestions, etc. could be added

    // For example, to get the points
    public int getPoints() {
        return this.points;
    }

    // To fetch suggestions made by the committee member
    public List<String> getSuggestions() {
        return this.suggestions;
    }
}

