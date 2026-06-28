package com.westendsgeschichte.repository;

import com.westendsgeschichte.model.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository für den Datenbankzugriff auf das Leaderboard.
 */
@Repository
public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {

    /**
     * Liefert alle Einträge sortiert nach Score absteigend,
     * bei Gleichstand nach Datum aufsteigend (früheres Datum = besser).
     *
     * @return sortierte Leaderboard-Liste
     */
    @Query("SELECT l FROM Leaderboard l ORDER BY l.score DESC, l.achievedAt ASC")
    List<Leaderboard> findAllSorted();

    /**
     * Liefert die drei besten Einträge.
     *
     * @return Top-3-Liste
     */
    @Query("SELECT l FROM Leaderboard l ORDER BY l.score DESC, l.achievedAt ASC LIMIT 3")
    List<Leaderboard> findTop3();

    /**
     * Sucht den besten Eintrag eines bestimmten Benutzers.
     *
     * @param username Benutzername
     * @return Optional mit dem besten Eintrag des Nutzers
     */
    @Query("SELECT l FROM Leaderboard l WHERE l.username = :username " +
           "ORDER BY l.score DESC, l.achievedAt ASC LIMIT 1")
    Optional<Leaderboard> findBestByUsername(@Param("username") String username);
}
