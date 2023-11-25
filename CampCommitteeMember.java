import java.util.ArrayList;

public class CampCommitteeMember extends Student {
    private Camp camp;
    private ArrayList<Suggestion> suggestions;
    private PointsManager pointsManager;
    private ArrayList<Camp> registeredCamps;
    private ArrayList<Enquiry> enquiries;

    public CampCommitteeMember(String name, String email, String faculty, Camp camp) {
        super(name, email, faculty);
        this.pointsManager = new PointsManager();
        this.camp = camp;
        this.registeredCamps = super.getRegisteredCamps();
        this.enquiries = super.getEnquiries();
        
    }

    //Shouldn't this function be in Student?
    /*public void registerForCommitteePosition(Camp camp) {
        if (camp.getAvailableCommitteeSlots() > 0) {
            this.committeeCamps.add(camp);
            camp.addCommitteeMember(this);
        } else {
            System.out.println("No available committee slots in " + camp.getName());
        }
    }*/

    //I don't think this functionality exists.
    /*public void resignFromCommitteePosition(Camp camp) {
        if (this.committeeCamps.contains(camp)) {
            this.committeeCamps.remove(camp);
            camp.removeCommitteeMember(this);
        } else {
            System.out.println("You are not a member of the committee for " + camp.getName());
        }
    }*/

    // Assuming getUserID is inherited from Student
    public String getUserID() { 
        return Getter.getusername(super.getEmail());
    }

    public int getPoints() {
        return this.pointsManager.getPoints();
    }

    public ArrayList<Suggestion> getSuggestions()
    {
        return this.suggestions;
    }

    public Camp getCamp()
    {
        return this.camp;
    }
}
