package com.westendsgeschichte.service;

import com.westendsgeschichte.dto.LeaderboardEntryDto;
import com.westendsgeschichte.dto.SaveScoreRequest;
import com.westendsgeschichte.model.Leaderboard;
import com.westendsgeschichte.repository.LeaderboardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Service für die Leaderboard-Logik.
 * Verwaltet das Speichern von Scores und die Rangberechnung.
 */
@Service
public class LeaderboardService {

    private final LeaderboardRepository leaderboardRepository;

    /**
     * Konstruktor-Injection des Repositories.
     *
     * @param leaderboardRepository Repository für Leaderboard-Einträge
     */
    public LeaderboardService(LeaderboardRepository leaderboardRepository) {
        this.leaderboardRepository = leaderboardRepository;
    }

    /**
     * Speichert das Quiz-Ergebnis eines Nutzers.
     *
     * @param request Request mit Benutzername und Score
     * @return gespeicherter Leaderboard-Eintrag
     */
    public Leaderboard saveScore(SaveScoreRequest request) {
        Leaderboard entry = new Leaderboard(
            request.getUsername(),
            request.getScore(),
            LocalDateTime.now()
        );
        return leaderboardRepository.save(entry);
    }

    /**
     * Liefert das vollständige Leaderboard mit Rangplätzen.
     * Bei Punktgleichheit entscheidet das frühere Datum.
     *
     * @return sortierte Liste mit Rangplätzen
     */
    public List<LeaderboardEntryDto> getFullLeaderboard() {
        List<Leaderboard> sorted = leaderboardRepository.findAllSorted();
        return assignRanks(sorted);
    }

    /**
     * Liefert die Top-3-Einträge mit Rangplätzen.
     *
     * @return Top-3-Liste
     */
    public List<LeaderboardEntryDto> getTop3() {
        List<Leaderboard> top3 = leaderboardRepository.findTop3();
        return assignRanks(top3);
    }

    /**
     * Ermittelt den aktuellen Rang eines Spielers anhand seines besten Scores.
     * Zählt, wie viele Einträge einen höheren Score (oder gleichen Score
     * mit früherem Datum) besitzen.
     *
     * @param username Benutzername
     * @return Rang (1-basiert) oder -1, falls Nutzer nicht gefunden
     */
    public int getPlaceByUsername(String username) {
        Leaderboard best = leaderboardRepository
            .findBestByUsername(username)
            .orElse(null);

        if (best == null) return -1;

        List<Leaderboard> all = leaderboardRepository.findAllSorted();

        // Rang = Position in der sortierten Liste (1-basiert)
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId().equals(best.getId())) {
                return i + 1;
            }
        }
        return -1;
    }

    // ──────────────────────────────────────────────
    // Hilfsmethoden
    // ──────────────────────────────────────────────

    /**
     * Weist einer sortierten Liste von Leaderboard-Einträgen Rangplätze zu.
     * Einträge mit identischer Punktzahl erhalten denselben Rang.
     *
     * @param entries sortierte Einträge
     * @return Liste mit Rangplätzen
     */
    private List<LeaderboardEntryDto> assignRanks(List<Leaderboard> entries) {
        List<LeaderboardEntryDto> result = new ArrayList<>();
        int rank     = 1;
        int position = 1;

        for (int i = 0; i < entries.size(); i++) {
            Leaderboard entry = entries.get(i);

            // Neuen Rang setzen, wenn Score sich ändert
            if (i > 0 && entry.getScore() < entries.get(i - 1).getScore()) {
                rank = position;
            }

            result.add(new LeaderboardEntryDto(
                rank,
                entry.getUsername(),
                entry.getScore(),
                entry.getAchievedAt()
            ));

            position++;
        }

        return result;
    }
}
