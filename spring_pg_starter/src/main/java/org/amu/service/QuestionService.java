package org.amu.service;

import org.amu.model.Question;
import org.amu.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    //Get all questions
    public List<Question> getAllQuestions() {
        return (List<Question>) questionRepository.findAll();
    }

    //Get a question by id
    public ResponseEntity<Question> getQuestionById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Create a new question
    public ResponseEntity<Question> createQuestion(Question question) {
        Question savedQuestion = questionRepository.save(question);
        return ResponseEntity.ok(savedQuestion);
    }

    //Update a question by id
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

    public boolean existsById(Long id) {
        return questionRepository.existsById(id);
    }

    //Delete a question by id
    public ResponseEntity<Void> deleteById(Long id) {
        questionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
