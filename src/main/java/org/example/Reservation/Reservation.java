package org.example.Reservation;

import java.util.Scanner;

public class Reservation {
    public static void main(String[] args) {
        // Nombre total de sièges dans le théâtre
        final int nombreSieges = 6;

        // Tableau pour représenter les sièges (false = disponible, true = réservé)
        boolean[] sieges = new boolean[nombreSieges];

        // Scanner pour la saisie utilisateur
        Scanner scanner = new Scanner(System.in);

        // Affichage de la disposition des sièges
        System.out.println("Disposition des sièges :");
        for (int i = 0; i < nombreSieges; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        // Boucle principale du programme
        while (true) {
            // Demander à l'utilisateur de choisir un siège
            System.out.print("Choisissez un siège (numéro de 1 à " + nombreSieges + ", ou 0 pour quitter) : ");
            int choix = scanner.nextInt();

            // Vérifier si l'utilisateur souhaite quitter
            if (choix == 0) {
                System.out.println("Merci d'avoir utilisé notre service de réservation de sièges.");
                break;
            }

            // Vérifier si le choix de l'utilisateur est valide
            if (choix < 1 || choix > nombreSieges) {
                System.out.println("Choix invalide. Veuillez saisir un numéro de siège valide.");
                continue;
            }

            // Vérifier si le siège est déjà réservé
            if (sieges[choix - 1]) {
                System.out.println("Ce siège est déjà réservé. Veuillez choisir un autre siège.");
            } else {
                // Réserver le siège
                sieges[choix - 1] = true;
                System.out.println("Siège " + choix + " réservé avec succès !");
            }

            // Affichage de la disposition des sièges
            System.out.println("Disposition des sièges :");
            for (int i = 0; i < nombreSieges; i++) {
                if (sieges[i]) {
                    System.out.print("X ");
                } else {
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println();
        }

        // Fermer le scanner
        scanner.close();
    }
}
