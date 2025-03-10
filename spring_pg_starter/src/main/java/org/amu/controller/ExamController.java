package org.amu.controller;

import org.amu.model.Exam;
import org.amu.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing exams in the system.
 * Provides REST endpoints for CRUD operations on exams.
 */
@RestController
public class ExamController {

    @Autowired
    private ExamService examService;

    /**
     * Retrieves all exams.
     *
     * @return a list of all exams
     */
    @GetMapping("/exams")
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    /**
     * Retrieves an exam by its ID.
     *
     * @param id the ID of the exam to retrieve
     * @return a ResponseEntity containing the exam if found, or a 404 if not found
     */
    @GetMapping("/exams/get/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        return examService.getExamById(id);
    }

    /**
     * Creates a new exam.
     *
     * @param exam the exam object to be created
     * @return a ResponseEntity containing the created exam
     */
    @PostMapping("/exams/new")
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }

    /**
     * Updates an existing exam.
     *
     * @param id the ID of the exam to update
     * @param updatedExam the exam object containing updated data
     * @return a ResponseEntity containing the updated exam
     */
    @PutMapping("/exams/get/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam updatedExam) {
        return examService.updateExam(id, updatedExam);
    }

    /**
     * Deletes an exam by its ID.
     *
     * @param id the ID of the exam to delete
     * @return a ResponseEntity indicating the result of the deletion
     */
    @DeleteMapping("/exams/delete/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        return examService.deleteExam(id);
    }
}
