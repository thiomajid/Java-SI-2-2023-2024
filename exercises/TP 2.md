## Etape 1
Dans le dossier **ConsoleQuest** que nous avons créé lors du TP1, nous allons créer un dossier nommer **tp2** dans lequel nous allons mettre nos nouvelles classes.
>[!info]
>Normalement votre projet aura la structure suivante:
>- ConsoleQuest (dossier racine du projet)
>	- tp1 (dossier contenant le code du TP1)
>		- Character.java
>		- Weapon.java
>	- tp2 (dossier dans lequel nous allons placer les nouvelles classes pour ce TP)




## Etape 2
Créer le fichier `Inventory.java` dans lequel nous allons définir la classe `Inventory` qui a la composition suivante:
- L'attribut privé `weapons` qui est une liste d'objets de type `Weapon`.
- La méthode **publique** `addWeapon` qui prend en paramètre un objet de `Weapon` et l'ajoute à la liste `weapons`.
- Un getter et un setter pour l'attribut `weapons`.
- Une surchage de la méthode `toString` qui retourne les informations de l'inventaire sous la forme: `Inventory(weapons=[Weapon(name=<name_1>, attack=<attack_1>), Weapon(name=<name_2>, attack=<attack_2>)])`.
