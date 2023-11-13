
import java.util.ArrayList;
import java.util.List;

public class EnquiryManager {
    private List<Enquiry> campEnquiries;

    public EnquiryManager() {
        this.campEnquiries = new ArrayList<>();
    }

    public void viewCampEnquiries(Camp camp) {
        for (Enquiry enquiry : camp.getEnquiries()) { // Assuming Camp has a method getEnquiries
            System.out.println("Enquiry: " + enquiry.getQuestion());
        }
    }

    public void replyToEnquiry(Enquiry enquiry, String response) {
        if (campEnquiries.contains(enquiry)) {
            enquiry.setResponse(response);
        }
    }
}
