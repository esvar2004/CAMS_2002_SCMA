//package a2002Assignment;

public class Enquiry {
    private String question;
    private String response; // This field holds the reply from the committee member/staff member.
    private Student postedBy; // Assuming 'Student' is a class representing students.
    private String campName;

    public Enquiry(String question, Student postedBy, String campName) {
        this.question = question;
        this.postedBy = postedBy;
        this.campName = campName;
        this.response = ""; // Initially, there's no response until a committee member replies.
    }

    // Getter and setter methods
    public String getCampName()
    {
        return campName;
    }

    public String getQuestion() {
        return question;
    }

    public String getResponse() {
        return response;
    }

    public Student getPostedBy() {
        return postedBy;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
