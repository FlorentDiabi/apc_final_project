package org.amu.service;

import org.amu.model.Exam;
import org.amu.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing exams in the system.
 * Provides methods for CRUD operations and other exam-related actions.
 */
@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    /**
     * Retrieves all exams.
     *
     * @return a list of all exams
     */
    public List<Exam> getAllExams() {
        return (List<Exam>) examRepository.findAll();
    }

    /**
     * Retrieves an exam by its ID.
     *
     * @param id the ID of the exam to retrieve
     * @return a ResponseEntity containing the exam if found, or a 404 if not found
     */
    public ResponseEntity<Exam> getExamById(Long id) {
        Optional<Exam> exam = examRepository.findById(id);
        return exam.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new exam.
     *
     * @param exam the exam object to be created
     * @return a ResponseEntity containing the created exam
     */
    public ResponseEntity<Exam> createExam(Exam exam) {
        Exam savedExam = examRepository.save(exam);
        return ResponseEntity.ok(savedExam);
    }

    /**
     * Updates an existing exam by its ID.
     *
     * @param id the ID of the exam to update
     * @param updatedExam the exam object containing updated data
     * @return a ResponseEntity containing the updated exam if successful, or a 404 if not found
     */
    public ResponseEntity<Exam> updateExam(Long id, Exam updatedExam) {
        return examRepository.findById(id)
                .map(exam -> {
                    exam.setTitle(updatedExam.getTitle());
                    exam.setUser(updatedExam.getUser());
                    exam.setQuestions(updatedExam.getQuestions());
                    exam.setStudents(updatedExam.getStudents());
                    examRepository.save(exam);
                    return ResponseEntity.ok(exam);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Deletes an exam by its ID.
     *
     * @param id the ID of the exam to delete
     * @return a ResponseEntity indicating the result of the deletion
     */
    public ResponseEntity<Void> deleteExam(Long id) {
        if (examRepository.existsById(id)) {
            examRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
