package com.westendsgeschichte.controller;

import com.westendsgeschichte.model.Questions;
import com.westendsgeschichte.service.LoadQuestionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für Quiz-Fragen.
 * Stellt Endpunkte zum Laden und Erstellen von Fragen bereit.
 */
@RestController
@RequestMapping("/api/question")
@CrossOrigin(origins = "*")
public class LoadQuestionsController {

    private final LoadQuestionsService questionsService;

    /**
     * Konstruktor-Injection des Services.
     *
     * @param questionsService Service für Fragen
     */
    public LoadQuestionsController(LoadQuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    /**
     * Liefert alle Fragen aus der Datenbank.
     *
     * GET /api/question
     *
     * @return Liste aller Fragen
     */
    @GetMapping
    public ResponseEntity<List<Questions>> getAllQuestions() {
        List<Questions> questions = questionsService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    /**
     * Legt eine neue Frage an.
     *
     * POST /api/question
     *
     * @param question Frage-Objekt im Request-Body
     * @return erstellte Frage mit HTTP 201
     */
    @PostMapping
    public ResponseEntity<Questions> createQuestion(@RequestBody Questions question) {
        Questions saved = questionsService.saveQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
