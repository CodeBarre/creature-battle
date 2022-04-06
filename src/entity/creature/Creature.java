package entity.creature;

import entity.skill.Skill;
import util.Describable;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Creature implements Comparable<Creature>, Describable {
    protected final String name; // Name of the creature
    protected final int maxHealth; // Maximum health points
    protected int lives; // Amount lives
    protected int health; // Current health points
    protected int attack; // Attack points
    protected int defense;  // Defense points
    protected final List<Skill> skills; // List of skills that the creature can use

    /**
     * Creates a new creature with the given name, max health, attack, defense, and lives.
     *
     * @param name      The name of the creature.
     * @param maxHealth The maximum health points of the creature.
     * @param lives     The amount lives the creature has.
     * @param attack    The attack points of the creature.
     * @param defense   The defense points of the creature.
     */
    public Creature(String name, int maxHealth, int lives, int attack, int defense) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.lives = lives;
        this.health = maxHealth;
        this.attack = attack;
        this.defense = defense;
        skills = new ArrayList<>();
    }

    /**
     * Returns a string representation of the creature.
     *
     * @return A string representation of the creature.
     */
    @Override
    public String toString() {
        return MessageFormat.format("{0}: {1}/{2} HP - {3} lives", this.name, this.health, this.maxHealth, this.lives);
    }

    /**
     * Returns the name of the creature.
     *
     * @return The name of the creature.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the attack points of the creature.
     *
     * @return The attack points of the creature.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Returns the current health points of the creature.
     *
     * @return The current health points of the creature.
     */
    public int getHealth() {
        return health;
    }


    /**
     * Returns the amount of lives the creature has.
     *
     * @return The amount of lives the creature has.
     */
    public int getLives() {
        return lives;
    }

    /**
     * Returns the defense points of the creature.
     *
     * @return The defense points of the creature.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Returns the maximum health points of the creature.
     *
     * @return The maximum health points of the creature.
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Set the amount of HP of the creature
     *
     * @param health The amount of HP to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Set the amount of attack points of the creature
     *
     * @param attack The amount of attack points to set
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Sets the amount of defense points of the creature.
     *
     * @param defense The amount of defense points to set
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Attacks the given creature.
     *
     * @param target The creature to attack.
     * @param skill  The skill that the creature used.
     * @return The amount of damage the creature did.
     */
    public int attack(Creature target, Skill skill) {
        return target.takeDamage(this.attack * skill.getValue());
    }

    /**
     * Calculates the damage that the creature will take and updates the health points accordingly.
     *
     * @param damage The amount of damage to inflict.
     * @return The amount of damage that the creature took.
     */
    public int takeDamage(int damage) {

        int damageTaken = damage / this.defense;
        // If the damage is negative, set it to 0
        if (damageTaken > 0) {
            this.health -= damageTaken;
        }

        // If the creature is dead, remove a life
        if (this.health <= 0) {
            this.lives--;

            // If the creature has lives left, reset the health
            if (this.lives > 0) {
                this.health = this.maxHealth;
                // else, set the health to 0
            } else {
                this.health = 0;
            }
        }
        return damageTaken;
    }

    /**
     * Checks if the creature is alive.
     *
     * @return True if the creature is alive, false otherwise.
     */
    public boolean isAlive() {
        return this.health > 0 && this.lives > 0;
    }

    /**
     * Learn the given skill.
     *
     * @param skill The skill to learn.
     */
    public void learn(Skill skill) {
        this.skills.add(skill);
        System.out.println(MessageFormat.format("{0} learned {1}!", this.getName(), skill.getName()));
    }

    /**
     * Returns the skills that the creature knows.
     *
     * @return The skills that the creature knows.
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * Compare the creatures by their attack points.
     *
     * @param creature The creature to compare to.
     * @return < 0 if this creature has less attack points than the given creature, 0 if they have the same amount of attack points, and > 0 if this creature has more attack points than the given creature.
     */
    @Override
    public int compareTo(Creature creature) {
        return Integer.compare(this.getAttack(), creature.getAttack());
    }

    /**
     * Describes the creature.
     */
    @Override
    public void describe() {
        System.out.println(MessageFormat.format("{0} has {1}/{2} HP, {3} attack, {4} defense, {5} lives left.", this.getName(), this.getHealth(), this.getMaxHealth(), this.getAttack(), this.getDefense(), this.getLives()));
        System.out.println(MessageFormat.format("{0} knows the following skills:", this.getName()));
        for (Skill skill : this.getSkills()) {
            System.out.println(MessageFormat.format("\t- {0}", skill.getName()));
        }
    }
}
