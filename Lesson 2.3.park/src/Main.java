public class Main {
    public static void main(String[] args) {

        Park park = new Park();

        Park.Attraction a1 = park.new Attraction("Полет на метле", "10:00-20:00", 450);
        Park.Attraction a2 = park.new Attraction("Квантовый тоннель", "11:00-22:00", 600);
        Park.Attraction a3 = park.new Attraction("Зеркальный лабиринт", "09:00-21:00", 350);
        Park.Attraction a4 = park.new Attraction("Путешествие во времени", "12:00-23:00", 700);
        Park.Attraction a5 = park.new Attraction("Левитация-парк", "10:00-19:00", 500);


        System.out.println("=== АТТРАКЦИОНЫ ===\n");

        a1.show();
        a2.show();
        a3.show();
        a4.show();
        a5.show();
    }
}