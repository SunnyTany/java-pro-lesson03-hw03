package app;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TemperatureConverter {

    private static final int HISTORY_LIMIT = 100;
    private static final double ABSOLUTE_ZERO_C = -273.15;
    private static final double ABSOLUTE_ZERO_F = -459.67;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> history = new LinkedList<>();

        while (true) {
            System.out.println("\n--- Temperature Converter Menu ---");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Celsius to Kelvin");
            System.out.println("4. Kelvin to Celsius");
            System.out.println("5. View History");
            System.out.println("6. Clear History");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            if (choice == 0) {
                System.out.println("Exiting the application. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Celsius: ");
                    double c1 = scanner.nextDouble();
                    if (c1 < ABSOLUTE_ZERO_C) {
                        System.out.println("Error: Temperature below absolute zero!");
                    } else {
                        double f1 = (c1 * 9 / 5) + 32;
                        saveToHistory(history, String.format("%.2f °C = %.2f °F", c1, f1));
                        System.out.printf("Result: %.2f °F%n", f1);
                    }
                    break;

                case 2:
                    System.out.print("Enter Fahrenheit: ");
                    double f2 = scanner.nextDouble();
                    if (f2 < ABSOLUTE_ZERO_F) {
                        System.out.println("Error: Temperature below absolute zero!");
                    } else {
                        double c2 = (f2 - 32) * 5 / 9;
                        saveToHistory(history, String.format("%.2f °F = %.2f °C", f2, c2));
                        System.out.printf("Result: %.2f °C%n", c2);
                    }
                    break;

                case 3:
                    System.out.print("Enter Celsius: ");
                    double c3 = scanner.nextDouble();
                    if (c3 < ABSOLUTE_ZERO_C) {
                        System.out.println("Error: Temperature below absolute zero!");
                    } else {
                        double k3 = c3 - ABSOLUTE_ZERO_C;
                        saveToHistory(history, String.format("%.2f °C = %.2f K", c3, k3));
                        System.out.printf("Result: %.2f K%n", k3);
                    }
                    break;

                case 4:
                    System.out.print("Enter Kelvin: ");
                    double k4 = scanner.nextDouble();
                    if (k4 < 0) {
                        System.out.println("Error: Kelvin cannot be negative!");
                    } else {
                        double c4 = k4 + ABSOLUTE_ZERO_C;
                        saveToHistory(history, String.format("%.2f K = %.2f °C", k4, c4));
                        System.out.printf("Result: %.2f °C%n", c4);
                    }
                    break;

                case 5:
                    printHistory(history);
                    break;

                case 6:
                    history.clear();
                    System.out.println("History has been cleared.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    private static void saveToHistory(List<String> history, String entry) {
        if (history.size() >= HISTORY_LIMIT) {
            history.remove(0);
        }
        history.add(entry);
    }

    private static void printHistory(List<String> history) {
        System.out.println("\n--- Operation History ---");
        if (history.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            int i = 1;
            for (String entry : history) {
                System.out.println(i++ + ". " + entry);
            }
        }
    }
}