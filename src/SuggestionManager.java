
import java.util.ArrayList;
import java.util.List;

public class SuggestionManager {
    private List<String> suggestions;

    public SuggestionManager() {
        this.suggestions = new ArrayList<>();
    }

    public void addSuggestion(String suggestion) {
        this.suggestions.add(suggestion);
    }

    public List<String> getSuggestions() {
        return new ArrayList<>(this.suggestions); // Return a copy to prevent external modifications
    }
}
