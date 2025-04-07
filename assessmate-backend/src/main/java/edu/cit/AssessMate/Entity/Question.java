package edu.cit.AssessMate.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @Column(name = "question_id", length = 15)
    private String questionID;

    @Column(columnDefinition = "TEXT")
    private String questionText;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Choice> choices;

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Answer answer;

    // Constructors
    public Question() {
    }

    public Question(String questionID, String questionText, QuestionType questionType, Quiz quiz) {
        this.questionID = questionID;
        this.questionText = questionText;
        this.questionType = questionType;
        this.quiz = quiz;
    }

    // Getters and setters
    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        if (answer == null) {
            if (this.answer != null) {
                this.answer.setQuestion(null);
            }
        } else {
            answer.setQuestion(this);
        }
        this.answer = answer;
    }

    // Convenience methods for bidirectional relationships
    public void addChoice(Choice choice) {
        choices.add(choice);
        choice.setQuestion(this);
    }

    public void removeChoice(Choice choice) {
        choices.remove(choice);
        choice.setQuestion(null);
    }

    // Utility methods
    public boolean isMultipleChoice() {
        return questionType == QuestionType.MULTIPLE_CHOICE;
    }

    public boolean isTrueFalse() {
        return questionType == QuestionType.TRUE_FALSE;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID='" + questionID + '\'' +
                ", questionText='" + questionText + '\'' +
                ", questionType=" + questionType +
                '}';
    }
}