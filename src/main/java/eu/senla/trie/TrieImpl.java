package eu.senla.trie;

import eu.senla.trie.api.Trie;

import java.util.Locale;
import java.util.Optional;

public class TrieImpl implements Trie {

    private final TrieNode root;

    public TrieImpl() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char symbol : word.toLowerCase(Locale.ROOT).toCharArray()) {
            current = current.getChildren().computeIfAbsent(symbol, c -> new TrieNode());
        }

        current.setEndOfWord(true);
    }

    public Optional<TrieNode> find(String word) {
        TrieNode current = root;
        String wordLowerCase = word.toLowerCase(Locale.ROOT);

        for (int i = 0; i < wordLowerCase.length(); i++) {
            char ch = wordLowerCase.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return Optional.empty();
            }
            current = node;
        }

        return Optional.of(current).filter(TrieNode::isEndOfWord);
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        String wordInLowerCase = word.toLowerCase(Locale.ROOT);

        if (index == wordInLowerCase.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }

        char ch = wordInLowerCase.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, wordInLowerCase, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

}