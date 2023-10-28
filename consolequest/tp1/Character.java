package consolequest.tp1;

public class Character {
    private String name;
    private double health;
    private double attack;
    private double speed;
    private Weapon weapon;

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
    }

    public void unequipWeapon() {
        attack -= weapon.getAttack();
        this.weapon = null;
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
