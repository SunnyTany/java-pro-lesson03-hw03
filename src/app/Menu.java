package app;

import java.util.Scanner;

public class Menu {
    public void printMenu() {
        System.out.println("\n--- Temperature Converter Menu ---");
        System.out.println("1. Celsius to Fahrenheit\n2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin\n4. Kelvin to Celsius");
        System.out.println("5. View History\n6. Clear History\n0. Exit");
        System.out.print("Select an option: ");
    }

    public double getInput(String label, Scanner scanner) {
        System.out.print("Enter " + label + ": ");
        return scanner.nextDouble();
    }
}