package org.amu.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Question entity.
 */
@Entity
@Table(name = "question")
public class Question {

    /** Unique identifier for the question. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The title or text of the question. */
    @Column
    private String questionTitle;

    /** The category of the question (e.g., Science, History). */
    @Column
    private String category;

    /** The difficulty level of the question (e.g., Easy, Medium, Hard). */
    @Column
    private String difficultyLevel;

    /** The first answer option. */
    @Column
    private String option1;

    /** The second answer option. */
    @Column
    private String option2;

    /** The third answer option. */
    @Column
    private String option3;

    /** The fourth answer option. */
    @Column
    private String option4;

    /** The correct answer for the question. */
    @Column
    private String rightAnswer;

    /** The set of quizzes that contain this question. */
    @ManyToMany(mappedBy = "questions")
    private Set<Quiz> quizzes = new HashSet<>();

    /** The exam to which this question belongs. */
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    /**
     * Default constructor for JPA.
     */
    public Question() {
    }

    /**
     * Constructs a new Question with the specified attributes.
     *
     * @param id             the unique identifier of the question
     * @param questionTitle  the title or text of the question
     * @param category       the category of the question
     * @param difficultyLevel the difficulty level of the question
     * @param option1        the first answer option
     * @param option2        the second answer option
     * @param option3        the third answer option
     * @param option4        the fourth answer option
     * @param rightAnswer    the correct answer for the question
     */
    public Question(Long id, String questionTitle, String category, String difficultyLevel,
                    String option1, String option2, String option3, String option4, String rightAnswer) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.category = category;
        this.difficultyLevel = difficultyLevel;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAnswer = rightAnswer;
    }

    /**
     * Gets the unique identifier of the question.
     *
     * @return the question ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the question.
     *
     * @param id the question ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the title or text of the question.
     *
     * @return the question title
     */
    public String getQuestionTitle() {
        return questionTitle;
    }

    /**
     * Sets the title or text of the question.
     *
     * @param questionTitle the question title
     */
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    /**
     * Gets the category of the question.
     *
     * @return the question category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the question.
     *
     * @param category the question category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the difficulty level of the question.
     *
     * @return the difficulty level
     */
    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * Sets the difficulty level of the question.
     *
     * @param difficultyLevel the difficulty level
     */
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    /**
     * Gets the first answer option.
     *
     * @return the first option
     */
    public String getOption1() {
        return option1;
    }

    /**
     * Sets the first answer option.
     *
     * @param option1 the first option
     */
    public void setOption1(String option1) {
        this.option1 = option1;
    }

    /**
     * Gets the second answer option.
     *
     * @return the second option
     */
    public String getOption2() {
        return option2;
    }

    /**
     * Sets the second answer option.
     *
     * @param option2 the second option
     */
    public void setOption2(String option2) {
        this.option2 = option2;
    }

    /**
     * Gets the third answer option.
     *
     * @return the third option
     */
    public String getOption3() {
        return option3;
    }

    /**
     * Sets the third answer option.
     *
     * @param option3 the third option
     */
    public void setOption3(String option3) {
        this.option3 = option3;
    }

    /**
     * Gets the fourth answer option.
     *
     * @return the fourth option
     */
    public String getOption4() {
        return option4;
    }

    /**
     * Sets the fourth answer option.
     *
     * @param option4 the fourth option
     */
    public void setOption4(String option4) {
        this.option4 = option4;
    }

    /**
     * Gets the correct answer for the question.
     *
     * @return the correct answer
     */
    public String getRightAnswer() {
        return rightAnswer;
    }

    /**
     * Sets the correct answer for the question.
     *
     * @param rightAnswer the correct answer
     */
    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    /**
     * Gets the set of quizzes that contain this question.
     *
     * @return the set of quizzes
     */
    public Set<Quiz> getQuizzes() {
        return quizzes;
    }

    /**
     * Sets the set of quizzes that contain this question.
     *
     * @param quizzes the set of quizzes
     */
    public void setQuizzes(Set<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    /**
     * Gets the exam associated with this question.
     *
     * @return the exam
     */
    public Exam getExam() {
        return exam;
    }

    /**
     * Sets the exam associated with this question.
     *
     * @param exam the exam
     */
    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
