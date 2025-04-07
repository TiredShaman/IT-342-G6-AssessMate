package edu.cit.AssessMate.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @Column(name = "answer_id", length = 15)
    private String answerID;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_attempt_id", referencedColumnName = "quiz_attempt_id")
    private QuizAttempt quizAttempt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id")
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "choice_id", referencedColumnName = "choice_id")
    private Choice choice;

    // Constructors
    public Answer() {
    }

    public Answer(String answerID, LocalDateTime submittedAt, QuizAttempt quizAttempt,
                Quiz quiz, Question question, Choice choice) {
        this.answerID = answerID;
        this.submittedAt = submittedAt;
        this.quizAttempt = quizAttempt;
        this.quiz = quiz;
        this.question = question;
        this.choice = choice;
    }

    // Getters and setters
    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public QuizAttempt getQuizAttempt() {
        return quizAttempt;
    }

    public void setQuizAttempt(QuizAttempt quizAttempt) {
        // Remove from old quiz attempt's answers list
        if (this.quizAttempt != null) {
            this.quizAttempt.getAnswers().remove(this);
        }
        
        // Set new quiz attempt and add to its answers list
        this.quizAttempt = quizAttempt;
        if (quizAttempt != null && !quizAttempt.getAnswers().contains(this)) {
            quizAttempt.getAnswers().add(this);
        }
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        // Clear previous question's answer reference if changing question
        if (this.question != null) {
            this.question.setAnswer(null);
        }
        
        // Set new question and its answer reference
        this.question = question;
        if (question != null) {
            question.setAnswer(this);
        }
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        // Clear previous choice's answer reference if changing choice
        if (this.choice != null) {
            this.choice.setAnswer(null);
        }
        
        // Set new choice and its answer reference
        this.choice = choice;
        if (choice != null) {
            choice.setAnswer(this);
        }
    }

    // Utility methods
    public boolean isCorrect() {
        return choice != null && choice.isCorrect();
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerID='" + answerID + '\'' +
                ", submittedAt=" + submittedAt +
                ", questionID=" + (question != null ? question.getQuestionID() : "null") +
                ", choiceID=" + (choice != null ? choice.getChoiceID() : "null") +
                '}';
    }
}