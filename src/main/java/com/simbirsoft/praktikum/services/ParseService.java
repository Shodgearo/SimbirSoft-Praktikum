package com.simbirsoft.praktikum.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParseService {
    private Document doc;
    private Set<String> words;

    public ParseService (String url) {
        doc = null;
        words = new HashSet<>();

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        analyse();
    }

    private void analyse() {
        words = new HashSet<>(List.of(doc.body().text().split("[\\p{Z}\\p{P}\\p{C}\\p{S}]")));
    }

    public Set<String> getWords() {
        return words;
    }

    public Document getDoc() {
        return doc;
    }
}
