import java.util.ArrayList;
import java.util.Random;

public class FoodHandler {
    private ArrayList<TheaterFood> menu;
    private Random random;

    public FoodHandler() {
        menu = new ArrayList<>();
        random = new Random();
        initializeMenu();
    }

    private void initializeMenu() {
        menu.add(new TheaterFood("Popcorn", 5.99, "Large"));
        menu.add(new TheaterFood("Nachos", 4.99, "Regular"));
        menu.add(new TheaterFood("Hot Dog", 3.49, "Regular"));
        menu.add(new TheaterFood("Soda", 2.99, "Medium"));
        menu.add(new TheaterFood("Candy", 1.99, "Small"));
    }

    public boolean handleInput(String input) {
        if (input.contains("menu")) {
            showMenu();
            return true;
        } else if (input.contains("recommend")) {
            recommendFood();
            return true;
        }
        return false;
    }

    private void showMenu() {
        if (menu.isEmpty()) {
            System.out.println("MovieBot: Sorry, the menu is currently empty.");
            return;
        }
        System.out.println("MovieBot: Here's the menu:");
        for (TheaterFood item : menu) {
            System.out.println(" - " + item);
        }
    }

    private void recommendFood() {
        if (menu.isEmpty()) {
            System.out.println("MovieBot: Sorry, the menu is currently empty. I can't recommend anything.");
            return;
        }
        int index = random.nextInt(menu.size());
        TheaterFood recommendedFood = menu.get(index);
        System.out.println("MovieBot: I recommend trying our " + recommendedFood.getName() +
                ". It's a " + recommendedFood.getSize() + " size and costs $" + recommendedFood.getPrice() + ".");
    }
}
