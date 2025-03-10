package org.amu.controller;

import org.amu.model.Course;
import org.amu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing courses in the system.
 * Provides REST endpoints for CRUD operations on courses.
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * Retrieves all courses.
     *
     * @return a list of all courses
     */
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    /**
     * Retrieves a course by its ID.
     *
     * @param id the ID of the course to retrieve
     * @return a ResponseEntity containing the course if found, or a 404 if not found
     */
    @GetMapping("/courses/get/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    /**
     * Creates a new course.
     *
     * @param course the course object to be created
     * @return a ResponseEntity containing the created course
     */
    @PostMapping("/courses/new")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    /**
     * Updates an existing course.
     *
     * @param id the ID of the course to update
     * @param updatedCourse the course object containing updated data
     * @return a ResponseEntity containing the updated course
     */
    @PutMapping("/courses/get/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }

    /**
     * Deletes a course by its ID.
     *
     * @param id the ID of the course to delete
     * @return a ResponseEntity indicating the result of the deletion
     */
    @DeleteMapping("/courses/delete/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}
