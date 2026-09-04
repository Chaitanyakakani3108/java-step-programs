package string.class_problems;

import java.util.Scanner;

public class Palindrome {

    // Method 1: Iterative approach
    static boolean iterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        // Compare characters from both ends
        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Method 2: Recursive approach
    static boolean recursive(String text) {

        // Base condition
        if (text.length() <= 1) {
            return true;
        }

        // Compare first and last characters
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        // Check remaining substring
        return recursive(text.substring(1, text.length() - 1));
    }

    // Method 3: Array reversal approach
    static boolean arrayReverse(String text) {

        // Convert string into character array
        char[] original = text.toCharArray();

        // Create array for reversed string
        char[] reverse = new char[original.length];

        // Reverse the characters
        for (int i = 0; i < original.length; i++) {
            reverse[i] = original[original.length - 1 - i];
        }

        // Compare original and reversed strings
        return new String(original).equals(new String(reverse));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // Test using all three methods
        System.out.println("Iterative: " +
                (iterative(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (recursive(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (arrayReverse(text) ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}