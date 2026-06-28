package com.westendsgeschichte.dto;

/**
 * Request-Body für das Speichern eines Quiz-Ergebnisses.
 */
public class SaveScoreRequest {

    private String username;
    private int score;

    public SaveScoreRequest() {}

    public String getUsername()              { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getScore()                    { return score; }
    public void setScore(int score)          { this.score = score; }
}
