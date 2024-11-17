import java.util.Random;
import java.util.Scanner;

public class Monster {

    public String names;
    public int difficulty;
    public int HP;

    public Monster() {

        this.names = names;
        this.difficulty = difficulty; 

        int[] difficulty = new int[]{5, 7, 9, 10};
        shuffle(difficulty);

        int[] HP = new int[]{10, 20, 25, 15}; 
        shuffle(HP);

    }

    public void generateMonster() {

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