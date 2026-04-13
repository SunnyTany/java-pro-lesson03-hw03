package app;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        History hm = new History();
        Menu mh = new Menu();

        while (true) {
            mh.printMenu();
            if (!scanner.hasNextInt()) {
                System.out.println("Error: Not a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            if (choice == 0) break;

            processChoice(choice, scanner, hm, mh);
        }
        scanner.close();
    }

    private static void processChoice(int choice, Scanner sc, History hm, Menu mh) {
        try {
            double in, res;
            switch (choice) {
                case 1:
                    in = mh.getInput("Celsius", sc);
                    res = CalculationEngine.toFahrenheit(in);
                    hm.record(String.format("%.2f °C = %.2f °F", in, res));
                    break;
                case 2:
                    in = mh.getInput("Fahrenheit", sc);
                    res = CalculationEngine.toCelsiusFromF(in);
                    hm.record(String.format("%.2f °F = %.2f °C", in, res));
                    break;
                case 3:
                    in = mh.getInput("Celsius", sc);
                    res = CalculationEngine.toKelvin(in);
                    hm.record(String.format("%.2f °C = %.2f K", in, res));
                    break;
                case 4:
                    in = mh.getInput("Kelvin", sc);
                    res = CalculationEngine.toCelsiusFromK(in);
                    hm.record(String.format("%.2f K = %.2f °C", in, res));
                    break;
                case 5: hm.printHistory(); break;
                case 6: hm.clear(); break;
                default: System.out.println("Invalid option.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}