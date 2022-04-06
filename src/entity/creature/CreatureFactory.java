package entity.creature;

public class CreatureFactory {
    public static Creature create(CreatureType type, String name) {
        switch (type) {
            case CAT -> {
                return new Cat(name);
            }
            case DRAGON -> {
                return new Dragon(name);
            }
            default -> {
                return null;
            }
        }
    }
}
