package com.example.android.myquiz;

import java.util.List;


public class IntermediaryMethods {
    private String TopicofQuestion;
    private List<String> answers;
    private int rightAnswered;


    /*
    *
    * Method to set up the questions in java class 'QuestionList'
    *
    * @param TopicofQuestion, List<String> answers, correctAnswer
    *
     */
    public IntermediaryMethods(String TopicofQuestion, List<String> answers, int correctAnswer) {
        this.TopicofQuestion = TopicofQuestion;
        this.answers = answers;
        this.rightAnswered = correctAnswer;
    }

    public String getQuestionContent() {
        return TopicofQuestion;
    }

    public void setTopicofQuestion(String TopicofQuestion) {
        this.TopicofQuestion = TopicofQuestion;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void createAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return rightAnswered;
    }

    public void setRightAnswer(int rightAnswered) {
        this.rightAnswered = rightAnswered;
    }
}

