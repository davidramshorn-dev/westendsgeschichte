package com.westendsgeschichte.controller;

import com.westendsgeschichte.dto.LeaderboardEntryDto;
import com.westendsgeschichte.dto.SaveScoreRequest;
import com.westendsgeschichte.model.Leaderboard;
import com.westendsgeschichte.service.LeaderboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST-Controller für das Leaderboard.
 * Stellt Endpunkte zum Speichern und Abrufen von Scores bereit.
 */
@RestController
@RequestMapping("/api/leaderboard")
@CrossOrigin(origins = "*")
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    /**
     * Konstruktor-Injection des Services.
     *
     * @param leaderboardService Service für das Leaderboard
     */
    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    /**
     * Speichert das Quiz-Ergebnis eines Nutzers.
     *
     * POST /api/leaderboard
     *
     * @param request Request-Body mit Benutzername und Score
     * @return gespeicherter Eintrag mit HTTP 201
     */
    @PostMapping
    public ResponseEntity<Leaderboard> saveScore(@RequestBody SaveScoreRequest request) {
        Leaderboard saved = leaderboardService.saveScore(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * Liefert das vollständige Leaderboard sortiert nach Score.
     *
     * GET /api/leaderboard
     *
     * @return sortierte Leaderboard-Liste mit Rangplätzen
     */
    @GetMapping
    public ResponseEntity<List<LeaderboardEntryDto>> getLeaderboard() {
        return ResponseEntity.ok(leaderboardService.getFullLeaderboard());
    }

    /**
     * Liefert die Top-3-Einträge.
     *
     * GET /api/leaderboard/top3
     *
     * @return Top-3-Liste
     */
    @GetMapping("/top3")
    public ResponseEntity<List<LeaderboardEntryDto>> getTop3() {
        return ResponseEntity.ok(leaderboardService.getTop3());
    }

    /**
     * Liefert den Rang eines bestimmten Spielers.
     *
     * GET /api/leaderboard/place/{username}
     *
     * @param username Benutzername als Pfadvariable
     * @return JSON-Objekt mit Rang oder 404, falls nicht gefunden
     */
    @GetMapping("/place/{username}")
    public ResponseEntity<Map<String, Integer>> getPlace(
            @PathVariable String username) {

        int place = leaderboardService.getPlaceByUsername(username);

        if (place == -1) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Map.of("place", place));
    }
}
