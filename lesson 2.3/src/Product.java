public class Product {
    String name;
    String productionDate;
    String manufacturer;
    String countryOfOrigin;
    int price;
    Boolean bookingStatus;

    public Product(String name, String productionDate, String manufacturer,
                              String countryOfOrigin, int price, Boolean bookingStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }


    public void show() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Статус бронирования: " + bookingStatus);

    }
}





