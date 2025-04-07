package com.assessmate.assessmate_backend.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "reviewee")
public class RevieweeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "revieweeID")
    private Long revieweeID;

    @Column(name = "reviewee_firstName")
    private String reviewee_firstName;

    @Column(name = "reviewee_lastName")
    private String reviewee_lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "reviewee", cascade = CascadeType.ALL)
    private List<EnrollmentEntity> enrollments;

    @OneToMany(mappedBy = "reviewee", cascade = CascadeType.ALL)
    private List<QuizAttemptEntity> quizAttempts;

    // Constructors
    public RevieweeEntity() {
    }

    public RevieweeEntity(String reviewee_firstName, String reviewee_lastName, String email) {
        this.reviewee_firstName = reviewee_firstName;
        this.reviewee_lastName = reviewee_lastName;
        this.email = email;
    }

    // Getters and Setters
    public Long getRevieweeID() {
        return revieweeID;
    }

    public void setRevieweeID(Long revieweeID) {
        this.revieweeID = revieweeID;
    }

    public String getReviewee_firstName() {
        return reviewee_firstName;
    }

    public void setReviewee_firstName(String reviewee_firstName) {
        this.reviewee_firstName = reviewee_firstName;
    }

    public String getReviewee_lastName() {
        return reviewee_lastName;
    }

    public void setReviewee_lastName(String reviewee_lastName) {
        this.reviewee_lastName = reviewee_lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EnrollmentEntity> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<EnrollmentEntity> enrollments) {
        this.enrollments = enrollments;
    }

    public List<QuizAttemptEntity> getQuizAttempts() {
        return quizAttempts;
    }

    public void setQuizAttempts(List<QuizAttemptEntity> quizAttempts) {
        this.quizAttempts = quizAttempts;
    }
}
