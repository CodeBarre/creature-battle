package entity.creature;

import java.text.MessageFormat;

public class Cat extends Creature {

    /**
     * Creates a new cat with the given name.
     *
     * @param name The name of the cat.
     */
    public Cat(String name) {
        super(name, 200, 9, 15, 10);
    }

    /**
     * Returns a string describing the cat.
     *
     * @return A string describing the cat
     */
    @Override
    public String toString() {
        return MessageFormat.format("Cat {0}", super.toString());
    }
}
