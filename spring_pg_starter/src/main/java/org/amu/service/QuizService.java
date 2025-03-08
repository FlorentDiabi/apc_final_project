package org.amu.service;

import org.amu.model.Quiz;
import org.amu.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    //Find all quizzes
    public Iterable<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    //Get quiz by id
    public ResponseEntity<Quiz> getQuizById(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Create a new quiz
    public ResponseEntity<Quiz> createQuiz(Quiz quiz) {
        Quiz savedQuiz = quizRepository.save(quiz);
        return ResponseEntity.ok(savedQuiz);
    }

    //Update a quiz
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

    //Check if a quiz exists
    public boolean existsById(Long id) {
        return quizRepository.existsById(id);
    }

    //Delete a quiz by id
    public ResponseEntity<Void> deleteById(Long id) {
        quizRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
