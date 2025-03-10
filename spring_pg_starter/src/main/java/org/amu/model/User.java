package org.amu.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a User entity.
 */
@Entity
@Table(name = "users")
public class User {

    /** Unique identifier for the user. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Indicates whether the user is active. */
    @Column
    private Boolean active;

    /** Email address of the user. */
    @Column
    private String email;

    /** First name of the user. */
    @Column
    private String firstName;

    /** Last name of the user. */
    @Column
    private String lastName;

    /** Password of the user. */
    @Column
    private String password;

    /** Role of the user (e.g., STUDENT, TEACHER, ADMIN). */
    @Column
    private String role;

    /** Username for authentication. */
    @Column
    private String username;

    /** Exams created by the user (if the user is a teacher). */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Set<Exam> exams = new HashSet<>();

    /** Exams in which the user is enrolled as a student. */
    @ManyToMany(mappedBy = "students")
    private Set<Exam> exams_student = new HashSet<>();

    /** Courses in which the user is enrolled. */
    @ManyToMany
    @JoinTable(
            name = "course_students",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    /**
     * Default constructor for JPA.
     */
    public User() {
    }

    /**
     * Constructs a User with the given details.
     *
     * @param id        the unique identifier of the user
     * @param active    whether the user is active
     * @param email     the email of the user
     * @param firstName the first name of the user
     * @param lastName  the last name of the user
     * @param password  the password of the user
     * @param role      the role of the user
     * @param username  the username of the user
     */
    public User(Long id, Boolean active, String email, String firstName, String lastName, String password, String role, String username) {
        this.id = id;
        this.active = active;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.username = username;
    }

    /**
     * Gets the unique identifier of the user.
     *
     * @return the user ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id the user ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Checks if the user is active.
     *
     * @return true if active, false otherwise
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the user's active status.
     *
     * @param active true to activate, false to deactivate
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * Gets the email of the user.
     *
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the first name of the user.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the role of the user.
     *
     * @return the user's role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role the role of the user
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the exams created by the user (as a teacher).
     *
     * @return the set of exams
     */
    public Set<Exam> getExams() {
        return exams;
    }

    /**
     * Sets the exams created by the user (as a teacher).
     *
     * @param exams the set of exams
     */
    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    /**
     * Adds an exam to the user's list of created exams.
     *
     * @param exam the exam to add
     */
    public void addExam(Exam exam) {
        exams.add(exam);
        exam.setUser(this);
    }

    /**
     * Removes an exam from the user's list of created exams.
     *
     * @param exam the exam to remove
     */
    public void removeExam(Exam exam) {
        exams.remove(exam);
        exam.setUser(null);
    }

    /**
     * Gets the courses in which the user is enrolled.
     *
     * @return the set of courses
     */
    public Set<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the courses in which the user is enrolled.
     *
     * @param courses the set of courses
     */
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    /**
     * Adds a course to the user's enrolled courses.
     *
     * @param course the course to add
     */
    public void addCourse(Course course) {
        courses.add(course);
        course.getStudents().add(this);
    }

    /**
     * Removes a course from the user's enrolled courses.
     *
     * @param course the course to remove
     */
    public void removeCourse(Course course) {
        courses.remove(course);
        course.getStudents().remove(this);
    }
}
