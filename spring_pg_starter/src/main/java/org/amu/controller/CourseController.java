package org.amu.controller;

import org.amu.model.Course;
import org.amu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Récupérer tous les cours
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Récupérer un cours par ID
    @GetMapping("/courses/get/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    // Créer un nouveau cours
    @PostMapping("/courses/new")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    // Mettre à jour un cours existant
    @PutMapping("/courses/get/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }

    // Supprimer un cours
    @DeleteMapping("/courses/delete/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}
