package org.amu.service;

import org.amu.model.Question;
import org.amu.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing questions in the system.
 * Provides methods for CRUD operations and other question-related actions.
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    /**
     * Retrieves all questions.
     *
     * @return a list of all questions
     */
    public List<Question> getAllQuestions() {
        return (List<Question>) questionRepository.findAll();
    }

    /**
     * Retrieves a question by its ID.
     *
     * @param id the ID of the question to retrieve
     * @return a ResponseEntity containing the question if found, or a 404 if not found
     */
    public ResponseEntity<Question> getQuestionById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new question.
     *
     * @param question the question object to be created
     * @return a ResponseEntity containing the created question
     */
    public ResponseEntity<Question> createQuestion(Question question) {
        Question savedQuestion = questionRepository.save(question);
        return ResponseEntity.ok(savedQuestion);
    }

    /**
     * Updates an existing question by its ID.
     *
     * @param id the ID of the question to update
     * @param updatedQuestion the question object containing updated data
     * @return a ResponseEntity containing the updated question if successful, or a 404 if not found
     */
    public ResponseEntity<Question> updateQuestion(Long id, Question updatedQuestion) {
        return questionRepository.findById(id).map(existingQuestion -> {
            existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
            existingQuestion.setCategory(updatedQuestion.getCategory());
            existingQuestion.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
            existingQuestion.setOption1(updatedQuestion.getOption1());
            existingQuestion.setOption2(updatedQuestion.getOption2());
            existingQuestion.setOption3(updatedQuestion.getOption3());
            existingQuestion.setOption4(updatedQuestion.getOption4());
            existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
            existingQuestion.setExam(updatedQuestion.getExam());

            Question savedQuestion = questionRepository.save(existingQuestion);
            return ResponseEntity.ok(savedQuestion);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Checks if a question exists by its ID.
     *
     * @param id the ID of the question to check
     * @return true if the question exists, false otherwise
     */
    public boolean existsById(Long id) {
        return questionRepository.existsById(id);
    }

    /**
     * Deletes a question by its ID.
     *
     * @param id the ID of the question to delete
     * @return a ResponseEntity indicating the result of the deletion
     */
    public ResponseEntity<Void> deleteById(Long id) {
        questionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
