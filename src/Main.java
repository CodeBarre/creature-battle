import creature.Cat;
import creature.Dragon;
import skill.boost.SunlightPower;
import skill.damage.Fireball;
import skill.heal.FlowerBless;
import skill.weakener.CurseOfTheMoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize the variables
        Scanner scanner = new Scanner(System.in);

        // create a dragon
        System.out.println("Enter the dragon's name: ");
        Dragon dragon = new Dragon(scanner.nextLine());
        System.out.print("Dragon created: " + dragon + "\n");

        // learn the dragon's skills
        dragon.learn(new CurseOfTheMoon());
        System.out.println(dragon.getName() + " learned: " + dragon.getSkills().get(0).getName() + "\n");
        dragon.learn(new Fireball());
        System.out.println(dragon.getName() + " learned: " + dragon.getSkills().get(1).getName() + "\n");

        // create a cat and learn him some skills
        System.out.println("Enter the cat's name: ");
        Cat cat = new Cat(scanner.nextLine());
        System.out.print("Cat created: " + cat + "\n");

        // learn the cat's skills
        cat.learn(new FlowerBless());
        System.out.println(cat.getName() + " learned: " + cat.getSkills().get(0).getName() + "\n");
        cat.learn(new SunlightPower());
        System.out.println(cat.getName() + " learned: " + cat.getSkills().get(1).getName() + "\n");

        // start of the battle
        System.out.println("\n Let's fight! \n");

        for (int i = 1; i < 6; i++) {
            // announce the round
            System.out.println("Turn " + i + "\n");
            // dragon's turn
            System.out.println("Dragon's turn: \n");
            dragon.getSkills().get(0).use(dragon, cat);
            // cat's turn
            System.out.println("Cat's turn: \n");
            cat.getSkills().get(0).use(cat, dragon);
            // info on the battle
            System.out.println("State of the dragon: " + dragon + "\n");
            System.out.println("State of the cat: " + cat + "\n");
            i++;
            // repeat the round
            System.out.println("Turn " + i + "\n");
            System.out.println("Dragon's turn: \n");
            dragon.getSkills().get(1).use(dragon, cat);
            System.out.println("Cat's turn: \n");
            cat.getSkills().get(1).use(cat, dragon);
            System.out.println("State of the dragon: " + dragon + "\n");
            System.out.println("State of the cat: " + cat + "\n");
        }
    }
}
