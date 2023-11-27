package consolequest.tp2;

import consolequest.tp1.Weapon;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Inventory {
    private final ArrayList<Weapon> items;
    private final int capacity;

    public Inventory(int initialCapacity) {
        capacity = initialCapacity;

        // La syntaxe items = new ArrayList<Weapon>(); crée une liste qui s'étend à l'infini.
        // Pour limiter la taille de la liste, il faut utiliser la syntaxe items = new ArrayList<Weapon>(initialCapacity);
        items = new ArrayList<>(initialCapacity);
    }

    public ArrayList<Weapon> getItems() {
        return items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addItem(Weapon item) {
        if (items.size() < capacity) {
            items.add(item);
        } else {
            System.out.println("Votre inventaire est plein !!!");
        }
    }

    public Weapon findWeaponByName(String name) {
        for (Weapon item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void deleteWeaponByName(String name) {
        Weapon target = findWeaponByName(name);
        if (target != null) {
            items.remove(target);
        } else {
            System.out.println("Vous n'avez pas l'arme " + name + " dans votre inventaire");
        }
    }

    public boolean isFull() {
        return items.size() == capacity;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        String itemsInfo = "";

        // Cette opération peut être optimisée en utilisant un StringBuilder
        for (Weapon item : items) {
            itemsInfo += item + ", ";
        }

        return "Inventory(capacity=" + capacity + ", items=[" + itemsInfo + "])";
    }
}
