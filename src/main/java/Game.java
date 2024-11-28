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

        Tav player = new Tav(name, role);
        player.printCharacterSheet();

        Ascii.titlescreen();

        printDramaticText(player.name + " the " + player.role + " ( " + player.status + " )" + " is drunkenly seated in a tavern...");
        printDramaticText("After being kicked out, you soon encounter a monster in the wilderness!");
        System.out.println(generateMonster());

        int DC = (int)(Math.random() * 10) + 1;
        printDramaticText("You need to roll higher than: " + DC);

        System.out.println("Press 'y' to roll luck: ");
        String buff = scanner.nextLine();

        int result = 0;
        if(buff.equals("y")) {
            result = player.rollLuck() + rolld20();
            player.MP -= 10; 
            System.out.println("Your MP: " + player.MP);
        }
        else {
            result = rolld20();
            player.HP -= 10; 
            System.out.println("Your HP: " + player.HP);
        }

        if (result >= DC) {
            System.out.println("You needed a " + DC + " You slay the monster!");
        }
        if (result < DC) {
            System.out.println("You needed a " + DC + " Game Over!");
            Ascii.gameover(); 
            System.exit(0); 
        }

        player.level += 1; 
        System.out.println("Your level: " + player.level);

        System.out.println("---------");

        printDramaticText(player.name + " ventures forth through the wilderness, encountering more enemies!");
        System.out.println(generateMonster());
        int DC2 = (int)(Math.random() * 15)  + 1;
        printDramaticText("You need to roll higher than: " + DC2);

        System.out.println("Press 'y' to roll luck: ");
        String buff2 = scanner.nextLine();
        int result2 = 0;
        if(buff2.equals("y")) {
            result2 = player.rollLuck() + rolld20();
            player.MP -= 10; 
            System.out.println("Your MP: " + player.MP);
        }
        else {
            result2 = rolld20();
            player.HP -= 10; 
            System.out.println("Your HP: " + player.HP);
        }

        if (result2 >= DC2) {
            System.out.println("You needed a " + DC2 + " You slay the monster!");
        }
        if (result2 < DC2) {
            System.out.println("You needed a " + DC2 + " Game Over!");
            Ascii.gameover();
            System.exit(0); 
        }

        player.level += 1; 
        System.out.println("Your level: " + player.level);

        System.out.println("---------");

        printDramaticText("Almost out of the woods, a castle can be seen in the distance...");
        System.out.println(generateMonster());
        int DC3 = (int)(Math.random() * 20)  + 1;
        printDramaticText("You need to roll higher than: " + DC3);

        System.out.println("Press 'y' to roll luck: ");
        String buff3 = scanner.nextLine();
        int result3 = 0;
        if(buff3.equals("y")) {
            result3 = player.rollLuck() + rolld20();
            player.MP -= 10; 
            System.out.println("Your MP: " + player.MP);
        }
        else {
            result3 = rolld20();
            player.HP -= 10; 
            System.out.println("Your HP: " + player.HP);
        }

        if (result3 >= DC3) {
            System.out.println("You needed a " + DC3 + " You slay the monster!");
        }
        if (result3 < DC3) {
            System.out.println("You needed a " + DC3 + " Game Over!");
            Ascii.gameover();
            System.exit(0); 
        }

        player.level += 1; 
        System.out.println("Your level: " + player.level);

        System.out.println("---------");

        // Dracula !! 

        printDramaticText(player.name + " looks at the caslte in the distance...");
        printDramaticText("You are face to face with the castle of Dracula!");
        printDramaticText(player.name + " enters Dracula's castle, determined to rid him and his monsters from this world...");

        Ascii.thecastle();
    }


    public static int generateMonster() {

        int difficulty = (int)(Math.random() * 6) + 1;
        if (difficulty <= 3) {
            System.out.println("Skeleton");
        } 
        if (difficulty > 3 && difficulty <= 5) {
            System.out.println("Zombie Soldier");
        } 
        if (difficulty == 6) {
            System.out.println("Axe Knight");
        }

        System.out.print("Difficulty: "); 
        return difficulty;
    }

    public static int rolld20() {
        int roll = (int)(Math.random() * 20) + 1;
        Ascii.drawD20(roll);
        if (roll == 1) {
            System.out.println("Critical Fail! Game Over...");
            Ascii.gameover();
            System.exit(0); 
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
