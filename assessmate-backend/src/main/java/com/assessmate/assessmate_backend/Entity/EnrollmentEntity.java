package com.assessmate.assessmate_backend.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollment")
public class EnrollmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollmentID")
    private Long enrollmentID;

    @ManyToOne
    @JoinColumn(name = "classID")
    private ClassEntity class_;

    @ManyToOne
    @JoinColumn(name = "revieweeID")
    private RevieweeEntity reviewee;

    @Column(name = "enrolledAt")
    private LocalDateTime enrolledAt;

    // Constructors
    public EnrollmentEntity() {
    }

    public EnrollmentEntity(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    // Getters and Setters
    public Long getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(Long enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public ClassEntity getClass_() {
        return class_;
    }

    public void setClass_(ClassEntity class_) {
        this.class_ = class_;
    }

    public RevieweeEntity getReviewee() {
        return reviewee;
    }

    public void setReviewee(RevieweeEntity reviewee) {
        this.reviewee = reviewee;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }
}