package edu.cit.AssessMate.Service;


import edu.cit.AssessMate.Entity.Class;
import edu.cit.AssessMate.Repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    @Autowired
    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<Class> findAll() {
        return classRepository.findAll();
    }

    public Optional<Class> findById(String classID) {
        return classRepository.findById(classID);
    }

    public List<Class> findByCoachId(String coachID) {
        return classRepository.findByCoachCoachID(coachID);
    }

    public Class save(Class classEntity) {
        return classRepository.save(classEntity);
    }

    public void deleteById(String classID) {
        classRepository.deleteById(classID);
    }
}