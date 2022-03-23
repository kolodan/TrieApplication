package eu.senla.services.api;

import java.util.List;

public interface TrieService {

    void add(String word);

    void addList(List<String> words);

    boolean find(String word);

    boolean delete(String word);

    int findCountWordEntries(String word);

}
