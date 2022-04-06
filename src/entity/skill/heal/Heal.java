package entity.skill.heal;

import entity.creature.Creature;
import entity.skill.Skill;

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
        user.setHealth(user.getHealth() + value);

        // If the health is greater than the max health, set it to the max health.
        boolean healedAtMaxHealth = false;
        if (user.getHealth() > user.getMaxHealth()) {
            user.setHealth(user.getMaxHealth());
            int healAmount = user.getMaxHealth() - oldHealth;
            System.out.println(MessageFormat.format("{0} used {1} and healed {2} health. {3} now has {4} HP.", user.getName(), name, healAmount, user.getName(), user.getHealth()));
        } else {
            System.out.println(MessageFormat.format("{0} used {1} and healed {2} health. {3} now has {4} HP.", user.getName(), name, value, user.getName(), user.getHealth()));
        }
    }

    /**
     * Describes the skill
     */
    @Override
    public void describe() {
        System.out.println(MessageFormat.format("{0} heals the user for {1} HP.", name, value));
    }
}
