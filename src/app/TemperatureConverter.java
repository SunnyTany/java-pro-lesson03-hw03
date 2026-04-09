package app;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TemperatureConverter {
    // Limit history
    private static final int HISTORY_LIMIT = 100;
    // Absolute zero
    private static final double ABSOLUTE_ZERO_C = -273.15;
    private static final double ABSOLUTE_ZERO_F = -459.67;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> history = new LinkedList<>();

        while (true) {
            printMenu();

            // Check input
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a valid menu number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            // Exit program
            if (choice == 0) break;

            processChoice(choice, scanner, history);
        }

        System.out.println("Exiting the application. Goodbye!");
        scanner.close();
    }

    // Display menu
    private static void printMenu() {
        System.out.println("\n--- Temperature Converter Menu ---");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. View History");
        System.out.println("6. Clear History");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    // Menu options
    private static void processChoice(int choice, Scanner scanner, List<String> history) {
        double input, result;

        switch (choice) {
            case 1: // C => F
                input = getInput("Celsius", scanner);
                if (isValid(input, ABSOLUTE_ZERO_C)) {
                    result = (input * 9 / 5) + 32;
                    record(history, String.format("%.2f °C = %.2f °F", input, result));
                }
                break;

            case 2: // F => C
                input = getInput("Fahrenheit", scanner);
                if (isValid(input, ABSOLUTE_ZERO_F)) {
                    result = (input - 32) * 5 / 9;
                    record(history, String.format("%.2f °F = %.2f °C", input, result));
                }
                break;

            case 3: // C => K
                input = getInput("Celsius", scanner);
                if (isValid(input, ABSOLUTE_ZERO_C)) {
                    result = input - ABSOLUTE_ZERO_C;
                    record(history, String.format("%.2f °C = %.2f K", input, result));
                }
                break;

            case 4: // K => C
                input = getInput("Kelvin", scanner);
                if (isValid(input, 0)) {
                    result = input + ABSOLUTE_ZERO_C;
                    record(history, String.format("%.2f K = %.2f °C", input, result));
                }
                break;

            case 5: // Show history
                printHistory(history);
                break;

            case 6: // Wipe history
                history.clear();
                System.out.println("History has been cleared.");
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Prompt user
    private static double getInput(String label, Scanner scanner) {
        System.out.print("Enter " + label + ": ");
        return scanner.nextDouble();
    }

    // Validate temperature
    private static boolean isValid(double value, double min) {
        if (value < min) {
            System.out.println("Error: Temperature cannot be below absolute zero!");
            return false;
        }
        return true;
    }

    // Add result to history
    private static void record(List<String> history, String entry) {
        if (history.size() >= HISTORY_LIMIT) {
            history.remove(0); // Efficient O(1) removal with LinkedList
        }
        history.add(entry);
        System.out.println("_________________");
        System.out.println("Result: " + entry);
        System.out.println("_________________");
    }

    //Print history list
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