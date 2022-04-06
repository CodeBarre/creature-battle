package entity;

import entity.creature.Creature;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static Player player;
    private final List<Creature> creatures = new ArrayList<>();

    /**
     * Constructor for objects of class Player
     */
    private Player() {
    }

    /**
     * Check if the player exists. If not, create a new player.
     *
     * @return the player
     */
    public static Player getInstance() {
        return player == null ? player = new Player() : player;
    }

    /**
     * Get the player's creatures
     *
     * @return list of creatures
     */
    public List<Creature> getCreatures() {
        return creatures;
    }

    /**
     * Add a creature to the player's creatures
     *
     * @param creature the creature to add
     */
    public void adopt(Creature creature) {
        creatures.add(creature);
    }
}
