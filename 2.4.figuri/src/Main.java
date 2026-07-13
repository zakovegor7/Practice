import java.awt.Color;

interface Shape {
    double getArea();
    double getPerimeter();
    Color getFillColor();
    Color getBorderColor();

    default void printCharacteristics() {
        System.out.println("=== " + getClass().getSimpleName() + " ===");
        System.out.println("Периметр: " + String.format("%.2f", getPerimeter()));
        System.out.println("Площадь: " + String.format("%.2f", getArea()));
        System.out.println("Цвет заливки: " + getColorName(getFillColor()));
        System.out.println("Цвет границы: " + getColorName(getBorderColor()));
        System.out.println();
    }

    // Вспомогательный метод для преобразования Color в читаемое название
    default String getColorName(Color color) {
        if (color == Color.RED) return "Красный";
        if (color == Color.BLUE) return "Синий";
        if (color == Color.GREEN) return "Зеленый";
        if (color == Color.YELLOW) return "Желтый";
        return "Пользовательский цвет (RGB: " + color.getRed() + ","
                + color.getGreen() + "," + color.getBlue() + ")";
    }
}

class Circle implements Shape {
    private double radius;
    private Color fillColor;
    private Color borderColor;

    public Circle(double radius, Color fillColor, Color borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    public Color getFillColor() {
        return fillColor;
    }
    public Color getBorderColor() {
        return borderColor;
    }
}
class Rectangle implements Shape {
    private double width;
    private double height;
    private Color fillColor;
    private Color borderColor;

    public Rectangle(double width, double height, Color fillColor, Color borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return 2 * (width + height);
    }
    public Color getFillColor() {
        return fillColor;
    }
    public Color getBorderColor() {
        return borderColor;
    }
}

class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private Color fillColor;
    private Color borderColor;

    public Triangle(double sideA, double sideB, double sideC,
                    Color fillColor, Color borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    public Color getFillColor() {
        return fillColor;
    }
    public Color getBorderColor() {
        return borderColor;
    }
}

