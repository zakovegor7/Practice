package main;

public class Triangle{
    public static double calculate(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Величины должны быть положительными");
        }
        return 0.5 * base * height;
    }
}