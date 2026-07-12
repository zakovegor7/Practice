public abstract class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    private static int animalCount=0;

    public Animal(String name){
        this.name=name;
        animalCount++;
    }
    public void run(int distance){
        if(distance>runLimit){
            System.out.println(name+" не пробежал");
        }
        else {
            System.out.println(name+" пробежал успешно");
        }
    }

    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " не умееет плавать");
        } else if (swimLimit < distance) {
            System.out.println(name + " не проплыл");
        } else {
            System.out.println(name + " успешно проплыл");
        }
    }
            public static int getAnimalCount() {
            return animalCount;
    }
}
