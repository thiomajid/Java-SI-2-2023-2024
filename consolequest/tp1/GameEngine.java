package consolequest.tp1;

import java.util.Scanner;

public class GameEngine {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans ConsoleQuest !");
        int choice;

        do {
            System.out.println("1. Jouer\n2. Quitter");
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);


        if (choice == 2) {
            System.out.println("A la prochaine sur ConsoleQuest !");
        } else {
            Character player = new Character();
            System.out.println("Quel est votre nom ?");
            player.setName(scanner.next());

            System.out.println("Donner vos points de vie");
            player.setHealth(scanner.nextDouble());

            System.out.println("Donner votre attaque");
            player.setAttack(scanner.nextDouble());

            System.out.println("Donner votre vitesse");
            player.setSpeed(scanner.nextDouble());

            System.out.println("Vos informations sont: " + player);

            Weapon myWeapon = new Weapon();
            System.out.println("Quel est le nom de votre arme ?");
            myWeapon.setName(scanner.next());

            System.out.println("Donner les points d'attaque de votre arme");
            myWeapon.setAttack(scanner.nextDouble());

            System.out.println("Vous équipez votre arme " + myWeapon.getName());
            player.equipWeapon(myWeapon);
            System.out.println("Vos informations sont: " + player);

            // Informations sur l'ennemi
            System.out.println("\nCréation de l'ennemi...\n");
            Character enemy = new Character();
            enemy.setName("Goblin");
            enemy.setHealth(10);
            enemy.setAttack(2);
            enemy.setSpeed(5);
            System.out.println("L'ennemi est un " + enemy.getName() + " avec " + enemy.getHealth() + " points de vie, " + enemy.getAttack() + " points d'attaque et " + enemy.getSpeed() + " points de vitesse.");

            // Combat
            System.out.println("\nCombat !\n");
            player.attack(enemy);
        }
    }
}
