package com.assessmate.assessmate_backend.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "coach")
public class CoachEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coachID")
    private Long coachID;

    @Column(name = "coach_firstName", length = 50)
    private String coach_firstName;

    @Column(name = "coach_lastName", length = 50)
    private String coach_lastName;

    @Column(name = "specialty", columnDefinition = "TEXT")
    private String specialty;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "institution", length = 100)
    private String institution;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
    private List<ClassEntity> classes;

    // Default constructor
    public CoachEntity() {
    }

    // Constructor with fields
    public CoachEntity(String coach_firstName, String coach_lastName, String specialty,
            String bio, String institution) {
        this.coach_firstName = coach_firstName;
        this.coach_lastName = coach_lastName;
        this.specialty = specialty;
        this.bio = bio;
        this.institution = institution;
    }

    // Getters and Setters
    public Long getCoachID() {
        return coachID;
    }

    public void setCoachID(Long coachID) {
        this.coachID = coachID;
    }

    public String getCoach_firstName() {
        return coach_firstName;
    }

    public void setCoach_firstName(String coach_firstName) {
        this.coach_firstName = coach_firstName;
    }

    public String getCoach_lastName() {
        return coach_lastName;
    }

    public void setCoach_lastName(String coach_lastName) {
        this.coach_lastName = coach_lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public List<ClassEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassEntity> classes) {
        this.classes = classes;
    }
}
