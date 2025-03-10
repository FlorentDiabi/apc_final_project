package org.amu.service;

import org.amu.model.Quiz;
import org.amu.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for managing quizzes in the system.
 * Provides methods for CRUD operations and other quiz-related actions.
 */
@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    /**
     * Retrieves all quizzes.
     *
     * @return an iterable collection of all quizzes
     */
    public Iterable<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    /**
     * Retrieves a quiz by its ID.
     *
     * @param id the ID of the quiz to retrieve
     * @return a ResponseEntity containing the quiz if found, or a 404 if not found
     */
    public ResponseEntity<Quiz> getQuizById(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new quiz.
     *
     * @param quiz the quiz object to be created
     * @return a ResponseEntity containing the created quiz
     */
    public ResponseEntity<Quiz> createQuiz(Quiz quiz) {
        Quiz savedQuiz = quizRepository.save(quiz);
        return ResponseEntity.ok(savedQuiz);
    }

    /**
     * Updates an existing quiz.
     *
     * @param id the ID of the quiz to update
     * @param updatedQuiz the quiz object containing updated data
     * @return a ResponseEntity containing the updated quiz if successful, or a 404 if not found
     */
    public ResponseEntity<Quiz> updateQuiz(Long id, Quiz updatedQuiz) {
        return quizRepository.findById(id)
                .map(quiz -> {
                    quiz.setTitle(updatedQuiz.getTitle());
                    quiz.setQuestions(updatedQuiz.getQuestions());
                    quizRepository.save(quiz);
                    return ResponseEntity.ok(quiz);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Checks if a quiz exists by its ID.
     *
     * @param id the ID of the quiz to check
     * @return true if the quiz exists, false otherwise
     */
    public boolean existsById(Long id) {
        return quizRepository.existsById(id);
    }

    /**
     * Deletes a quiz by its ID.
     *
     * @param id the ID of the quiz to delete
     * @return a ResponseEntity indicating the result of the deletion
     */
    public ResponseEntity<Void> deleteById(Long id) {
        quizRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
