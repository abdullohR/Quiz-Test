package com.rasulovabdullokh.quizzapp.core;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionManager {

    private ArrayList<QuestionData> data;
    private int totalQuestion = 0;
    private int currentPosition = 0;
    private int totalTrues;
    private int totalFalse;

    public QuestionManager() {
    }

    public int getTotalTrues() {
        return totalTrues;
    }

    public int getTotalFalse() {
        return totalFalse;
    }

    public void setData(ArrayList<QuestionData> data) {
        this.data = data;
        Collections.shuffle(this.data);
        totalQuestion = data.size();
    }

    public QuestionManager(ArrayList<QuestionData> data) {
        this.data = data;
        Collections.shuffle(this.data);
        totalQuestion = data.size();
    }

    private QuestionData getCurrentQuestion() {
        return this.data.get(currentPosition);
    }

    public String getQuestion() {
        return getCurrentQuestion().getQuestion();
    }

    public String getVariantA() {
        return getCurrentQuestion().getAnswerA();
    }

    public String getVariantB() {
        return getCurrentQuestion().getAnswerB();
    }

    public String getVariantC() {
        return getCurrentQuestion().getAnswerC();
    }

    public boolean chekAnswer(String answer) {
        boolean isTrue = false;

        if (answer.equalsIgnoreCase(getCurrentQuestion().getAnswer())) {
            isTrue = true;
            totalTrues++;
        } else {
            isTrue = false;
            totalFalse++;
        }

        if (hasNextQuestion()) {
            currentPosition++;
        }

        return isTrue;
    }

    public boolean isFinish() {
        return currentPosition == totalQuestion;
    }

    public boolean hasNextQuestion() {
        return currentPosition < totalQuestion;
    }

    public int getCurrentLevel() {
        return currentPosition + 1;
    }

    public int getTotal() {
        return data.size();
    }

    public int setTrueS() {
        return totalTrues;
    }

    public int setFalseS() {
        return totalFalse;
    }
}
