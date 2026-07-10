public class Main {
    public static void main(String[] args) {

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Toyota Camry", "15.03.2024",
                "Toyota", "Japan", 3500000, true);

        productsArray[1] = new Product("BMW X5", "20.01.2024",
                "BMW", "Germany", 6500000, false);

        productsArray[2] = new Product("Mercedes-Benz E-Class", "10.02.2024",
                "Mercedes", "Germany", 5800000, false);

        productsArray[3] = new Product("Lada Vesta", "05.04.2024",
                "VAZ", "Russia", 1500000, true);

        productsArray[4] = new Product("Hyundai Solaris", "25.03.2024",
                "Hyundai", "South Korea", 2200000, false);

        System.out.println("СПИСОК АВТОМОБИЛЕЙ\n");

        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Автомобиль №" + (i + 1) + ":");
            productsArray[i].show();
        }
    }
}