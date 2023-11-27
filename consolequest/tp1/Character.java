package consolequest.tp1;

import consolequest.tp2.Inventory;
import consolequest.tp2.WeaponType;

import java.util.Scanner;

public class Character {
    // On utilise un compteur pour générer un identifiant unique pour chaque personnage
    // A chaque fois qu'on crée un personnage, on incrémente le compteur et on l'assigne à l'identifiant du personnage
    private static long nextId = 0;

    // characterId est lié à l'instance du personnage, pas à la classe
    private final long characterId;
    private String name;
    private double health;
    private double attack;
    private double speed;
    private Weapon weapon;
    private final Inventory inventory = new Inventory(3);

    public Character(String name, double health, double attack, double speed) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
        this.characterId = nextId++;
    }

    public Character(String name, double health, double attack, double speed, Weapon weapon) {
        /**
         * On pourrait écrire
         * this.name = name;
         * this.health = health;
         * this.attack = attack;
         * this.speed = speed;
         * equipWeapon(weapon);
         * this.characterId = nextId++;
         *
         * Mais on répète du code, donc on appelle le constructeur avec 4 paramètres
         * et on appelle la fonction equipWeapon() pour équiper l'arme.
         */

        // Cette instruction appelle le constructeur public Character(String name, double health, double attack, double speed)
        this(name, health, attack, speed);
        equipWeapon(weapon);
    }

    public Character(String name, double health, double attack, double speed, String weaponName, double weaponAttack,
                     WeaponType weaponType) {

        // Cette instruction appelle le constructeur public Character(String name, double health, double attack, double speed, Weapon weapon)
        // Vous pouvez également initialiser tous les attributs un à un si vous voulez
        this(name, health, attack, speed, new Weapon(weaponName, weaponAttack, weaponType));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Weapon getWeapon() {
        return weapon;
    }


    public void equipWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        attack += newWeapon.getAttack();

        // On vérifie si l'arme n'est pas déjà dans l'inventaire avant de l'ajouter
        if (findWeaponByName(newWeapon.getName()) == null) {
            inventory.addItem(newWeapon);
        }
    }

    // Surcharge de la fonction equipWeapon() pour pouvoir équiper une arme par son nom
    public void equipWeapon(String weaponName) {
        Weapon weapon = findWeaponByName(weaponName);
        if (weapon != null) {
            // On appelle la fonction equipWeapon(Weapon newWeapon) pour éviter de répéter du code
            equipWeapon(weapon);
        }
    }

    public void unequipWeapon() {
        if (weapon != null) {
            attack -= weapon.getAttack();
            this.weapon = null;
        }
    }

    public Weapon findWeaponByName(String name) {
        return inventory.findWeaponByName(name);
    }

    public void pickWeapon(Weapon weapon) {
        inventory.addItem(weapon);
    }

    public void deleteWeaponByName(String name) {
        inventory.deleteWeaponByName(name);
    }

    public void manageInventory() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1.Ajouter un élément\n2.Supprimer un élément\n3.Chercher un élément\n4.Statut");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 4);

        // On utilise un switch case pour exécuter le code correspondant au choix de l'utilisateur
        switch (choice) {
            case 1:
                _addItem(scanner);
                break;
            case 2:
                _deleteItem(scanner);
                break;
            case 3:
                _searchWeapon(scanner);
                break;
            case 4:
                System.out.println("Votre inventaire est:\n" + inventory);
                break;
        }
    }

    private void _searchWeapon(Scanner scanner) {
        System.out.println("Quel est le nom de l'arme ?");
        String weaponName = scanner.next();
        Weapon weapon = findWeaponByName(weaponName);
        if (weapon != null) {
            System.out.println("L'arme est dans l'inventaire.");
        } else {
            System.out.println("L'arme n'est pas dans l'inventaire.");
        }
    }

    private void _deleteItem(Scanner scanner) {
        System.out.println("Quel est le nom de l'arme ?");
        String weaponName = scanner.next();
        deleteWeaponByName(weaponName);
    }

    // On va séparer les instructions de la fonction manageInventory() dans des fonctions utilitaires
    // pour rendre le code plus lisible
    private void _addItem(Scanner scanner) {
        System.out.println("Quel est le nom de l'arme ?");
        String weaponName = scanner.next();

        System.out.println("Quel est l'attaque de l'arme ?");
        double weaponAttack = scanner.nextDouble();

        int weaponTypeChoice;
        do {
            System.out.println("Quel est le type de l'arme ?\n1.Sword\n2.Bow\n3.Staff");
            weaponTypeChoice = scanner.nextInt();
        } while (weaponTypeChoice < 1 || weaponTypeChoice > 3);

        // Sur une énumération la fonction values() retourne un tableau contenant toutes les valeurs de l'énumération
        // On peut donc accéder à la valeur de l'énumération en faisant WeaponType.values()[weaponTypeChoice - 1]
        // Les valeurs de l'énumération sont indexées à partir de 0, donc on fait weaponTypeChoice - 1
        // Vous pouvez également utiliser un switch case pour choisir le type de l'arme
        WeaponType weaponType = WeaponType.values()[weaponTypeChoice - 1];
        Weapon weapon = new Weapon(weaponName, weaponAttack, weaponType);
        pickWeapon(weapon);
    }


    /**
     * J'ai ajouté du code supplémentaire à la fonction attack() pour afficher des messages
     * au cours du combat et pour arrêter la boucle si un des deux personnages est K.O.
     * Aussi on vérifie si au cours du combat si l'un des personnages est K.O avant de l'attaquer.
     */
    public void attack(Character target) {
        while (this.health > 0 || target.health > 0) {

            // Mon personnage est plus rapide que la cible
            if (this.speed > target.speed) {
                target.health -= this.attack;

                // Message indiquant les dégâts infligés
                System.out.println(this.name + " attacks " + target.name + " for " + this.attack + " damage.");

                // Si la cible est K.O, on arrête la boucle
                if (target.health <= 0) {
                    System.out.println(target.name + " has been defeated.");
                    break;
                }

                // La cible attaque mon personnage
                this.health -= target.attack;

                // Message indiquant les dégâts infligés
                System.out.println(target.name + " attacks " + this.name + " for " + target.attack + " damage.");

                // Si mon personnage est K.O, on arrête la boucle
                if (this.health <= 0) {
                    System.out.println(this.name + " has been defeated.");
                    break;
                }
            }

            // Même logique que précédemment, mais dans le cas où la cible est plus rapide que mon personnage
            else {
                this.health -= target.attack;
                System.out.println(target.name + " attacks " + this.name + " for " + target.attack + " damage.");
                if (this.health <= 0) {
                    System.out.println(this.name + " has been defeated.");
                    break;
                }

                target.health -= this.attack;
                System.out.println(this.name + " attacks " + target.name + " for " + this.attack + " damage.");
                if (target.health <= 0) {
                    System.out.println(target.name + " has been defeated.");
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        // Si le personnage a une arme, on l'affiche
        if (weapon != null) {
            return "Character(" +
                    "name='" + name + '\'' +
                    ", health=" + health +
                    ", attack=" + attack +
                    ", speed=" + speed +
                    ", weapon=" + weapon +
                    ')';
        }

        // Sinon, on n'affiche pas l'arme
        return "Character(" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", speed=" + speed +
                ')';
    }
}
