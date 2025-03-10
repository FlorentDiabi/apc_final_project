package org.amu.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents an Exam entity.
 */
@Entity
@Table(name = "exam")
public class Exam {

    /** Unique identifier for the exam. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The title of the exam. */
    private String title;

    /** The teacher who created the exam. */
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User user;

    /** The set of questions associated with this exam. */
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Question> questions = new HashSet<>();

    /** The set of students enrolled in this exam. */
    @ManyToMany
    @JoinTable(
            name = "exam_students",
            joinColumns = @JoinColumn(name = "exam_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<User> students = new HashSet<>();

    /**
     * Default constructor for JPA.
     */
    public Exam() {
    }

    /**
     * Constructs an Exam with the given ID and title.
     *
     * @param id    the unique identifier of the exam
     * @param title the title of the exam
     */
    public Exam(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Gets the unique identifier of the exam.
     *
     * @return the exam ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the exam.
     *
     * @param id the exam ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the teacher associated with the exam.
     *
     * @return the teacher (User entity)
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the teacher associated with the exam.
     *
     * @param user the teacher (User entity)
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the title of the exam.
     *
     * @return the exam title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the exam.
     *
     * @param title the exam title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the set of questions associated with the exam.
     *
     * @return the set of questions
     */
    public Set<Question> getQuestions() {
        return questions;
    }

    /**
     * Sets the set of questions associated with the exam.
     *
     * @param questions the set of questions
     */
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    /**
     * Adds a question to the exam.
     *
     * @param question the question to add
     */
    public void addQuestion(Question question) {
        questions.add(question);
        question.setExam(this);
    }

    /**
     * Removes a question from the exam by its ID.
     *
     * @param questionId the ID of the question to remove
     */
    public void removeQuestion(long questionId) {
        Question question = this.questions.stream()
                .filter(t -> t.getId() == questionId)
                .findFirst()
                .orElse(null);
        if (question == null) {
            return;
        }
        this.questions.remove(question);
    }

    /**
     * Gets the set of students enrolled in the exam.
     *
     * @return the set of students
     */
    public Set<User> getStudents() {
        return students;
    }

    /**
     * Sets the set of students enrolled in the exam.
     *
     * @param students the set of students
     */
    public void setStudents(Set<User> students) {
        this.students = students;
    }
}
