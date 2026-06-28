package com.westendsgeschichte.repository;

import com.westendsgeschichte.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository für den Datenbankzugriff auf Fragen.
 * Erbt alle Standard-CRUD-Methoden von JpaRepository.
 */
@Repository
public interface LoadQuestionsRepository extends JpaRepository<Questions, Long> {
    // Alle benötigten Methoden werden von JpaRepository bereitgestellt.
}
