package eu.senla.trie.api;

import eu.senla.trie.TrieNode;

import java.util.Optional;

public interface Trie {

    void insert(String word);

    Optional<TrieNode> find(String word);

    boolean delete(String word);

}
