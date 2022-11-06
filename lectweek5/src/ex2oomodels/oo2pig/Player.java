package ex2oomodels.oo2pig;

import java.util.Objects;

/*
    Class representing a Pig player
 */
public class Player {

    private final String name;
    private int roundPoints;
    private int totalPoints;

    // Constructor
    public Player(String name) {
        this.name = name;
    }

    // Methods
    public int getRoundPoints() {
        return roundPoints;
    }

    public boolean isWinner(int winPoints) {
        return roundPoints + totalPoints > winPoints;
    }

    public void addRoundPoints(int result) {
        roundPoints += result;
    }

    public void updateTotalPoints() {
        totalPoints = totalPoints + roundPoints;
        roundPoints = 0;
    }

    public void clear(){
        roundPoints = 0;
    }

    // Setter/getters
    public String getName() {
        return name;
    }

    // Standard methods
    @Override
    public String toString() {
        return "{" + name + " totalPoints = " + totalPoints + "}";
    }

    @Override
    // Another version of equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
