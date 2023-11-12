package Data;

import java.util.ArrayList;

public class SearchHistory {
    private ArrayList<String> history;

    public SearchHistory() {
        history = new ArrayList<String>();
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void addHistory(String item) {
        history.add(item);
    }

    public void removeHistory(){
        history.clear();
    }
}
