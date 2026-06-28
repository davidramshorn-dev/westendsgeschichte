package com.westendsgeschichte.service;

import com.westendsgeschichte.model.Questions;
import com.westendsgeschichte.repository.LoadQuestionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service für die Verwaltung von Quiz-Fragen.
 * Kapselt die Geschäftslogik rund um Fragen.
 */
@Service
public class LoadQuestionsService {

    private final LoadQuestionsRepository questionsRepository;

    /**
     * Konstruktor-Injection des Repositories.
     *
     * @param questionsRepository Repository für Fragen
     */
    public LoadQuestionsService(LoadQuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    /**
     * Liefert alle Fragen aus der Datenbank.
     *
     * @return Liste aller Fragen
     */
    public List<Questions> getAllQuestions() {
        return questionsRepository.findAll();
    }

    /**
     * Speichert eine neue Frage in der Datenbank.
     *
     * @param question Frage-Objekt
     * @return gespeichertes Frage-Objekt mit generierter ID
     */
    public Questions saveQuestion(Questions question) {
        return questionsRepository.save(question);
    }

    /**
     * Sucht eine Frage anhand ihrer ID.
     *
     * @param id Fragen-ID
     * @return Frage oder null, falls nicht gefunden
     */
    public Questions getQuestionById(Long id) {
        return questionsRepository.findById(id).orElse(null);
    }
}
