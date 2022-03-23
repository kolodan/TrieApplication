package eu.senla.start;

import eu.senla.services.FileServiceImpl;
import eu.senla.services.ParseStringServiceImpl;
import eu.senla.services.TrieServiceImpl;
import eu.senla.services.api.FileService;
import eu.senla.services.api.ParseStringService;
import eu.senla.services.api.TrieService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {

        FileService fileService = new FileServiceImpl();
        ParseStringService parseStringService = new ParseStringServiceImpl();

        String path = args[0];

        String str = fileService.readFromFile(path);

        List<String> words = parseStringService.divideStringToWords(str);

        TrieService trieService = TrieServiceImpl.getInstance();

        trieService.addList(words);

        String testWord = "testWord";

        trieService.add(testWord);
        trieService.add(testWord);
        trieService.add(testWord);

        System.out.println(trieService.findCountWordEntries(testWord));

        System.out.println(trieService.find(testWord));

        System.out.println(trieService.delete(testWord));

        System.out.println(trieService.find(testWord));

    }

}
