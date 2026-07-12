public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        if (foodAmount < 0) {
            this.foodAmount = 0;
        } else {
            this.foodAmount = foodAmount;
        }
    }

    public boolean decreaseFood(int amount) {
        if (amount < 0) {
            return false;
        }
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println(" Eды добавлено в миску = " + amount + " Еды в миске = " + foodAmount);
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void displayInfo() {
        System.out.println("В миске " + foodAmount + " еды");
    }
}
