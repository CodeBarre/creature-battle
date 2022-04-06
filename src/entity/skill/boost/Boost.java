package entity.skill.boost;

import entity.creature.Creature;
import entity.skill.Skill;

import java.text.MessageFormat;

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
                user.setAttack(user.getAttack() + value);
                System.out.println(MessageFormat.format("{0} used {1} and has been boosted in attack by {2}. His attack is now {3}.", user.getName(), this.getName(), value, user.getAttack()));
            }
            // if the stat targeted is defense
            case "defense" -> {
                user.setDefense(user.getDefense() + value);
                System.out.println(MessageFormat.format("{0} used {1} and has been boosted in defense by {2}. His defense is now {3}.", user.getName(), this.getName(), value, user.getDefense()));
            }
        }
    }

    /**
     * Describes the skill.
     */
    @Override
    public void describe() {
        System.out.println(MessageFormat.format("{0} will boost the user''s {1} by {2}", name, statTarget, value));
    }
}
