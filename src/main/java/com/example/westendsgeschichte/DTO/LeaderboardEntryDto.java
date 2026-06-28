package com.westendsgeschichte.dto;

import java.time.LocalDateTime;

/**
 * Data Transfer Object für einen Leaderboard-Eintrag mit Rangplatz.
 * Wird an das Frontend gesendet.
 */
public class LeaderboardEntryDto {

    private int rank;
    private String username;
    private int score;
    private LocalDateTime achievedAt;

    public LeaderboardEntryDto() {}

    public LeaderboardEntryDto(int rank, String username,
                                int score, LocalDateTime achievedAt) {
        this.rank       = rank;
        this.username   = username;
        this.score      = score;
        this.achievedAt = achievedAt;
    }

    public int getRank()                         { return rank; }
    public void setRank(int rank)                { this.rank = rank; }

    public String getUsername()                  { return username; }
    public void setUsername(String username)     { this.username = username; }

    public int getScore()                        { return score; }
    public void setScore(int score)              { this.score = score; }

    public LocalDateTime getAchievedAt()                   { return achievedAt; }
    public void setAchievedAt(LocalDateTime achievedAt)    { this.achievedAt = achievedAt; }
}
