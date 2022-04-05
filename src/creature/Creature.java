package creature;

import skill.Skill;

import java.util.ArrayList;
import java.util.List;

public abstract class Creature {
    protected String name; // Name of the creature
    protected int maxHealth; // Maximum health points
    protected int lives; // Number of lives
    protected int health; // Current health points
    protected int attack; // Attack points
    protected int defense;  // Defense points
    protected List<Skill> skills; // List of skills that the creature can use

    /**
     * Creates a new creature with the given name, max health, attack, defense, and lives.
     *
     * @param name      The name of the creature.
     * @param maxHealth The maximum health points of the creature.
     * @param lives     The number of lives the creature has.
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
        return this.name + ": " + this.health + "/" + this.maxHealth + " HP, " + this.lives + " lives \n";
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
     * Attacks the given creature.
     *
     * @param target The creature to attack.
     * @param skill  The skill that the creature used.
     */
    public void attack(Creature target, Skill skill) {
        target.takeDamage(this.attack, skill);
    }

    /**
     * Calculates the damage that the creature will take and updates the health points accordingly.
     *
     * @param attack The attack points of the other creature.
     * @param skill  The skill that the other creature used.
     */
    public void takeDamage(int attack, Skill skill) {
        int damage = attack * skill.getValue() / this.defense;

        // If the damage is negative, set it to 0
        if (damage > 0) {
            this.health -= damage;
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
    }

    /**
     * Boosts the attack points of the creature.
     *
     * @param boost The amount to boost the attack points by.
     */
    public void boostAttack(int boost) {
        this.attack += boost;
    }

    /**
     * Boosts the defense points of the creature.
     *
     * @param boost The amount to boost the defense points by.
     */
    public void boostDefense(int boost) {
        this.defense += boost;
    }

    /**
     * Weakens the attack points of the creature.
     *
     * @param weaken The amount to weaken the attack points by.
     */
    public void weakenAttack(int weaken) {
        this.attack -= weaken;
    }

    /**
     * Weakens the defense points of the creature.
     *
     * @param weaken The amount to weaken the defense points by.
     */
    public void weakenDefense(int weaken) {
        this.defense -= weaken;
    }

    /**
     * Heals the creature by the given amount.
     *
     * @param heal The amount to heal the creature by.
     */
    public void heal(int heal) {
        this.health += heal;
        // If the health is greater than the max health, set it to the max health
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
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
    }

    /**
     * Returns the skills that the creature knows.
     *
     * @return The skills that the creature knows.
     */
    public List<Skill> getSkills() {
        return skills;
    }
}
