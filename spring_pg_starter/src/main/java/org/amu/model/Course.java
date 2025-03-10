package org.amu.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Course entity.
 */
@Entity
@Table(name = "course")
public class Course {

    /** Unique identifier for the course. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Title of the course. */
    @Column(nullable = false)
    private String title;

    /** Students enrolled in this course. */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "course_students",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<User> students = new HashSet<>();

    /**
     * Default constructor for JPA.
     */
    public Course() {
    }

    /**
     * Constructs a Course with the given details.
     *
     * @param id    the unique identifier of the course
     * @param title the title of the course
     */
    public Course(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Gets the unique identifier of the course.
     *
     * @return the course ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the course.
     *
     * @param id the course ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the title of the course.
     *
     * @return the course title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the course.
     *
     * @param title the course title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the students enrolled in this course.
     *
     * @return the set of students
     */
    public Set<User> getStudents() {
        return students;
    }

    /**
     * Sets the students enrolled in this course.
     *
     * @param students the set of students
     */
    public void setStudents(Set<User> students) {
        this.students = students;
    }

    /**
     * Adds a student to the course.
     *
     * @param student the student to add
     */
    public void addStudent(User student) {
        students.add(student);
        student.getCourses().add(this);
    }

    /**
     * Removes a student from the course.
     *
     * @param student the student to remove
     */
    public void removeStudent(User student) {
        students.remove(student);
        student.getCourses().remove(this);
    }
}
