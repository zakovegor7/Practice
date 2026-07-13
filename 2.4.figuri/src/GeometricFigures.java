import java.awt.*;
public class GeometricFigures {
    public static void main(String[] args) {
        // Создание фигур с различными цветами
        Shape circle = new Circle(2.0, Color.RED, Color.BLUE);
        Shape rectangle = new Rectangle(6.0, 4.0, Color.BLUE, Color.GREEN);
        Shape triangle = new Triangle(3.0, 4.0, 5.0, Color.GREEN, Color.YELLOW);

        circle.printCharacteristics();
        rectangle.printCharacteristics();
        triangle.printCharacteristics();
    }
}
