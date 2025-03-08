package org.amu.controller;

import org.amu.model.Question;
import org.amu.repository.QuestionRepository;
import org.amu.service.QuestionService;
import org.amu.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    //Get all questions
    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    //Get a question by id
    @GetMapping("/questions/get/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    //Create a new question
    @PostMapping("/questions/new")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    //Update a question by id
    @PutMapping("/questions/update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(id, updatedQuestion);
    }

    //Delete a question by id
    @DeleteMapping("/questions/delete/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        if(questionService.existsById(id)){
            return questionService.deleteById(id);
        }
        return ResponseEntity.notFound().build();
    }
}
