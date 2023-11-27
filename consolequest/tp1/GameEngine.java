package consolequest.tp1;

import consolequest.tp2.WeaponType;

import java.util.Scanner;

public class GameEngine {
    private boolean isRunning = false;

    private void exit() {
        System.out.println("A la prochaine sur ConsoleQuest !");
        isRunning = false;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans ConsoleQuest !");
        int choice, userAction;

        do {
            System.out.println("1. Jouer\n2. Quitter");
            choice = scanner.nextInt();
        } while (choice != 1 && choice != 2);


        if (choice == 2) {
            System.out.println("A la prochaine sur ConsoleQuest !");
        } else {
            isRunning = true;
            System.out.println("***************************************************\nCréation de votre personnage\n***************************************************\n");
            Character player = createCharacter();
            System.out.println("Vos informations sont: " + player);

            while (isRunning) {
                System.out.println("***************************************************\nQue voulez-vous faire ?\n***************************************************\n");
                System.out.println("1.Combattre\n2. Gestion d'inventaire\n3. Votre statut\n4. Quitter");
                userAction = scanner.nextInt();

                switch (userAction) {
                    case 1:
                        _createCombat(player);
                        break;
                    case 2:
                        player.manageInventory();
                        break;

                    case 3:
                        System.out.println("Votre statut est:\n" + player);
                        break;
                    case 4:
                        exit();
                        break;
                }
            }

        }
    }

    /**
     * Fonction utilitaire pour créer un personnage.
     * Evite de répéter le code de création de personnage dans la fonction run().
     *
     * @return Le personnage créé avec les informations entrées par l'utilisateur.
     */
    private Character createCharacter() {
        Character player;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est le nom du personnage ?");
        String name = scanner.next();

        System.out.println("Donner les points de vie");
        double health = scanner.nextDouble();

        System.out.println("Donner l'attaque du personnage");
        double attack = scanner.nextDouble();

        System.out.println("Donner la vitesse");
        double speed = scanner.nextDouble();

        System.out.println("Voulez-vous une arme ?\n1.Oui\n2.Non");
        int wantsWeapon = scanner.nextInt();
        if (wantsWeapon == 1) {
            Weapon weapon = createWeapon(scanner);
            player = new Character(name, health, attack, speed, weapon);
        } else {
            player = new Character(name, health, attack, speed);
        }

        return player;
    }

    /**
     * Fonction utilitaire pour créer une arme.
     * Evite de répéter le code de création d'arme.
     *
     * @return L'arme créée avec les informations entrées par l'utilisateur.
     */
    private Weapon createWeapon(Scanner scanner) {
        System.out.println("Quel est le nom de l'arme ?");
        String name = scanner.next();

        System.out.println("Donner les points d'attaque de l'arme");
        double attack = scanner.nextDouble();

        int weaponTypeChoice;
        do {
            System.out.println("Quel est le type de l'arme ?\n1.Sword\n2.Bow\n3.Staff");
            weaponTypeChoice = scanner.nextInt();
        } while (weaponTypeChoice < 1 || weaponTypeChoice > 3);
        WeaponType weaponType = WeaponType.values()[weaponTypeChoice - 1];

        return new Weapon(name, attack, weaponType);
    }

    /**
     * Fonction utilitaire pour créer un combat.
     * Elle gère la logique de création de l'enemi et de combat.
     * Si le personnage perd le combat la fonction exit() est appelée.
     *
     * @param player Le personnage du joueur.
     */
    private void _createCombat(Character player) {
        System.out.println("***************************************************\nCréation de votre ennemi\n***************************************************\n");
        Character enemy = createCharacter();
        System.out.println("Votre ennemi est: " + enemy);
        player.attack(enemy);

        if (player.getHealth() <= 0) {
            System.out.println("Game Over !");
            exit();
        }
    }
}
