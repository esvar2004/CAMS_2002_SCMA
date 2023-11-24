public class CampCommSuggestionManager implements SuggestionManager {
    private CampCommitteeMember commMember;

    public CampCommSuggestionManager(CampCommitteeMember commMember) {
        this.commMember = commMember;
    }

    public void viewSuggestions()
    {
        for(Camp camp: commMember.getRegisteredCamps())
        {
            for(Enquiry e: camp.getEnquiries())
            {
                System.out.println("Question: " + e.getQuestion());
                System.out.println("Response: " + e.getResponse());
                System.out.println("Student: " + e.getPostedBy() + "/n");
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
