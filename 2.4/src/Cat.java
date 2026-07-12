public class Cat extends Animal {
    private static int catCount = 0;
   private boolean catIsfull;

    public Cat(String name) {
        super(name);
        this.runLimit = 200;
        this.swimLimit = 0;
        this.catIsfull = false;
        catCount++;

    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            catIsfull = true;
            System.out.println("Kот поел " + amount + " еды");
        } else {
            System.out.println("Кот не поел т.к. не хватило еды");
        }

    }

    public boolean isFull() {
        return catIsfull;
    }

    public static int getCatCount() {
        return catCount;


    }
}
