//package a2002Assignment;

public class Enquiry {
    private String question;
    private String response; // This field holds the reply from the committee member.
    private Student postedBy; // Assuming 'Student' is a class representing students.

    public Enquiry(String question, Student postedBy) {
        this.question = question;
        this.postedBy = postedBy;
        this.response = ""; // Initially, there's no response until a committee member replies.
    }

    // Getter and setter methods
    public String getQuestion() {
        return question;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public Student getPostedBy() {
        return postedBy;
    }
}