public class CampCommSuggestionManager implements SuggestionManager {
    private CampCommitteeMember commMember;

    public CampCommSuggestionManager(CampCommitteeMember commMember) {
        this.commMember = commMember;
    }

    public void submitSuggestion(String suggestion)
    {
        Suggestion s = new Suggestion(suggestion, commMember, commMember.getCamp());
        commMember.getSuggestions().add(s);
        commMember.getCamp().getSuggestions().add(s);
    }

    public void viewSuggestions()
    {
        for(Suggestion suggestion: commMember.getSuggestions())
        {
            System.out.println(suggestion.getSuggestion());
        }
    }

    public void editSuggestion(Suggestion suggestion, String s)
    {
        suggestion.setSuggestion(s);
    }
    
    public void deleteSuggestion(Suggestion suggestion)
    {
        commMember.getSuggestions().remove(suggestion);
    }
}
