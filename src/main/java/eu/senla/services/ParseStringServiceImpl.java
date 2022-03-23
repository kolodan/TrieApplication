package eu.senla.services;

import eu.senla.services.api.ParseStringService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseStringServiceImpl implements ParseStringService {

    @Override
    public List<String> divideStringToWords(String str) {
        String stringWithoutSymbols = removeNonLetters(str);

        return Stream.of(stringWithoutSymbols.split(" "))
                .collect(Collectors.toList());
    }

    private String removeNonLetters(String str) {
        return str
                .replaceAll("[^A-Za-zА-Яа-я-\n]", " ")
                .replaceAll("-\n", "")
                .replaceAll("\n", " ")
                .trim()
                .replaceAll(" +", " ");
    }

}
