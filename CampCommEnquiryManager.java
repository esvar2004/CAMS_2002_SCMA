import java.util.ArrayList;
import java.util.List;

public class CampCommEnquiryManager implements EnquiryManager {
    private CampCommitteeMember commMember;

    public CampCommEnquiryManager(CampCommitteeMember commMember) {
        this.commMember = commMember;
    }

    public void viewEnquiries()
    {
        for(Enquiry e: commMember.getCamp().getEnquiries())
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
