package org.amu.service;

import org.amu.model.Course;
import org.amu.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Récupérer tous les cours
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    // Récupérer un cours par ID
    public ResponseEntity<Course> getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Créer un nouveau cours
    public ResponseEntity<Course> createCourse(Course course) {
        Course savedCourse = courseRepository.save(course);
        return ResponseEntity.ok(savedCourse);
    }

    // Mettre à jour un cours existant
    public ResponseEntity<Course> updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id).map(course -> {
            course.setTitle(updatedCourse.getTitle());
            return ResponseEntity.ok(courseRepository.save(course));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Supprimer un cours
    public ResponseEntity<Object> deleteCourse(Long id) {
        return courseRepository.findById(id).map(course -> {
            courseRepository.delete(course);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
