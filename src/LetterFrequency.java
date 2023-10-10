import java.util.HashMap;
import java.util.Map;

public class LetterFrequency {
    public static void main(String[] args) {

        String text = "Этот текст содержит некоторые буквы.";
        Map<Character, Integer> frequencyMap = buildLetterFrequency(text);

        System.out.println("Частотный словарь букв:");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static Map<Character, Integer> buildLetterFrequency(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        text = text.toLowerCase();

        text = text.replaceAll("[^a-zA-Zа-яА-Я]", "");

        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        return frequencyMap;
    }
}
