// TASK 2 - WORD COUNTER
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Wordcounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text or provide a file path:");
        String userInput = scanner.nextLine();

        if (userInput.toLowerCase().equals("file")) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            processFileInput(filePath);
        } else {
            processTextInput(userInput);
        }

        scanner.close();
    }

    private static void processTextInput(String text) {
        String[] words = text.split("\\s+|\\p{Punct}+");
        int wordCount = words.length;
        displayStatistics(words, wordCount);
    }

    private static void processFileInput(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append(" ");
            }

            String text = sb.toString().trim();
            String[] words = text.split("\\s+|\\p{Punct}+");
            int wordCount = words.length;
            displayStatistics(words, wordCount);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static void displayStatistics(String[] words, int wordCount) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("Total words: " + wordCount);
        System.out.println("Unique words: " + wordFrequency.size());

        System.out.println("\nWord frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

