package string.class_problems;

import java.util.Scanner;

public class ReverseName {

    static String reverse(String name) {

        StringBuilder result = new StringBuilder();

        for (int i = name.length() - 1; i >= 0; i--) {
            result.append(name.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reverse(name));

        sc.close();
    }
}