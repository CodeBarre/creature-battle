package entity.skill.damage;

import entity.creature.Creature;
import entity.skill.Skill;

import java.text.MessageFormat;

public abstract class Damage extends Skill {

    /**
     * Constructor for Skills of type Boost
     *
     * @param name  The name of the skill
     * @param value The value of the skill
     */
    public Damage(String name, int value) {
        super(name, value);
    }

    /**
     * Attack a creature with the skill.
     *
     * @param user   The user of the skill.
     * @param target The target of the skill.
     */
    @Override
    public void use(Creature user, Creature target) {
        // store the health of the target before the attack
        int oldHealth = target.getHealth();

        // attack the target
        int damageInflicted = user.attack(target, this);

        // if the target died or lost a life, print a different message.
        if (user.getAttack() * value / target.getDefense() >= oldHealth) {
            if (target.getLives() <= 0) {
                System.out.println(MessageFormat.format("{0} used {1} on {2}. {3} took {4} damage. {5} lost a life and has no lives remaining!", user.getName(), this.getName(), target.getName(), target.getName(), damageInflicted, target.getName(), target.getName()));
            } else {
                System.out.println(MessageFormat.format("{0} used {1} on {2}. {3} took {4} damage. {5} lost a life! {6} has {7} lives left.", user.getName(), this.getName(), target.getName(), target.getName(), damageInflicted, target.getName(), target.getName(), target.getLives()));
            }
        } else {
            System.out.println(MessageFormat.format("{0} used {1} on {2}. {3} took {4} damage. {5} has {6} HP left.", user.getName(), this.getName(), target.getName(), target.getName(), damageInflicted, target.getName(), target.getHealth()));
        }
    }

    /**
     * Describes the skill.
     */
    @Override
    public void describe() {
        System.out.println(MessageFormat.format("{0} deals {1} damage to the target.", this.getName(), this.getValue()));
    }
}
