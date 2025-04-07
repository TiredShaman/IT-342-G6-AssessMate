package edu.cit.AssessMate.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @Column(name = "enrollment_id", length = 15)
    private String enrollmentID;

    @Column(name = "enrolled_at")
    private LocalDateTime enrolledAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Class classEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewee_id", referencedColumnName = "reviewee_id")
    private Reviewee reviewee;

    // Constructors
    public Enrollment() {
    }

    public Enrollment(String enrollmentID, LocalDateTime enrolledAt, Class classEntity, Reviewee reviewee) {
        this.enrollmentID = enrollmentID;
        this.enrolledAt = enrolledAt;
        this.classEntity = classEntity;
        this.reviewee = reviewee;
    }

    // Getters and setters
    public String getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(String enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public Class getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(Class classEntity) {
        this.classEntity = classEntity;
    }

    public Reviewee getReviewee() {
        return reviewee;
    }

    public void setReviewee(Reviewee reviewee) {
        this.reviewee = reviewee;
    }
}