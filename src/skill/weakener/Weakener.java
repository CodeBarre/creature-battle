package skill.weakener;

import creature.Creature;
import skill.Skill;

import java.text.MessageFormat;

public abstract class Weakener extends Skill {

    private final String statTarget;

    /**
     * Constructor for Skills of type Boost
     *
     * @param name       The name of the skill
     * @param value      The value incremented by the skill
     * @param statTarget The stat to be boosted
     */
    public Weakener(String name, int value, String statTarget) {
        super(name, value);
        this.statTarget = statTarget;
    }

    /**
     * Weakens the target's stat
     *
     * @param user   The user of the skill.
     * @param target The target of the skill.
     */
    @Override
    public void use(Creature user, Creature target) {
        switch (statTarget) {
            // if the stat targeted is attack
            case "attack" -> {
                target.weakenAttack(value);
                System.out.println(MessageFormat.format("{0} used {1} on {2} and weakened their attack by {3}. {4} now has {5} attack.", user.getName(), name, target.getName(), value, target.getName(), target.getAttack()));
            }
            // if the stat targeted is defense
            case "defense" -> {
                target.weakenDefense(value);
                System.out.println(MessageFormat.format("{0} used {1} on {2} and weakened their defense by {3}. {4} now has {5} defense.", user.getName(), name, target.getName(), value, target.getName(), target.getDefense()));
            }
        }
    }
}
