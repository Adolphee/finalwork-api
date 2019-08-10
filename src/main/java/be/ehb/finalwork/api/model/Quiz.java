package be.ehb.finalwork.api.model;

import java.util.List;

public class Quiz {
    private List<Question> questions;

    public List<Question> getQuestions() { return questions; }
    public void setQuestions(List<Question> value) { this.questions = value; }
}