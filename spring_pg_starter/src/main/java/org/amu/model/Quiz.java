package org.amu.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Quiz entity.
 */
@Entity
@Table(name = "quiz")
public class Quiz {

    /** Unique identifier for the quiz. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Title of the quiz. */
    @Column
    private String title;

    /** Set of questions associated with the quiz. */
    @ManyToMany
    @JoinTable(
            name = "quiz_questions",
            joinColumns = @JoinColumn(name = "quiz_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private Set<Question> questions = new HashSet<>();

    /**
     * Default constructor for JPA.
     */
    protected Quiz() {
    }

    /**
     * Constructs a new Quiz with the specified ID and title.
     *
     * @param id    the unique identifier of the quiz
     * @param title the title of the quiz
     */
    public Quiz(long id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Gets the unique identifier of the quiz.
     *
     * @return the quiz ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the quiz.
     *
     * @param id the quiz ID
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the title of the quiz.
     *
     * @return the quiz title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the quiz.
     *
     * @param title the new title of the quiz
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the set of questions associated with the quiz.
     *
     * @return the set of questions
     */
    public Set<Question> getQuestions() {
        return questions;
    }

    /**
     * Sets the set of questions for the quiz.
     *
     * @param questions the set of questions
     */
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    /**
     * Adds a question to the quiz.
     *
     * @param question the question to add
     */
    public void addQuestion(Question question) {
        this.questions.add(question);
        question.getQuizzes().add(this);
    }

    /**
     * Removes a question from the quiz by its ID.
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
}
