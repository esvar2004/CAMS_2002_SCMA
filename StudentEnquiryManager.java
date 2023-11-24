import java.util.ArrayList;
import java.util.List;

public class StudentEnquiryManager implements EnquiryManager {
    private Student student;

    public StudentEnquiryManager(Student student) {
        this.student = student;
    }

    public void viewEnquiries()
    {
        for(Camp camp: student.getRegisteredCamps())
        {
            for(Enquiry e: camp.getEnquiries())
            {
                System.out.println("Question: " + e.getQuestion());
                System.out.println("Response: " + e.getResponse());
                System.out.println("Student: " + e.getPostedBy().getName() + "/n");
            }
        }
    }

    public void submitEnquiry(Camp camp, String question)
    {
        Enquiry e = new Enquiry(question, student, camp);
    	student.getEnquiries().add(e);
        camp.getEnquiries().add(e);
    }

    public void editEnquiry(Enquiry enquiry, String question)
    {
        enquiry.setQuestion(question);
    }

    public void deleteEnquiry(Enquiry enquiry)
    {
        student.getEnquiries().remove(enquiry);
    }
}
