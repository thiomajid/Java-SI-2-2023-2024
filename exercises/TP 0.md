Enseignant: Abdoul Majid Thiombiano/[@thiomajid](https://github.com/thiomajid)

>[!Info]
>Les exercices suivant seront effectués dans un dossier nommé `tp0`.
>L'objectif de ce TP est de vous familiariser avec la syntaxe du Java.
## Exercice 1

Créer une classe nommée `Equation` dont le but est de résoudre les équations du second degré.
Dans un premier temps vous allez lire à partir du clavier 3 nombres réels $a, b, c$ pour l'équation: $ax^2 + bx +c = 0$.
Pour rappel on a:
$$
\begin{align}
\Delta = b^2 - 4ac \\
\end{align}
$$

Dans le cas où l'équation admet deux solutions réelles, on a:
$$
x_1 = \frac{-b - \sqrt{\Delta}}{2a} \; \text{et } x_2 = \frac{-b + \sqrt{\Delta}}{2a}
$$
Dans le cas de la racine double:
$$
x_0 = \frac{-b}{2a}
$$
Si l'équation n'admet pas de solution réelle, on affichera le message suivant: *Aucune solution dans R*.


<u>NB</u>: 
La fonction `main` est définie comme suit:
```java
public static void main(String[] args){
	// vos instructions
}
```


Pour lire des valeurs à partir du clavier en Java, on procède comme suit:
```java
// on importe la classe Scanner
// Les importations se font en dehors des classes

import java.util.Scanner;

// Dans votre programme créer une instance de Scanner
Scanner myScanner = new Scanner(System.in);

// Pour lire un entier on utilise la méthode nextInt() du Scanner
int value = myScanner.nextInt();
```

## Exercice 2
Dans le fichier nommé `Calculator.java`, créer la classe `Calculator`.
On définira les méthodes suivantes:
- `add` pour faire la somme de deux entiers.
-  `substract` pour faire la différence entre deux entiers.
- `multiply` pour la multiplication
- `divide` pour la division

Dans la fonction principale de la classe, l'utilisateur sera invité à choisir l'une des quatre opérations mentionnées précédemment à travers le menu suivant:
1. Addition
2. Soustraction
3. Multiplication
4. Division
5. Quitter













---
<p><q>Simplicity is the highest sophistication.</q>, Leonardo Da Vinci.</p> 