public class Main {
    public static void main(String[] args) {

        System.out.println(" Бег и плавание животных \n");

        Dog dogVasya = new Dog("Вася");
        Dog dogKolya = new Dog("Коля");
        Cat catArtem = new Cat("Артем");
        Cat catSanya = new Cat("Саня");

        dogVasya.run(150);
        dogKolya.run(600);
        catArtem.run(100);
        catSanya.run(250);

        System.out.println();

        dogVasya.swim(5);
        dogKolya.swim(15);
        catArtem.swim(3);
        catSanya.swim(3);

        System.out.println("\n Статистика созданных животных ");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());


        System.out.println("\n Коты и миска с едой \n");


        Bowl bowl = new Bowl(5);
        bowl.displayInfo();

        System.out.println("\n Коты пытаются покушать ");

        catArtem.eat(bowl, 3);
        bowl.displayInfo();

        catSanya.eat(bowl, 3);
        bowl.displayInfo();

        System.out.println("\n Информация о сытости котов ");
        System.out.println(catArtem.name + ": " + (catArtem.isFull() ? "сыт" : "голоден"));
        System.out.println(catSanya.name + ": " + (catSanya.isFull() ? "сыт" : "голоден"));

        System.out.println("\n Добавляем еду в миску (10 единиц) ");
        bowl.addFood(10);
        bowl.displayInfo();

        System.out.println("\n Саня пробует поесть снова ");
        catSanya.eat(bowl, 3);
        bowl.displayInfo();

        System.out.println("\n Итоговая информация о сытости котов ");
        System.out.println(catArtem.name + ": " + (catArtem.isFull() ? "сыт" : "голоден"));
        System.out.println(catSanya.name + ": " + (catSanya.isFull() ? "сыт" : "голоден"));

        System.out.println("\n Финальная статистика ");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());
    }
}