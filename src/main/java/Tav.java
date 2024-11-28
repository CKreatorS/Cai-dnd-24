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

        this.status = "Good";

        this.HP = 100;
        this.MP = 100;

        this.level = 1;
        int[] stats = new int[]{15, 14, 12, 10};
        shuffle(stats);

        this.strength = stats[0];
        this.luck = stats[1];
        this.constitution = stats[2];
        this.intelligence = stats[3];

    }

    public void printCharacterSheet() {
        System.out.println("Name: " + this.name);
        System.out.println("Role: " + this.role);
        System.out.println("Level: " + this.level);
        System.out.println("Status: " + this.status);

        System.out.println("-----------");

        System.out.println("Strength:     " + this.strength);
        System.out.println("Constitution: " + this.constitution);
        System.out.println("Intelligence: " + this.intelligence);
        System.out.println("Luck:         " + this.luck);
        System.out.println("HP: " + this.HP);
        System.out.println("MP: " + this.MP);

    }

    public int rollLuck() {
        int l = (int)(Math.random() * this.luck) + 1;
        Ascii.drawD20(l);
        return l;
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
