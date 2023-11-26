
public class CampCommEnquiryManager implements EnquiryManager {
    private CampCommitteeMember commMember;

    public CampCommEnquiryManager(CampCommitteeMember commMember) {
        this.commMember = commMember;
    }

    public void viewEnquiries()
    {
        if (commMember.getCamp().getEnquiries().size() == 0){
            System.out.println("No enquiries!");
            return;
        }
        for(Enquiry e: commMember.getCamp().getEnquiries())
        {
            if(!e.getPostedBy().getName().equals(commMember.getName()))
            {
                System.out.println("\nQuestion: " + e.getQuestion());
                System.out.println("Response: " + e.getResponse());
                System.out.println("Student: " + e.getPostedBy().getName());
            }
        }
    }

    public void editEnquiry(Enquiry enquiry, String response)
    {
        enquiry.setResponse(response);
    }
}
