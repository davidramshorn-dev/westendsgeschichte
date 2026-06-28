package com.westendsgeschichte.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entität für einen Leaderboard-Eintrag.
 * Speichert Benutzername, Punktzahl und Zeitpunkt des Eintrags.
 */
@Entity
@Table(name = "leaderboard")
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Benutzername des Spielers */
    @Column(nullable = false, length = 100)
    private String username;

    /** Erreichte Punktzahl */
    @Column(nullable = false)
    private int score;

    /** Zeitpunkt des Quiz-Abschlusses */
    @Column(nullable = false)
    private LocalDateTime achievedAt;

    // ──────────────────────────────────────────────
    // Konstruktoren
    // ──────────────────────────────────────────────

    public Leaderboard() {}

    public Leaderboard(String username, int score, LocalDateTime achievedAt) {
        this.username   = username;
        this.score      = score;
        this.achievedAt = achievedAt;
    }

    // ──────────────────────────────────────────────
    // Getter & Setter
    // ──────────────────────────────────────────────

    public Long getId()                          { return id; }
    public void setId(Long id)                   { this.id = id; }

    public String getUsername()                  { return username; }
    public void setUsername(String username)     { this.username = username; }

    public int getScore()                        { return score; }
    public void setScore(int score)              { this.score = score; }

    public LocalDateTime getAchievedAt()                   { return achievedAt; }
    public void setAchievedAt(LocalDateTime achievedAt)    { this.achievedAt = achievedAt; }
}
