package com.westendsgeschichte.model;

import jakarta.persistence.*;

/**
 * Entität für eine Quiz-Frage.
 * Jede Frage besitzt drei Antwortmöglichkeiten und den Index der richtigen Antwort.
 */
@Entity
@Table(name = "questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Der Fragetext */
    @Column(nullable = false, length = 500)
    private String question;

    /** Erste Antwortmöglichkeit */
    @Column(nullable = false, length = 255)
    private String answer1;

    /** Zweite Antwortmöglichkeit */
    @Column(nullable = false, length = 255)
    private String answer2;

    /** Dritte Antwortmöglichkeit */
    @Column(nullable = false, length = 255)
    private String answer3;

    /**
     * Index der richtigen Antwort (1, 2 oder 3).
     * Entspricht answer1, answer2 oder answer3.
     */
    @Column(nullable = false)
    private int correctAnswer;

    // ──────────────────────────────────────────────
    // Konstruktoren
    // ──────────────────────────────────────────────

    public Questions() {}

    public Questions(String question, String answer1, String answer2,
                     String answer3, int correctAnswer) {
        this.question      = question;
        this.answer1       = answer1;
        this.answer2       = answer2;
        this.answer3       = answer3;
        this.correctAnswer = correctAnswer;
    }

    // ──────────────────────────────────────────────
    // Getter & Setter
    // ──────────────────────────────────────────────

    public Long getId()                    { return id; }
    public void setId(Long id)             { this.id = id; }

    public String getQuestion()            { return question; }
    public void setQuestion(String q)      { this.question = q; }

    public String getAnswer1()             { return answer1; }
    public void setAnswer1(String a)       { this.answer1 = a; }

    public String getAnswer2()             { return answer2; }
    public void setAnswer2(String a)       { this.answer2 = a; }

    public String getAnswer3()             { return answer3; }
    public void setAnswer3(String a)       { this.answer3 = a; }

    public int getCorrectAnswer()          { return correctAnswer; }
    public void setCorrectAnswer(int c)    { this.correctAnswer = c; }
}
