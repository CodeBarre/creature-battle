package skill.damage;

import creature.Creature;
import skill.Skill;

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
        user.attack(target, this);
        System.out.println(user.getName() + " used " + this.getName() + " on " + target.getName() + ". " + target.getName() + " took " + this.getValue() + " damage." + target.getName() + " has " + target.getHealth() + " HP left.\n");
    }
}
