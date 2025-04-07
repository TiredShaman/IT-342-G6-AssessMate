package edu.cit.AssessMate.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes")
public class Class {
    @Id
    @Column(name = "class_id", length = 15)
    private String classID;

    @Column(name = "class_name", length = 50)
    private String className;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "enrollment_code", length = 5)
    private String enrollmentCode;

    @JsonBackReference
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id", referencedColumnName = "coach_id")
    private Coach coach;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(mappedBy = "classEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Quiz> quizzes;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(mappedBy = "classEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollments;

    // Constructors
    public Class() {
    }

    public Class(String classID, String className, String description,
            String enrollmentCode, Coach coach) {
        this.classID = classID;
        this.className = className;
        this.description = description;
        this.enrollmentCode = enrollmentCode;
        this.coach = coach;
    }

    // Getters and Setters
    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
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

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    // Convenience methods for managing bidirectional relationships
    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
        quiz.setClassEntity(this);
    }

    public void removeQuiz(Quiz quiz) {
        quizzes.remove(quiz);
        quiz.setClassEntity(null);
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
        enrollment.setClassEntity(this);
    }

    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
        enrollment.setClassEntity(null);
    }

    @Override
    public String toString() {
        return "Class{" +
                "classID='" + classID + '\'' +
                ", className='" + className + '\'' +
                ", description='" + description + '\'' +
                ", enrollmentCode='" + enrollmentCode + '\'' +
                '}';
    }
}