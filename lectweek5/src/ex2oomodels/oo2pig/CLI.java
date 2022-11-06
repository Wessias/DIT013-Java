package ex2oomodels.oo2pig;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
    Command Line Interface to OO version of Pig game
    (this class is not part of the model, it handles interaction
    between player and model and constructs the model)

    See: https://en.wikipedia.org/wiki/Pig_(dice_game)
 */
public class CLI {

    public static void main(String[] args) {
        new CLI().program();
    }

    private Pig pig;   // Reference to OO - model

    private void program() {

        boolean aborted = false;

        // Build model
        Dice dice = new Dice();
        List<Player> players = List.of(new Player("Fia"), new Player("pelle"));
        pig = new Pig(dice, players, 10);


        welcomeMsg(pig.getWinPoints()); // Query model
        statusMsg(pig.getPlayers());    // Query model

        while (!pig.hasWinner()) {         // Game loop
            String cmd = getPlayerChoice(pig.getCurrent());
            if (cmd.equals("r")) {
                boolean success = pig.roll();
                if (!success) {
                    pig.clearCurrent();
                    pig.next();
                }
                roundMsg(pig.getCurrent(), pig.getLastDiceResult());
                if (!success) {
                    statusMsg(pig.getPlayers());
                }
            } else if (cmd.equals("n")) {
                pig.updateCurrentTotalPoints();
                pig.next();
                statusMsg(pig.getPlayers());
            } else if (cmd.equals("q")) {
                aborted = true;
                break;
            } else {
                dontUnderstand();
            }
        }
        gameOverMsg(pig.getCurrent(), aborted);
        statusMsg(players);
    }

    // -------------- IO  -----------------------

    /*
        Model, IO and look
        ------------------
        IO or any information of "look" od the model isn't part of the model.
        Model is data and logical operations on data.

     */
    private final Scanner sc = new Scanner(in);

    public void welcomeMsg(int winPoints) {
        out.println("Welcome to PIG!");
        out.println("First player to get " + winPoints + " points will win!");
        out.println("Commands are: r = roll , n = next, q = quit");
        out.println();
    }

    public void statusMsg(List<Player> players) {
        out.println(players);
    }

    public void roundMsg(Player current, int result) {
        if (result > 1) {
            out.println("Got " + result + " running total is " + current.getRoundPoints());
        } else {
            out.println("Got 1 lost it all!");
        }
    }

    public void gameOverMsg(Player current, boolean aborted) {
        if (aborted) {
            out.println("Aborted");
        } else {
            out.println("Game over! Winner is  " + current.getName());
        }
    }

    public String getPlayerChoice(Player player) {
        out.print("Player is " + player.getName() + " > ");
        return sc.nextLine();
    }

    public void dontUnderstand() {
        out.println("?");
    }
}



