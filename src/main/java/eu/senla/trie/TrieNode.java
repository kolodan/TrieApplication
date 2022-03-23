package eu.senla.trie;

import java.util.HashMap;

public class TrieNode {

    private final HashMap<Character, TrieNode> children = new HashMap<>();

    private boolean endOfWord;

    private int count = 0;

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
        count++;
    }

    public int getCount() {
        return count;
    }

}
