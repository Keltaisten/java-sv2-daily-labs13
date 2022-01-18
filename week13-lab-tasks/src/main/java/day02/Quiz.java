package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Quiz {
    private String goodAnswers;
    private Map<String, String> contestants = new HashMap<>();

    public Quiz(Path path) {
        readCompetitionData(path);
    }

    private void readCompetitionData(Path path) {
        try (BufferedReader bf = Files.newBufferedReader(path)) {
            goodAnswers = bf.readLine();
            while (bf.ready()) {
                putDataToContestants(bf.readLine());
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot read file!");
        }
    }

    private void putDataToContestants(String readLine) {
        String[] fields = readLine.split(" ");
        String contestant = fields[0];
        if (contestants.containsKey(contestant)) {
            contestants.replace(contestant, contestants.get(contestant).concat(fields[1]));
        } else {
            contestants.put(contestant, fields[1]);
        }
    }

    public boolean isAnswerCorrect(String contestant, int number) {
        return contestants.get(contestant).charAt(number - 1) == goodAnswers.charAt(number - 1);
    }

    private int getContestantTotalPoints(String code) {
        int points = 0;
        for (int i = 0; i < contestants.get(code).length(); i++) {
            if (contestants.get(code).charAt(i) == goodAnswers.charAt(i)) {
                points++;
            } else if (contestants.get(code).charAt(i) != 'X') {
                points -= 2;
            }
        }
        return points;
    }

    public String getWinner() {
        String winner = null;
        int maxPoints = 0;
        for(String code : contestants.keySet()){
            int actualPoints = getContestantTotalPoints(code);
            if(maxPoints < actualPoints){
                maxPoints = actualPoints;
                winner = code;

            }
        }
        if(winner == null){
            throw new IllegalArgumentException("No winner!");
        }
        return winner;
    }

    public Map<String, String> getContestants() {
        return contestants;
    }

}
