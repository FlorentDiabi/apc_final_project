package org.amu.controller;

import org.amu.model.Question;
import org.amu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing questions in the system.
 * Provides REST endpoints for CRUD operations on questions.
 */
@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    /**
     * Retrieves all questions.
     *
     * @return a list of all questions
     */
    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    /**
     * Retrieves a question by its ID.
     *
     * @param id the ID of the question to retrieve
     * @return a ResponseEntity containing the question if found, or a 404 if not found
     */
    @GetMapping("/questions/get/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    /**
     * Creates a new question.
     *
     * @param question the question object to be created
     * @return a ResponseEntity containing the created question
     */
    @PostMapping("/questions/new")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    /**
     * Updates an existing question.
     *
     * @param id the ID of the question to update
     * @param updatedQuestion the question object containing updated data
     * @return a ResponseEntity containing the updated question
     */
    @PutMapping("/questions/update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(id, updatedQuestion);
    }

    /**
     * Deletes a question by its ID.
     *
     * @param id the ID of the question to delete
     * @return a ResponseEntity indicating the result of the deletion
     */
    @DeleteMapping("/questions/delete/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        if(questionService.existsById(id)){
            return questionService.deleteById(id);
        }
        return ResponseEntity.notFound().build();
    }
}
