package org.amu.service;

import org.amu.model.Course;
import org.amu.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing courses in the system.
 * Provides methods for CRUD operations and other course-related actions.
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * Retrieves all courses.
     *
     * @return a list of all courses
     */
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    /**
     * Retrieves a course by its ID.
     *
     * @param id the ID of the course to retrieve
     * @return a ResponseEntity containing the course if found, or a 404 if not found
     */
    public ResponseEntity<Course> getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Creates a new course.
     *
     * @param course the course object to be created
     * @return a ResponseEntity containing the created course
     */
    public ResponseEntity<Course> createCourse(Course course) {
        Course savedCourse = courseRepository.save(course);
        return ResponseEntity.ok(savedCourse);
    }

    /**
     * Updates an existing course by its ID.
     *
     * @param id the ID of the course to update
     * @param updatedCourse the course object containing updated data
     * @return a ResponseEntity containing the updated course if successful, or a 404 if not found
     */
    public ResponseEntity<Course> updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id).map(course -> {
            course.setTitle(updatedCourse.getTitle());
            return ResponseEntity.ok(courseRepository.save(course));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Deletes a course by its ID.
     *
     * @param id the ID of the course to delete
     * @return a ResponseEntity indicating the result of the deletion
     */
    public ResponseEntity<Object> deleteCourse(Long id) {
        return courseRepository.findById(id).map(course -> {
            courseRepository.delete(course);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
