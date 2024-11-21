import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    public static void main(String[] args) {

        // Create Scanner for collecting user input.
        Scanner scanner = new Scanner(System.in);

        // Collect character name from user.
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.println("-----");

        String[] roles = new String[]{"dhampir", "speaker", "vampire hunter"};
        System.out.println("Choose a role: Dhampir  Speaker  Vampire Hunter");

        System.out.print("Role: ");
        String role = scanner.nextLine();
        while(!Arrays.asList(roles).contains(role.toLowerCase())) {
            System.out.println("Please enter a valid role: ");
            role = scanner.nextLine();
        }


        // TODO Check for 3 successful monster encounters.
        // TODO Print GAME OVER or winning message. 

        Tav player = new Tav(name, role);
        player.printCharacterSheet();

        Ascii.titlescreen();

        printDramaticText(player.name + " the " + player.role + " ( " + player.status + " )" + " is drunkenly seated in a tavern...");
        printDramaticText("After being kicked out, you soon encounter a monster in the wilderness!");
        System.out.println(generateMonster());

        int DC = (int)(Math.random() * 20)  + 1;
        printDramaticText("You need to roll higher than: " + DC);

        System.out.println("Press 'y' to roll luck: ");
        String buff = scanner.nextLine();

        int result = 0;
        if(buff.equals("y")) {
            result = player.rollLuck() + rolld20();
        }
        else {
            result = rolld20();
        }

        if (result > generateMonster()) {
            System.out.println("You needed a " + DC + " You slay the monster!");
        }
        else {
            System.out.println("You needed a " + DC + " Game Over!");
        }
    
    }

    public static int generateMonster() {

        int difficulty = (int)(Math.random() * 5) + 1;
        if (difficulty <= 3) {
            System.out.println("Skeleton");
        } 
        if (difficulty > 3 && difficulty <= 5) {
            System.out.println("Zombie Soldier");
        } 
        if (difficulty == 6) {
            System.out.println("Axe Knight");
        }

        return difficulty;
        
    }

    public static int rolld20() {
        int roll = (int)(Math.random() * 20) + 1;
        Ascii.drawD20(roll);
        if (roll == 1) {
            System.out.println("Critical Fail!");
        } 
        if (roll == 20) {
            System.out.println("Critical Success!");
        }
    return roll; 
    }

    public static void printDramaticText(String text) {
        // Delay in milliseconds
        int delay = 100;

        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                System.err.println("Interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }
}
