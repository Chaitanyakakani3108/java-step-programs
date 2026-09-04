package string.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueCharacter {

    static char findFirst(String text) {

        Map<Character, Integer> count = new HashMap<>();

        for (char ch : text.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (char ch : text.toCharArray()) {

            if (count.get(ch) == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char result = findFirst(text);

        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println(
                    "First Non-Repeating Character: " + result);
        }

        sc.close();
    }
}