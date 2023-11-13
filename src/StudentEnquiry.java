//package a2002Assignment;

import java.util.ArrayList;
import java.util.List;

public class StudentEnquiry {
    private Student student;
    private List<Enquiry> enquiries;

    public StudentEnquiry(Student student) {
        this.student = student;
        this.enquiries = new ArrayList<>();
    }

    public void submitEnquiry(Camp camp, String enquiryText) {
        Enquiry newEnquiry = new Enquiry(enquiryText, this.student, camp.getName());
        camp.addEnquiry(newEnquiry); // Assuming Camp has a method to add enquiries
        this.enquiries.add(newEnquiry);
    }

    public void editEnquiry(Enquiry enquiry, String newEnquiryText) {
        if (this.enquiries.contains(enquiry)) {
            enquiry.setQuestion(newEnquiryText);
        }
    }

    public void deleteEnquiry(Enquiry enquiry) {
        if (this.enquiries.contains(enquiry)) {
            this.enquiries.remove(enquiry);
            // Assuming Camp has a method to remove enquiries
            enquiry.getCamp().removeEnquiry(enquiry);
        }
    }

    public void viewEnquiries() {
        for (Enquiry enquiry : this.enquiries) {
            System.out.println("Enquiry for Camp: " + enquiry.getCampName());
            System.out.println("Question: " + enquiry.getQuestion());
            System.out.println("Response: " + enquiry.getResponse());
        }
    }
}
