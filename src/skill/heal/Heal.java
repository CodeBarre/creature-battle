package skill.heal;

import creature.Creature;
import skill.Skill;

import java.text.MessageFormat;

public abstract class Heal extends Skill {

    /**
     * Constructor for skills of type Heal
     *
     * @param name  The name of the skill
     * @param value The value of the skill
     */
    public Heal(String name, int value) {
        super(name, value);
    }

    /**
     * Heals the user creature
     *
     * @param user The user creature
     */
    @Override
    public void use(Creature user, Creature target) {
        // store the user's current health
        int oldHealth = user.getHealth();

        // heal the user
        user.heal(value);

        // if the user's health is at his maximum, show the difference between the max and old health as the amount healed
        if ((oldHealth + value) > user.getMaxHealth()) {
            System.out.println(MessageFormat.format("{0} used {1} and healed {2} health. {3} now has {4} HP (max).", user.getName(), name, user.getMaxHealth() - oldHealth, user.getName(), user.getHealth()));
            // else, show the amount healed
        } else {
            System.out.println(MessageFormat.format("{0} used {1} and healed {2} health. {3} now has {4} HP.", user.getName(), name, value, user.getName(), user.getHealth()));
        }
    }
}
