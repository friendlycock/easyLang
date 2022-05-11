package com.company.database.entities;

public class Topic {
    private int id;
    private String context;
    private String subContext;
    private String grammar;
    private String keyVocab;
    private String text;
    private String spanishKeywords;

    public Topic(int id, String context, String subContext, String grammar, String keyVocab, String text, String spanishKeywords) {
        this.id = id;
        this.context = context;
        this.subContext = subContext;
        this.grammar = grammar;
        this.keyVocab = keyVocab;
        this.text = text;
        this.spanishKeywords = spanishKeywords;
    }

    public Topic() {

    }

    public int getId() {
        return id;
    }

    public String getContext() {
        return context;
    }

    public String getSubContext() {
        return subContext;
    }

    public String getGrammar() {
        return grammar;
    }

    public String getKeyVocab() {
        return keyVocab;
    }

    public String getText() {
        return text;
    }

    public String getSpanishKeywords() {
        return spanishKeywords;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setSubContext(String subContext) {
        this.subContext = subContext;
    }

    public void setGrammar(String grammar) {
        this.grammar = grammar;
    }

    public void setKeyVocab(String keyVocab) {
        this.keyVocab = keyVocab;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSpanishKeywords(String spanishKeywords) {
        this.spanishKeywords = spanishKeywords;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", subContext='" + subContext + '\'' +
                ", grammar='" + grammar + '\'' +
                ", keyVocab='" + keyVocab + '\'' +
                ", text='" + text + '\'' +
                ", spanishKeywords='" + spanishKeywords + '\'' +
                '}';
    }
}
