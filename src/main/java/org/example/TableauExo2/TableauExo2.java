package org.example.TableauExo2;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TableauExo2 {
    public static void main(String[] args) {
        // Initialiser le tableau avec les valeurs de paires
        Integer[] pairs = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};

        // Mélanger les valeurs du tableau
        shuffleArray(pairs);

        // Tableau pour garder une trace des cartes correctement appariées
        boolean[] cardsRevealed = new boolean[pairs.length];

        // Boucle principale du jeu
        Scanner scanner = new Scanner(System.in);
        while (!allPairsRevealed(cardsRevealed)) {
            // Afficher l'état actuel du plateau de jeu
            displayBoard(pairs, cardsRevealed);

            // Demander à l'utilisateur de choisir deux indices de carte à retourner
            System.out.print("Choisissez deux indices de carte à retourner (séparés par un espace) : ");
            int index1 = scanner.nextInt();
            int index2 = scanner.nextInt();

            // Vérifier si les indices sont valides
            if (index1 < 0 || index1 >= pairs.length || index2 < 0 || index2 >= pairs.length) {
                System.out.println("Indices de carte non valides. Veuillez réessayer.");
                continue;
            }

            // Vérifier si les cartes correspondantes ont déjà été révélées
            if (cardsRevealed[index1] || cardsRevealed[index2]) {
                System.out.println("Les cartes correspondantes ont déjà été correctement appariées. Veuillez choisir à nouveau.");
                continue;
            }

            // Vérifier si les indices choisis sont les mêmes
            if (index1 == index2) {
                System.out.println("Les indices choisis ne peuvent pas être identiques. Veuillez choisir à nouveau.");
                continue;
            }

            // Vérifier si les cartes correspondent
            if (pairs[index1].equals(pairs[index2])) {
                System.out.println("Bravo ! Vous avez trouvé une paire !");
                cardsRevealed[index1] = true;
                cardsRevealed[index2] = true;
            } else {
                System.out.println("Dommage, les cartes ne correspondent pas.");
            }
        }
        System.out.println("Félicitations ! Vous avez trouvé toutes les paires !");
        scanner.close();
    }

    // Méthode pour mélanger les valeurs d'un tableau
    public static void shuffleArray(Integer[] array) {
        Collections.shuffle(Arrays.asList(array));
    }

    // Méthode pour afficher l'état actuel du plateau de jeu
    public static void displayBoard(Integer[] pairs, boolean[] cardsRevealed) {
        for (int i = 0; i < pairs.length; i++) {
            if (cardsRevealed[i]) {
                System.out.print(pairs[i] + " ");
            } else {
                System.out.print("* ");
            }
        }
        System.out.println();
    }

    // Méthode pour vérifier si toutes les paires ont été correctement appariées
    public static boolean allPairsRevealed(boolean[] cardsRevealed) {
        for (boolean cardRevealed : cardsRevealed) {
            if (!cardRevealed) {
                return false;
            }
        }
        return true;
    }
}
