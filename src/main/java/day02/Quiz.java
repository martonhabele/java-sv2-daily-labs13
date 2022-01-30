package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class Quiz {

    private String correctAnswers = "";
    private Map<String, String> results = new TreeMap<>();

    public void readAllLines(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(fileName))) {
            correctAnswers = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(" ");
                if (!results.containsKey(temp[0])) {
                    results.put(temp[0], temp[1]);
                } else {
                    results.put(temp[0], results.get(temp[0]) + temp[1]);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot reach file", e);
        }
    }

    private String getWinner() {
        int maxresult = 0;
        String winner = "";
        for (Map.Entry<String, String> entry : results.entrySet()) {
            int cp = calculatePoints(entry.getValue());
            if (cp > maxresult) {
                maxresult = cp;
                winner = entry.getKey();
            }
        }
        return winner;
    }

    private int calculatePoints(String result) {
        int points = 0;
        for (int i = 0; i < correctAnswers.length(); i++) {
            if (correctAnswers.charAt(i) == result.charAt(i)) {
                points = points + i;
            } else if("X".equals(result.charAt(i))) {

            } else {
                points = points - 2;
            }
        }
        return points;
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.readAllLines("src/main/resources/result.txt");
        System.out.println(quiz.getWinner());
    }

}