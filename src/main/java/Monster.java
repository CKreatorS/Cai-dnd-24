import java.util.Random;
import java.util.Scanner;

public class Monster {

    public String names;
    public int difficulty;
    public int HP;

    public Monster() {

        this.names = names;
        this.HP = HP;

    }

    public void generateMonster() {

        String[] names = new String[]{"zombie soldier", "flea man", "skeleton", "axe knight"};
        int[] HP = new int[]{24, 18, 10, 42};
        

    }
    
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