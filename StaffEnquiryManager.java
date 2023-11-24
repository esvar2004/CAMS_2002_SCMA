import java.util.ArrayList;
import java.util.List;

public class StaffEnquiryManager implements EnquiryManager {
    private Staff staff;

    public StaffEnquiryManager(Staff staff) {
        this.staff = staff;
    }

    public void viewEnquiries()
    {
        for(Camp camp: staff.getCreatedCamps())
        {
            for(Enquiry e: camp.getEnquiries())
            {
                System.out.println("Question: " + e.getQuestion());
                System.out.println("Response: " + e.getResponse());
                System.out.println("Student: " + e.getPostedBy() + "/n");
            }
        }
    }

    public void viewEnquiries(Camp camp)
    {
        for(Enquiry e: camp.getEnquiries())
        {
            System.out.println("Question: " + e.getQuestion());
            System.out.println("Response: " + e.getResponse());
            System.out.println("Student: " + e.getPostedBy() + "/n");
        }
    }

    public void editEnquiry(Enquiry enquiry, String response)
    {
        enquiry.setResponse(response);
    }
}
