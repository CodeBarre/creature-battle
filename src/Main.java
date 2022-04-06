import entity.creature.Cat;
import entity.creature.Dragon;
import entity.skill.boost.SunlightPower;
import entity.skill.damage.Fireball;
import entity.skill.heal.FlowerBless;
import entity.skill.weakener.CurseOfTheMoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize the variables
        Scanner scanner = new Scanner(System.in);

        // initialize the creatures
        // initialize the dragon
        System.out.println("Enter the name of the dragon: ");
        Dragon dragon = new Dragon(scanner.nextLine());
        System.out.println("Dragon created! " + dragon);

        // initialize the cat
        System.out.println("Enter the name of the cat: ");
        Cat cat = new Cat(scanner.nextLine());
        System.out.println("Cat created! " + cat);

        // initialize the skills and add them to the creatures
        // learn skills to the dragon.
        Fireball fireball = new Fireball();
        dragon.learn(fireball);
        CurseOfTheMoon curseOfTheMoon = new CurseOfTheMoon();
        dragon.learn(curseOfTheMoon);

        // learn skills to the cat
        SunlightPower sunlightPower = new SunlightPower();
        cat.learn(sunlightPower);
        FlowerBless flowerBless = new FlowerBless();
        cat.learn(flowerBless);

        fireball.describe();
        flowerBless.describe();
        sunlightPower.describe();
        curseOfTheMoon.describe();
        cat.describe();
        dragon.describe();

        /*// fight
        int turn = 1;
        while (dragon.isAlive() && cat.isAlive()) {
            System.out.println("\n\nTurn " + turn);
            System.out.println(dragon + " vs " + cat + "\n");
            //TimeUnit.MILLISECONDS.sleep(100);
            dragon.getSkills().get(0).use(dragon, cat);
            //TimeUnit.MILLISECONDS.sleep(500);
            if (cat.isAlive()) {
                cat.getSkills().get(1).use(cat, dragon);
                //TimeUnit.MILLISECONDS.sleep(500);
            }
            turn++;
        }

        // end of the fight
        if (dragon.isAlive()) {
            System.out.println(MessageFormat.format("{0} wins!", dragon.getName()));
        } else {
            System.out.println(MessageFormat.format("{0} wins!", cat.getName()));
        }*/
    }
}
