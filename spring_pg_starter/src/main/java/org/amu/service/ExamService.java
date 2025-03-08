package org.amu.service;

import org.amu.model.Exam;
import org.amu.repository.ExamRepository;
import org.amu.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    // Récupérer tous les examens
    public List<Exam> getAllExams() {
        return (List<Exam>) examRepository.findAll();
    }

    // Récupérer un examen par ID
    public ResponseEntity<Exam> getExamById(Long id) {
        Optional<Exam> exam = examRepository.findById(id);
        return exam.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Créer un nouvel examen
    public ResponseEntity<Exam> createExam(Exam exam) {
        Exam savedExam = examRepository.save(exam);
        return ResponseEntity.ok(savedExam);
    }

    // Mettre à jour un examen
    public ResponseEntity<Exam> updateExam(Long id, Exam updatedExam) {
        return examRepository.findById(id)
                .map(exam -> {
                    exam.setTitle(updatedExam.getTitle());
                    exam.setUser(updatedExam.getUser());
                    exam.setQuestions(updatedExam.getQuestions());
                    exam.setStudents(updatedExam.getStudents());
                    examRepository.save(exam);
                    return ResponseEntity.ok(exam);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Supprimer un examen
    public ResponseEntity<Void> deleteExam(Long id) {
        if (examRepository.existsById(id)) {
            examRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
