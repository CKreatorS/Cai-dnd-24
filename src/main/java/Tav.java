import java.util.Random;

public class Tav {
    // TODO - create Tav class here!
    public String name;
    public String role;
    public String status;
    public int level;
    public int HP;
    public int MP;

    public int strength;
    public int constitution;
    public int intelligence;
    public int luck;

    public Tav(String name, String role) {
        this.name = name;
        this.role = role;
        this.status = status;

        this.HP = 100;
        this.MP = 50;

        this.level = 1;
        int[] stats = new int[]{15, 14, 13, 12, 10, 8};
        shuffle(stats);

        this.strength = stats[0];
        this.dexterity = stats[1];
        this.constitution = stats[2];
        this.intelligence = stats[3];
        this.charisma = stats[4];
        this.wisdom = stats[5];

    }

    public void printCharacterSheet() {
        System.out.println("Name: " + this.name);
        System.out.println("Role: " + this.role);
        System.out.println("Level: " + this.level);

        System.out.println("-----------");

        System.out.println("Strength:     " + this.strength);
        System.out.println("Dexterity:    " + this.dexterity);
        System.out.println("Constitution: " + this.constitution);
        System.out.println("Intelligence: " + this.intelligence);
        System.out.println("Charisma:     " + this.charisma);
        System.out.println("Wisdom:       " + this.wisdom);

    }

    // https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
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
