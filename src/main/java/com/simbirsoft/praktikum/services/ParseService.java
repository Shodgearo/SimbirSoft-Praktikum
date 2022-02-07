package com.simbirsoft.praktikum.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;

public class ParseService {
    private Document doc;
    private Set<String> words;
    private Map<String, Integer> wordsMap;

    public ParseService (String url) {
        doc = null;
        words = new HashSet<>();
        wordsMap = new HashMap<>();

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        analyse();
    }

    private void analyse() {
        List<String> wordsList = List.of(doc.body().text().toUpperCase().split("[\\p{Z}\\p{P}\\p{C}\\p{S}]"));
        words = new HashSet<>(wordsList);

        for (String word: wordsList) {
            int count = 1;

            if (wordsMap.get(word) != null)
                count = wordsMap.get(word) + 1;

            wordsMap.put(word, count);
        }
    }

    public Set<String> getWords() {
        return words;
    }

    public Map<String, Integer> getWordsMap() {
        return wordsMap;
    }

    public Document getDoc() {
        return doc;
    }
}
