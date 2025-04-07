package edu.cit.AssessMate.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "reviewees")
public class Reviewee {
    @Id
    @Column(name = "reviewee_id", length = 15)
    private String revieweeID;

    @Column(name = "reviewee_first_name", length = 50)
    private String revieweeFirstName;

    @Column(name = "reviewee_last_name", length = 50)
    private String revieweeLastName;

    @Column(length = 50)
    private String email;

    @OneToMany(mappedBy = "reviewee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<QuizAttempt> quizAttempts;

    @OneToMany(mappedBy = "reviewee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollments;

    // Constructors
    public Reviewee() {
    }

    public Reviewee(String revieweeID, String revieweeFirstName, String revieweeLastName, String email) {
        this.revieweeID = revieweeID;
        this.revieweeFirstName = revieweeFirstName;
        this.revieweeLastName = revieweeLastName;
        this.email = email;
    }

    // Getters and setters
    public String getRevieweeID() {
        return revieweeID;
    }

    public void setRevieweeID(String revieweeID) {
        this.revieweeID = revieweeID;
    }

    public String getRevieweeFirstName() {
        return revieweeFirstName;
    }

    public void setRevieweeFirstName(String revieweeFirstName) {
        this.revieweeFirstName = revieweeFirstName;
    }

    public String getRevieweeLastName() {
        return revieweeLastName;
    }

    public void setRevieweeLastName(String revieweeLastName) {
        this.revieweeLastName = revieweeLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<QuizAttempt> getQuizAttempts() {
        return quizAttempts;
    }

    public void setQuizAttempts(List<QuizAttempt> quizAttempts) {
        this.quizAttempts = quizAttempts;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
