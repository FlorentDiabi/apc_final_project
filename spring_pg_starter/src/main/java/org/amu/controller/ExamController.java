package org.amu.controller;

import org.amu.model.Exam;
import org.amu.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {

    @Autowired
    private ExamService examService;

    // Récupérer tous les examens
    @GetMapping("/exams")
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    // Récupérer un examen par ID
    @GetMapping("/exams/get/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        return examService.getExamById(id);
    }

    // Créer un nouvel examen
    @PostMapping("/exams/new")
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }

    // Mettre à jour un examen existant
    @PutMapping("/exams/get/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam updatedExam) {
        return examService.updateExam(id, updatedExam);
    }

    // Supprimer un examen
    @DeleteMapping("/exams/delete/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        return examService.deleteExam(id);
    }
}
