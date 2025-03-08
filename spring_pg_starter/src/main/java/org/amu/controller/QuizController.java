package org.amu.controller;

import org.amu.model.Quiz;
import org.amu.repository.QuizRepository;
import org.amu.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class QuizController {

    @Autowired
    QuizService quizService;

    //Récupérer tous les quizzes
    @GetMapping("/quizzes")
    public Iterable<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    //Récupérer un quiz par id
    @GetMapping("/quizzes/get/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }

    //Créer un nouveau quiz
    @PostMapping("/quizzes/new")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    //Mettre à jour un quiz existant
    @PutMapping("/quizzes/update/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
        return quizService.updateQuiz(id, updatedQuiz);
    }

    //Supprimer un quiz
    @DeleteMapping("/quizzes/delete/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        if(quizService.existsById(id)){
            return quizService.deleteById(id);
        }
        return ResponseEntity.notFound().build();
    }
}
