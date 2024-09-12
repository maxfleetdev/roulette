import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static BufferedReader reader;
    public static ArrayList<Player> players = new ArrayList<>();

    public static boolean isPlaying = true;
    public static int playerIndex = 0;

    // Main Loop
    public static void main(String[] args) {
        startGame();
        while(isPlaying) {
            gameLoop();
        }
    }

    public static void startGame() {
        // 1. Get Player Count
        System.out.println("How many players (2-6): ");
        int count = toInt(readInput());

        // 2. Add x amount of players
        for(int i = 1; i <= count; i++) {
            System.out.println("Player #" + i + " name: ");
            String name = readInput();
            players.add(new Player(name));
        }

        // 3. Fill chamber and start
        Roulette.fillChamber();
        System.out.println("Type '1' to fire!");
    }

    public static void gameLoop() {
        // 1. Increment Index
        playerIndex++;
        if (playerIndex >= players.size()) {
            playerIndex = 0;
        }

        // 2. Main Firing Logic
        System.out.println(players.get(playerIndex).getname() + "'s turn!");
        String ipt = readInput();
        if (toInt(ipt) == 1) {
            if (Roulette.fireRound()) {
                System.out.println("BANG! Player " +
                        players.get(playerIndex).getname()
                        + " lost!");
                gameEnd();
            }
            else {
                System.out.println("Click...\n");
                players.get(playerIndex).addPoints();
            }
        }
    }

    // Restart or End game
    public static void gameEnd() {
        // 1. Print out score
        for (Player player : players) {
            System.out.println(player.getname() +
                    ": " + player.getPoints());
        }

        // 2. Replay or quit app
        System.out.println("\nReplay? Y/N");
        String i = readInput();
        if (i == null) {
            gameEnd();
            return;
        }
        if (i.equals("y") || i.equals("Y")) {
            Roulette.fillChamber();
            gameLoop();
        }
    }

    // Returns any input from the user
    public static String readInput() {
        if (reader == null) {
            reader = new BufferedReader(
                    new InputStreamReader(System.in));
        }
        String input;
        try{
            input = reader.readLine();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        assert input != null;
        return input;
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
