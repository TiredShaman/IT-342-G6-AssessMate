package edu.cit.AssessMate.Service;

import edu.cit.AssessMate.Entity.Reviewee;
import edu.cit.AssessMate.Repository.RevieweeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevieweeService {
    private final RevieweeRepository revieweeRepository;

    @Autowired
    public RevieweeService(RevieweeRepository revieweeRepository) {
        this.revieweeRepository = revieweeRepository;
    }

    public List<Reviewee> findAll() {
        return revieweeRepository.findAll();
    }

    public Optional<Reviewee> findById(String revieweeID) {
        return revieweeRepository.findById(revieweeID);
    }

    public Optional<Reviewee> findByEmail(String email) {
        return revieweeRepository.findByEmail(email);
    }

    public Reviewee save(Reviewee reviewee) {
        return revieweeRepository.save(reviewee);
    }

    public void deleteById(String revieweeID) {
        revieweeRepository.deleteById(revieweeID);
    }
}
