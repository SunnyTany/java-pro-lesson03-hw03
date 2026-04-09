package app;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        double tempC = 25.0;
        double tempF = 77.0;

        System.out.println(tempC + "°C = " + celsiusToFahrenheit(tempC) + "°F");
        System.out.println(tempF + "°F = " + fahrenheitToCelsius(tempF) + "°C");
    }
}