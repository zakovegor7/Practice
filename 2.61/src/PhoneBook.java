import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class PhoneBook {

    private Map<String, List<String>> book = new HashMap<>();

    public void add(String surname, String phone) {
        book.putIfAbsent(surname, new ArrayList<>());
        book.get(surname).add(phone);
    }
    public List<String> get(String surname) {
        return book.getOrDefault(surname, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Салимов", "+7-900-111-11-11");
        phoneBook.add("Петухов", "+7-900-222-22-22");
        phoneBook.add("Салимов", "+7-900-333-33-33"); // Второй Салимов
        phoneBook.add("Семкин", "+7-900-444-44-44");
        phoneBook.add("Алешин", "+7-900-555-55-55");

        System.out.println("Телефоны Cалимов: " + phoneBook.get("Салимов"));
        System.out.println("Телефоны Петухов: " + phoneBook.get("Петухов"));
        System.out.println("Телефоны Семкин: " + phoneBook.get("Семкин"));
        System.out.println("Телефоны Кузнецов: " + phoneBook.get("Кузнецов")); // Такой фамилии нет
    }
}