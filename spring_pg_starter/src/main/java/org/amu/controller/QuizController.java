package org.amu.controller;

import org.amu.model.Quiz;
import org.amu.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller for managing quizzes in the system.
 * Provides REST endpoints for CRUD operations on quizzes.
 */
@RestController
public class QuizController {

    @Autowired
    QuizService quizService;

    /**
     * Retrieves all quizzes.
     *
     * @return an iterable collection of all quizzes
     */
    @GetMapping("/quizzes")
    public Iterable<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    /**
     * Retrieves a quiz by its ID.
     *
     * @param id the ID of the quiz to retrieve
     * @return a ResponseEntity containing the quiz if found, or a 404 if not found
     */
    @GetMapping("/quizzes/get/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    /**
     * Creates a new quiz.
     *
     * @param quiz the quiz object to be created
     * @return a ResponseEntity containing the created quiz
     */
    @PostMapping("/quizzes/new")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    /**
     * Updates an existing quiz.
     *
     * @param id the ID of the quiz to update
     * @param updatedQuiz the quiz object containing updated data
     * @return a ResponseEntity containing the updated quiz
     */
    @PutMapping("/quizzes/update/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
        return quizService.updateQuiz(id, updatedQuiz);
    }

    /**
     * Deletes a quiz by its ID.
     *
     * @param id the ID of the quiz to delete
     * @return a ResponseEntity indicating the result of the deletion
     */
    @DeleteMapping("/quizzes/delete/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        if(quizService.existsById(id)){
            return quizService.deleteById(id);
        }
        return ResponseEntity.notFound().build();
    }
}
