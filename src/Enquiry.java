

public class Enquiry {
    private String question;
    private String response; // This field holds the reply from the committee member/staff member.
    private Student postedBy; // Assuming 'Student' is a class representing students.
    private String campName;
    private Camp camp;

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

     // Getter and setter for question
     public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
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

    // If you need to get the Camp object directly, add this method
    public Camp getCamp() {
        return this.camp;
    }

    // Method to set the Camp object
    public void setCamp(Camp camp) {
        this.camp = camp;
        this.campName = camp.getName(); // Update campName if the Camp object is set
    }
}
