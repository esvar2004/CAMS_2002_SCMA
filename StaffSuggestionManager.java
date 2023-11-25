public class StaffSuggestionManager implements SuggestionManager {
    private Staff staff;

    public StaffSuggestionManager(Staff staff) {
        this.staff = staff;
    }

    public void viewSuggestions()
    {
        for(Camp camp: staff.getCreatedCamps())
        {
            for(Suggestion s: camp.getSuggestions())
            {
                System.out.println("Suggestion: " + s.getSuggestion());
                System.out.println("Camp Committee Member: " + s.getPostedBy().getName() + "/n");
            }
        }
    }

    public void viewSuggestions(Camp camp)
    {
        for(Suggestion s: camp.getSuggestions())
        {
            System.out.println("\nSuggestion: " + s.getSuggestion());
            System.out.println("Camp Committee Member: " + s.getPostedBy().getName() + "/n");
        }
    }

    public void approveSuggestion(Suggestion s)
    {
        s.setApproval(1);
        staff.getApprovedSuggestions().add(s);
    }

    public void viewApprovedSuggestions()
    {
        for(Suggestion s: staff.getApprovedSuggestions())
        {
            System.out.println("Suggestion: " + s.getSuggestion());
            System.out.println("Camp Committee Member: " + s.getPostedBy().getName() + "/n");
        }
    }
}