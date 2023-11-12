package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordRepository {
    private ArrayList<String> words;


    public WordRepository() {
        this.words = new ArrayList<String>();
        loadWordsFromFile("brit-a-z.txt"); //
    }

    private void loadWordsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each word is on a new line in your file
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    public ArrayList<String> getList(){
        return words;

    }


    
}
