package entity.creature;

import java.text.MessageFormat;

public class Dragon extends Creature {

    /**
     * Creates a new dragon with the given name.
     *
     * @param name The name of the dragon.
     */
    public Dragon(String name) {
        super(name, 500, 1, 40, 25);
    }


    /**
     * Return a string describing the dragon.
     *
     * @return A string describing the dragon.
     */
    @Override
    public String toString() {
        return MessageFormat.format("Dragon {0}", super.toString());
    }
}
