package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {
    private String correctAnswer;
    private Map<String, String> players = new HashMap<>();

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Map<String, String> getPlayers() {
        return new HashMap<>(players);
    }

    public void readFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            correctAnswer = br.readLine();
            while ((line = br.readLine()) != null) {
                savePlayerData(line);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file.", ioe);
        }
    }

    public boolean gaveCorrectAnswer(String id, int question) {
        String correct = String.valueOf(correctAnswer.charAt(question - 1));
        String playerAnswer = String.valueOf(players.get(id).charAt(question - 1));
        return correct.equals(playerAnswer);
    }

    public String playerWithMostPoints() {
        List<String> playerList = new ArrayList<>(players.keySet());
        String winner = playerList.get(0);
        for (String actual : playerList) {
            if (getPlayerPoints(actual) > getPlayerPoints(winner)) {
                winner = actual;
            }
        }
        return winner;
    }

    public int getPlayerPoints(String playerId) {
        int points = 0;
        for (int i = 0; i < correctAnswer.length(); i++) {
            if (correctAnswer.charAt(i) == players.get(playerId).charAt(i)) {
                points += (i + 1);
            } else if ('X' != players.get(playerId).charAt(i)) {
                points -= 2;
            }
        }
        return points;
    }

    private void savePlayerData(String input) {
        String key = input.split(" ")[0];
        String newValue = input.split(" ")[1];
        if (!players.containsKey(key)) {
            players.put(key, newValue);
        } else {
            players.put(key, players.get(key) + newValue);
        }
    }
}
