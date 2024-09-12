import java.util.Random;

public class Roulette {
    public static int[] cylinder;
    public static int index;

    public static void fillChamber() {
        // Fill array with 6 indexes
        cylinder = new int[6];
        // Reset index
        index = 0;
        // Get random number between 0-5
        int r = 6 + (int)(Math.random() * (-6)) - 1;
        // Random number = Index in cylinder
        cylinder[r] = 1;
    }

    public static boolean fireRound() {
        // loaded? end game, return true
        // empty? increase index, return false
        if (cylinder[index] == 1) {
            return true;
        }
        else {
            index++;
            return false;
        }
    }
}
