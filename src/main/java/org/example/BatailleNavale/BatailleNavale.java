package org.example.BatailleNavale;

import java.util.Scanner;

public class BatailleNavale {
    public static void main(String[] args) {
        char[][] grille = new char[5][5]; // Grille 5x5 pour simplifier l'exemple

        // Initialiser la grille avec des espaces vides
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                grille[i][j] = '*';
            }
        }

        // Afficher la grille
        for (char[] ligne : grille) {
            for (char cellule : ligne) {
                System.out.print(cellule + " ");
            }
            System.out.println();
        }

        // Placer 3 navires aléatoirement sur la grille
        int nombreNavires = 3;
        int naviresRestants = nombreNavires;
        while (nombreNavires > 0) {
            int x = (int) (Math.random() * grille.length);
            int y = (int) (Math.random() * grille[0].length);
            if (grille[x][y] != 'N') {
                grille[x][y] = 'N';
                nombreNavires--;
            }
        }

        // Jouer à la bataille navale
        Scanner scanner = new Scanner(System.in);
        int coups = 0;
        while (naviresRestants > 0) {
            int ligne = -1;
            int colonne = -1;

            // Demander à l'utilisateur de saisir une ligne et une colonne valides
            while (ligne < 0 || ligne > 4 || colonne < 0 || colonne > 4) {
                System.out.print("Entrez la ligne (0-4) : ");
                ligne = scanner.nextInt();
                System.out.print("Entrez la colonne (0-4) : ");
                colonne = scanner.nextInt();

                if (ligne < 0 || ligne > 4 || colonne < 0 || colonne > 4) {
                    System.out.println("Veuillez saisir des chiffres entre 0 et 4.");
                }
            }

            if (grille[ligne][colonne] == 'N') {
                System.out.println("Touché !");
                grille[ligne][colonne] = 'X';
                naviresRestants--;
            } else {
                System.out.println("Raté !");
            }

            // Afficher la grille après chaque coup
            for (char[] ligneGrille : grille) {
                for (char cellule : ligneGrille) {
                    System.out.print(cellule + " ");
                }
                System.out.println();
            }

            coups++;
        }

        System.out.println("Tous les navires ont été coulés en " + coups + " coups !");
        scanner.close();
    }
}
