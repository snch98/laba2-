package com.example.laba2;

public class Counter {

    public int countWords(String text) {
        String[] words = text.split("[\\s,\\.]");
        return words.length;
    }

    public int countCharacters(String text) {
        return text.length();
    }
}
