package consolequest.tp1;

import consolequest.tp2.WeaponType;

public class Weapon {
    private final String name;
    private final double attack;
    private final WeaponType type;

    public Weapon(String name, double attack, WeaponType type) {
        this.name = name;
        this.attack = attack;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public double getAttack() {
        return attack;
    }

    public WeaponType getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        // instanceof vérifie si l'objet est une instance de la classe spécifiée.
        if (!(obj instanceof Weapon)) {
            return false;
        }

        Weapon weapon = (Weapon) obj;
        return weapon.getName().equals(this.name) && weapon.getAttack() == this.attack && weapon.getType() == this.type;
    }

    @Override
    public String toString() {
        return "Weapon(name=" + name + ", attack=" + attack + ", type=" + type + ")";
    }


}
