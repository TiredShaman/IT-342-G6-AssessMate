package com.assessmate.assessmate_backend.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classID")
    private Long classID;

    @Column(name = "className", length = 50)
    private String className;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "enrollmentCode", length = 5)
    private String enrollmentCode;

    @ManyToOne
    @JoinColumn(name = "coachID")
    private CoachEntity coach;

    @OneToMany(mappedBy = "class", cascade = CascadeType.ALL)
    private List<QuizEntity> quizzes;

    @OneToMany(mappedBy = "class", cascade = CascadeType.ALL)
    private List<EnrollmentEntity> enrollments;

    // Constructors
    public ClassEntity() {
    }

    public ClassEntity(String className, String description, String enrollmentCode) {
        this.className = className;
        this.description = description;
        this.enrollmentCode = enrollmentCode;
    }

    // Getters and Setters
    public Long getClassID() {
        return classID;
    }

    public void setClassID(Long classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnrollmentCode() {
        return enrollmentCode;
    }

    public void setEnrollmentCode(String enrollmentCode) {
        this.enrollmentCode = enrollmentCode;
    }

    public CoachEntity getCoach() {
        return coach;
    }

    public void setCoach(CoachEntity coach) {
        this.coach = coach;
    }

    public List<QuizEntity> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<QuizEntity> quizzes) {
        this.quizzes = quizzes;
    }

    public List<EnrollmentEntity> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<EnrollmentEntity> enrollments) {
        this.enrollments = enrollments;
    }
}