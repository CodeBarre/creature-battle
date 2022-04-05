package skill.boost;

import creature.Creature;
import skill.Skill;

public abstract class Boost extends Skill {

    private final String statTarget;

    /**
     * Constructor for Skills of type Boost
     *
     * @param name       The name of the skill
     * @param value      The value incremented by the skill
     * @param statTarget The stat to be boosted
     */
    public Boost(String name, int value, String statTarget) {
        super(name, value);
        this.statTarget = statTarget;
    }

    /**
     * Boosts the given stat of the user.
     *
     * @param user The user of the skill.
     */
    @Override
    public void use(Creature user, Creature target) {
        switch (statTarget) {
            // if the stat targeted is attack
            case "attack" -> {
                user.boostAttack(value);
                System.out.println(user.getName() + " used " + this.getName() + " and has been boosted in attack by " + value + ". His attack is now " + user.getAttack() + ".\n");
            }
            // if the stat targeted is defense
            case "defense" -> {
                user.boostDefense(value);
                System.out.println(user.getName() + " used " + this.getName() + " and has been boosted in defense by " + value + ". His defense is now " + user.getDefense() + ".\n");
            }
        }
    }
}
