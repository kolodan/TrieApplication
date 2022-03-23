package eu.senla.services;

import eu.senla.services.api.TrieService;
import eu.senla.trie.TrieImpl;
import eu.senla.trie.TrieNode;
import eu.senla.trie.api.Trie;

import java.util.List;
import java.util.Optional;

public class TrieServiceImpl implements TrieService {

    private static TrieServiceImpl instance;

    private final Trie trie;

    public TrieServiceImpl() {
        trie = new TrieImpl();
    }

    public static TrieServiceImpl getInstance() {
        if (instance == null) {
            instance = new TrieServiceImpl();
        }
        return instance;
    }

    @Override
    public void add(String word) {
        trie.insert(word);
    }

    @Override
    public void addList(List<String> words) {
        words.forEach(trie::insert);
    }

    @Override
    public boolean find(String word) {
        Optional<TrieNode> trieNode = trie.find(word);
        return trieNode.isPresent();
    }

    @Override
    public boolean delete(String word) {
        return trie.delete(word);
    }

    @Override
    public int findCountWordEntries(String word) {
        Optional<TrieNode> trieNode = trie.find(word);

        if (trieNode.isEmpty()) {
            return 0;
        }

        return trieNode.get().getCount();
    }

}