package app;

public class CalculationEngine {
    private static final double ABSOLUTE_ZERO_C = -273.15;
    private static final double ABSOLUTE_ZERO_F = -459.67;
    private static final double ABSOLUTE_ZERO_K = 0;

    public static double toFahrenheit(double celsius) {
        isValid(celsius, ABSOLUTE_ZERO_C, "°C");
        return (celsius * 9 / 5) + 32;
    }

    public static double toCelsiusFromF(double fahrenheit) {
        isValid(fahrenheit, ABSOLUTE_ZERO_F, "°F");
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double toKelvin(double celsius) {
        isValid(celsius, ABSOLUTE_ZERO_C, "°C");
        return celsius - ABSOLUTE_ZERO_C;
    }

    public static double toCelsiusFromK(double kelvin) {
        isValid(kelvin, ABSOLUTE_ZERO_K, "°K");
        return kelvin + ABSOLUTE_ZERO_C;
    }

    private static void isValid(double value, double min, String unit) {
        if (value < min) {
            throw new IllegalArgumentException(
                    String.format("Temperature cannot be below absolute zero (Min: %.2f %s)!", min, unit)
            );
        }
    }
}