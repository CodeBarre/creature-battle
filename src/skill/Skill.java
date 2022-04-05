package skill;

import creature.Creature;

public abstract class Skill {
    protected String name;
    protected int value;

    public Skill(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    /**
     * Use the skill on the target.
     *
     * @param user   The user of the skill.
     * @param target The target of the skill.
     */
    public abstract void use(Creature user, Creature target);


}
