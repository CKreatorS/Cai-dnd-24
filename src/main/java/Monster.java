import java.util.Random;
import java.util.Scanner;

public class Monster {

    public String type;
    public int HP;

    public Monster(String type) {

        this.type = type;
        this.HP = (int)(Math.random() * 46) + 5;

    }

    // public void generateMonster() {
    //     Random rand = new Random();

    //     String[] names = new String[]{"zombie soldier", "flea man", "skeleton", "axe knight"};
    //     Monster[] monsters = new Monster[4];

    //     for (int i = 0; i < monsters.length; i++) {
    //         String name = names[rand.nextInt(names.length)];
    //         int HP = rand.nextInt(50);
        
    //     monsters[i] = new Monster(name, HP);
    //     }
        

    // }
    
    private void shuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            
            // Swap elements
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
}