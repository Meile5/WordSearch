package UI;

import Data.SearchHistory;
import Data.WordRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import logic.WordSearchLogic;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ListView allWords;
    private WordRepository wordRepository;
    private WordSearchLogic wordSearchLogic;

    private SearchHistory searchHistory;
    @FXML
    private Button wordSearch;
    @FXML
    private Button clearHistory;
    @FXML
    private TextField wordInput;
    @FXML
    private ListView wordsStartingWithA;
    @FXML
    private ListView wordsStartingWithN;
    @FXML
    private ListView searchHistoryView;
    @FXML
    private Label totalWordCount;
    @FXML
    private Label searchResult;

    public MainController(){
        this.wordRepository = new WordRepository();
        this.wordSearchLogic = new WordSearchLogic();
        this.searchHistory = new SearchHistory();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) { //runs whenever program finishes opening
        allWords.getItems().addAll(wordRepository.getList());
        totalWordCount.setText(String.valueOf(wordRepository.getList().size()));
        wordsStartingWithA.getItems().addAll(wordSearchLogic.getListA());
        wordsStartingWithN.getItems().addAll(wordSearchLogic.getListN());



    }


    public void wordSearchButton(ActionEvent actionEvent) {
        String input = wordInput.getText();
        searchResult.setText(wordSearchLogic.wordSearch(input));//word or nothing
        allWords.scrollTo(input);
        allWords.getSelectionModel().select(input);
        searchHistoryView.getItems().clear();
        searchHistoryView.getItems().addAll(wordSearchLogic.getHistory());






    }

    public void clearHistoryButton(ActionEvent actionEvent) {
    }


}
