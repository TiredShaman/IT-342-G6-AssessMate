package edu.cit.AssessMate.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quiz_attempts")
public class QuizAttempt {
    @Id
    @Column(name = "quiz_attempt_id", length = 15)
    private String quizAttemptID;

    private Integer score;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id")
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewee_id", referencedColumnName = "reviewee_id")
    private Reviewee reviewee;

    @OneToMany(mappedBy = "quizAttempt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;

    // Constructors
    public QuizAttempt() {
    }

    public QuizAttempt(String quizAttemptID, Integer score, LocalDateTime startedAt, 
                      LocalDateTime submittedAt, Quiz quiz, Reviewee reviewee) {
        this.quizAttemptID = quizAttemptID;
        this.score = score;
        this.startedAt = startedAt;
        this.submittedAt = submittedAt;
        this.quiz = quiz;
        this.reviewee = reviewee;
    }

    // Getters and setters
    public String getQuizAttemptID() {
        return quizAttemptID;
    }

    public void setQuizAttemptID(String quizAttemptID) {
        this.quizAttemptID = quizAttemptID;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Reviewee getReviewee() {
        return reviewee;
    }

    public void setReviewee(Reviewee reviewee) {
        this.reviewee = reviewee;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
