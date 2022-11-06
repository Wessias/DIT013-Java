package ex2oomodels.oo2pig;

import java.util.List;

/*
    OO Version of Pig
    This class represents the over all game
    No IO here.

    See: https://en.wikipedia.org/wiki/Pig_(dice_game)

 */
public class Pig {

    private final int winPts;
    private final Dice dice;
    private final List<Player> players;
    private Player current;

    // NOTE: Connecting the model by sending in references
    // the objects creates elsewhere (in CLI)
    public Pig(Dice dice, List<Player> players, int winPts) {
        this.dice = dice;
        this.players = players;
        this.winPts = winPts;
        current = players.get(0);
    }

    public boolean roll() {
        int result = dice.roll();
        if (result != 1) {
            current.addRoundPoints(result);
            return true;
        }
        return false;
    }

    public void next() {
        current = players.get((players.indexOf(current) + 1) % players.size());
    }

    // ------- Used by CLI --------------

    public void clearCurrent(){
        current.clear();
    }

    public void updateCurrentTotalPoints() {
        current.updateTotalPoints();
    }

    public boolean hasWinner() {
        return current.isWinner(winPts); // Delegating to other object
    }

    public int getLastDiceResult() {
        return dice.getLastResult(); // Delegating to other object
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrent() {
        return current;
    }


    public int getWinPoints() {
        return winPts;
    }


}



