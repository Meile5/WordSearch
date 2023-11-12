package logic;

import Data.SearchHistory;
import Data.WordRepository;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class WordSearchLogic{
    private WordRepository wordRepository  =new WordRepository();
    private SearchHistory searchHistory = new SearchHistory();
    public String wordSearch (String input){
        for(String word : wordRepository.getList()){
           if(Objects.equals(word, input)){
               searchHistory.addHistory("Search for " + word + " and found results.");
               return word;
           }
        }
        searchHistory.addHistory("Search for " + input + " and found no results.");
        return " Word not found! ";
    }

    public ArrayList<String> getListA(){
        ArrayList<String> aList = new ArrayList<String>();
        for(String word : wordRepository.getList()){
            word = word.toLowerCase();
            if(word.startsWith("a")){
                aList.add(word);

            }
        }
        return aList;
    }

    public ArrayList<String> getListN(){
        ArrayList<String> nList = new ArrayList<String>();
        for(String word : wordRepository.getList()){
            word = word.toLowerCase();
            if(word.startsWith("n")){
                nList.add(word);
            }
        }
        return nList;
    }

    public ArrayList<String> getHistory() {
        return searchHistory.getHistory();
    }
    public void removeHistory(){
        searchHistory.removeHistory();
    }

}
