package org.amu.repository;

import org.amu.model.Exam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ExamRepository extends CrudRepository<Exam, Long> {
    @Query("SELECT e FROM Exam e WHERE e.user.username = :username ORDER BY e.id ASC")
    Optional<Exam> findFirstExamByTeacherUsername(@Param("username") String username);
}
