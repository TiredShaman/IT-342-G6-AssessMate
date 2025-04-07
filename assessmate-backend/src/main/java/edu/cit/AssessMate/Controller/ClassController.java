package edu.cit.AssessMate.Controller;
import edu.cit.AssessMate.Entity.Class;
import edu.cit.AssessMate.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassController {
    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public List<Class> getAllClasses() {
        return classService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Class> getClassById(@PathVariable String id) {
        Optional<Class> classEntity = classService.findById(id);
        return classEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/coach/{coachId}")
    public List<Class> getClassesByCoachId(@PathVariable String coachId) {
        return classService.findByCoachId(coachId);
    }

    @PostMapping
    public Class createClass(@RequestBody Class classEntity) {
        return classService.save(classEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Class> updateClass(@PathVariable String id, @RequestBody Class classDetails) {
        Optional<Class> optionalClass = classService.findById(id);
        if (optionalClass.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Class classEntity = optionalClass.get();
        classEntity.setClassName(classDetails.getClassName());
        classEntity.setDescription(classDetails.getDescription());
        classEntity.setEnrollmentCode(classDetails.getEnrollmentCode());
        classEntity.setCoach(classDetails.getCoach());
        Class updatedClass = classService.save(classEntity);
        return ResponseEntity.ok(updatedClass);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable String id) {
        if (classService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        classService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}