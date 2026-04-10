package app;

public class CalculationEngine {
    public static final double ABSOLUTE_ZERO_C = -273.15;
    public static final double ABSOLUTE_ZERO_F = -459.67;

    public static double toFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double toCelsiusFromF(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double toKelvin(double celsius) {
        return celsius - ABSOLUTE_ZERO_C;
    }

    public static double toCelsiusFromK(double kelvin) {
        return kelvin + ABSOLUTE_ZERO_C;
    }

    public static boolean isValid(double value, double min) {
        if (value < min) {
            System.out.println("Error: Temperature cannot be below absolute zero!");
            return false;
        }
        return true;
    }
}