package org.example.Jeu2;

import java.util.Scanner;

public class Jeu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Liste de mots à deviner
        String[] mots = {"fruit", "arbre", "riz", "jeux", "alphabet"};

        // Choisir un mot aléatoire dans la liste
        String motADeviner = mots[(int) (Math.random() * mots.length)];

        // Nombre maximum d'essais
        int maxEssais = 15;
        int essaisRestants = maxEssais;

        // Mot caché avec des tirets
        StringBuilder motCache = new StringBuilder();
        for (int i = 0; i < motADeviner.length(); i++) {
            motCache.append("-");
        }

        System.out.println("Bienvenue dans le jeu du pendu !");
        System.out.println("Le mot à deviner contient " + motADeviner.length() + " lettres.");

        // Boucle principale du jeu
        while (essaisRestants > 0 && motCache.toString().contains("-")) {
            System.out.println("Mot à deviner : " + motCache.toString());
            System.out.println("Il vous reste " + essaisRestants + " essais.");

            // Demander à l'utilisateur de deviner une lettre
            System.out.print("Devinez une lettre : ");
            char lettre = scanner.next().charAt(0);

            // Vérifier si la lettre est dans le mot
            boolean lettreTrouvee = false;
            for (int i = 0; i < motADeviner.length(); i++) {
                if (motADeviner.charAt(i) == lettre) {
                    motCache.setCharAt(i, lettre);
                    lettreTrouvee = true;
                }
            }

            if (!lettreTrouvee) {
                System.out.println("La lettre " + lettre + " n'est pas dans le mot.");
                essaisRestants--;
            }
        }

        // Afficher le résultat du jeu
        if (motCache.toString().equals(motADeviner)) {
            System.out.println("Félicitations ! Vous avez deviné le mot : " + motADeviner);
        } else {
            System.out.println("Dommage ! Le mot à deviner était : " + motADeviner);
        }

        scanner.close();
    }
}
