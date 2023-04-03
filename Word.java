public class Word {
    private String word;
    private String visibleWord;

    public Word(String word) {
        this.word = word;
        this.visibleWord = word.replaceAll(".", "-");
    }

    public String getWord() {
        return word;
    }

    public String getVisibleWord() {
        return visibleWord;
    }

    public boolean containsLetter(char letter) {
        return word.toLowerCase().contains(Character.toString(letter).toLowerCase());
    }

    public void updateVisibleWord(char letter) {
        StringBuilder newVisibleWord = new StringBuilder(visibleWord);
        String lowerCaseWord = word.toLowerCase();
        for (int i = 0; i < lowerCaseWord.length(); i++) {
            if (lowerCaseWord.charAt(i) == Character.toLowerCase(letter)) {
                newVisibleWord.setCharAt(i, word.charAt(i));
            }
        }
        visibleWord = newVisibleWord.toString();
    }

    public boolean hasGuessed() {
        return visibleWord.equalsIgnoreCase(word);
    }
}