package org.example.JanKenPon;

import java.util.Scanner;

public class JanKenPon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le jeu de Pierre-Papier-Ciseaux !\nVeuillez choisir un nombre pour jouer:");
        System.out.println("1. Pierre\n2. Papier\n3. Ciseaux\nVotre Choix:");

        int choixJoueur = scanner.nextInt();
        int choixOrdi = (int) (Math.random() * 3);

        String choixJoueurString = genererChoix(choixJoueur);
        String choixOrdiString = genererChoix(choixOrdi);

        System.out.println("Vous avez joué: " + choixJoueurString);
        System.out.println("L'ordinateur a joué: " + choixOrdiString);

        String resultat = quiGagne(choixJoueur, choixOrdi);
        System.out.println(resultat);

        scanner.close();
    }

    public static String genererChoix(int choix) {
        switch (choix) {
            case 1:
                return "Pierre";
            case 2:
                return "Papier";
            case 3:
                return "Ciseaux";
            default:
                return "Choix invalide";
        }
    }

    // Méthode pour déterminer le gagnant
    public static String quiGagne(int choixJoueur, int choixOrdi) {
        if (choixJoueur == choixOrdi) {
            return "Égalité !";
        } else if ((choixJoueur == 1 && choixOrdi == 3) ||
                (choixJoueur == 2 && choixOrdi == 1) ||
                (choixJoueur == 3 && choixOrdi == 2)) {
            return "Joueur a gagné !";
        } else {
            return "L'ordinateur a gagné !";
        }
    }
}

