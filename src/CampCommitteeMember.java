import java.util.ArrayList;

public class CampCommitteeMember extends Student {
    private ArrayList<Camp> committeeCamps;
    private PointsManager pointsManager;

    public CampCommitteeMember(String userId, String faculty) {
        super(userId, faculty);
        this.committeeCamps = new ArrayList<>();
        this.pointsManager = new PointsManager();
        
    }

    public void registerForCommitteePosition(Camp camp) {
        if (camp.getAvailableCommitteeSlots() > 0) {
            this.committeeCamps.add(camp);
            camp.addCommitteeMember(this);
        } else {
            System.out.println("No available committee slots in " + camp.getName());
        }
    }

    public void resignFromCommitteePosition(Camp camp) {
        if (this.committeeCamps.contains(camp)) {
            this.committeeCamps.remove(camp);
            camp.removeCommitteeMember(this);
        } else {
            System.out.println("You are not a member of the committee for " + camp.getName());
        }
    }
    // Assuming getUserID is inherited from Student
    //public String getUserID() { return super.getUserID(); }

    public int getPoints() {
        return this.pointsManager.getPoints();
    }

    public ArrayList<Camp> getCommitteeCamps() {
        return this.committeeCamps;
    }
}
