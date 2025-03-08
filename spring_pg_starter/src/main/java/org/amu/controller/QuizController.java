package org.amu.controller;

import org.amu.model.Quiz;
import org.amu.repository.QuizRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class QuizController {
    private final QuizRepository quizRepository;

    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    //Récupérer tous les quizzes
    @GetMapping("/quizzes")
    public Iterable<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    //Récupérer un quiz par id
    @GetMapping("/quizzes/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Créer un nouveau quiz
    @PostMapping("/quizzes/new")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz savedQuiz = quizRepository.save(quiz);
        return ResponseEntity.ok(savedQuiz);
    }

    //Mettre à jour un quiz existant
    @PutMapping("/quizzes/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
        return quizRepository.findById(id)
                .map(quiz -> {
                    quiz.setTitle(updatedQuiz.getTitle());
                    quiz.setQuestions(updatedQuiz.getQuestions());
                    quizRepository.save(quiz);
                    return ResponseEntity.ok(quiz);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Supprimer un quiz
    @DeleteMapping("/quizzes/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        if (quizRepository.existsById(id)) {
            quizRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
