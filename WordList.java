import java.util.ArrayList;
import java.util.Random;

public class WordList {

    ArrayList<String> wordList;
    String currentWord;

    public WordList()
    {
        wordList=new ArrayList<>();
        wordList.add("Katt");
        wordList.add("Hund");
        wordList.add("Elefant");
    }
    public String getRandomWord()
    {
        // Välj en slumpmässig siffra mellan 0 och wordList.Length
        Random randomNum = new Random();
        int randomIndex = randomNum.nextInt(wordList.size());
           
        // returnera ordet i det index som slumptalet visar
        currentWord = wordList.get(randomIndex);
        return currentWord;
    }

    public void AddWord(String word) { wordList.add((word)); }

    public void removeWord(String word) { wordList.remove(word);}

    public String getCurrentWord() { return currentWord; }


}