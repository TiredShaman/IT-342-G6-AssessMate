package edu.cit.AssessMate.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.List;

@Entity
@Table(name = "coaches")
public class Coach {
    @Id
    @GeneratedValue(generator = "coach-id-generator")
    @GenericGenerator(name = "coach-id-generator", strategy = "edu.cit.AssessMate.Utils.CoachIDGenerator")
    @Column(name = "coach_id", length = 16)
    private String coachID;

    @Column(name = "coach_first_name", length = 50)
    private String coachFirstName;

    @Column(name = "coach_last_name", length = 50)
    private String coachLastName;

    @Column(columnDefinition = "TEXT")
    private String specialty;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(length = 100)
    private String institution;

    @JsonManagedReference
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Class> classes;

    // Constructors
    public Coach() {
    }

    public Coach(String coachID, String coachFirstName, String coachLastName,
            String specialty, String bio, String institution) {
        this.coachID = coachID;
        this.coachFirstName = coachFirstName;
        this.coachLastName = coachLastName;
        this.specialty = specialty;
        this.bio = bio;
        this.institution = institution;
    }

    // Getters and Setters
    public String getCoachID() {
        return coachID;
    }

    public void setCoachID(String coachID) {
        this.coachID = coachID;
    }

    public String getCoachFirstName() {
        return coachFirstName;
    }

    public void setCoachFirstName(String coachFirstName) {
        this.coachFirstName = coachFirstName;
    }

    public String getCoachLastName() {
        return coachLastName;
    }

    public void setCoachLastName(String coachLastName) {
        this.coachLastName = coachLastName;
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

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    // Convenience methods for managing bidirectional relationship
    public void addClass(Class classEntity) {
        classes.add(classEntity);
        classEntity.setCoach(this);
    }

    public void removeClass(Class classEntity) {
        classes.remove(classEntity);
        classEntity.setCoach(null);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "coachID='" + coachID + '\'' +
                ", coachFirstName='" + coachFirstName + '\'' +
                ", coachLastName='" + coachLastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", bio='" + bio + '\'' +
                ", institution='" + institution + '\'' +
                '}';
    }
}