package org.example.gestionInventaire;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class gestionInventaire {
    public static void main(String[] args) {
        // Créer un inventaire vide
        Map<String, Integer> inventaire = new HashMap<>();

        // Scanner pour la saisie utilisateur
        Scanner scanner = new Scanner(System.in);

        // Boucle principale du programme
        while (true) {
            System.out.println("Que souhaitez-vous faire ?\n1. Ajouter un article\n2. Retirer un article\n3. Consulter l'inventaire" +
                    "\n4. Quitter");

            int choix = saisirEntier(scanner, "Votre choix : ");

            switch (choix) {
                case 1:
                    ajouterArticle(inventaire, scanner);
                    break;
                case 2:
                    retirerArticle(inventaire, scanner);
                    break;
                case 3:
                    consulterInventaire(inventaire);
                    break;
                case 4:
                    System.out.println("Merci d'avoir utilisé notre service de gestion d'inventaire.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez saisir un numéro valide.");
            }
        }
    }

    // Méthode pour demander à l'utilisateur de saisir un entier jusqu'à ce que la saisie soit valide
    public static int saisirEntier(Scanner scanner, String message) {
        int entier;
        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.println("Saisie invalide. Veuillez entrer un entier.");
                System.out.print(message);
                scanner.next(); // Effacer la saisie incorrecte
            }
            entier = scanner.nextInt();
            scanner.nextLine(); // Lire la fin de la ligne
        } while (entier <= 0); // Demander à nouveau si l'entier est négatif ou nul
        return entier;
    }

    // Méthode pour ajouter un article à l'inventaire
    public static void ajouterArticle(Map<String, Integer> inventaire, Scanner scanner) {
        System.out.print("Entrez le nom de l'article à ajouter : ");
        String article = scanner.nextLine();
        int quantite = saisirEntier(scanner, "Entrez la quantité de l'article à ajouter : ");

        if (inventaire.containsKey(article)) {
            // Si l'article existe déjà, mettre à jour la quantité
            int nouvelleQuantite = inventaire.get(article) + quantite;
            inventaire.put(article, nouvelleQuantite);
        } else {
            // Sinon, ajouter l'article avec sa quantité
            inventaire.put(article, quantite);
        }

        System.out.println("Article ajouté avec succès à l'inventaire.");
    }

    // Méthode pour retirer un article de l'inventaire
    public static void retirerArticle(Map<String, Integer> inventaire, Scanner scanner) {
        System.out.print("Entrez le nom de l'article à retirer : ");
        String article = scanner.nextLine();

        if (inventaire.containsKey(article)) {
            // Si l'article existe, demander la quantité à retirer
            System.out.print("Entrez la quantité de l'article à retirer : ");
            int quantite = saisirEntier(scanner, "Entrez la quantité de l'article à retirer : ");

            int quantiteActuelle = inventaire.get(article);
            if (quantite <= quantiteActuelle) {
                // Si la quantité à retirer est inférieure ou égale à la quantité actuelle, mettre à jour la quantité
                int nouvelleQuantite = quantiteActuelle - quantite;
                if (nouvelleQuantite == 0) {
                    // Si la nouvelle quantité est zéro, retirer complètement l'article de l'inventaire
                    inventaire.remove(article);
                } else {
                    inventaire.put(article, nouvelleQuantite);
                }
                System.out.println("Article retiré avec succès de l'inventaire.");
            } else {
                System.out.println("Quantité invalide. La quantité à retirer dépasse la quantité actuelle.");
            }
        } else {
            System.out.println("Article non trouvé dans l'inventaire.");
        }
    }

    // Méthode pour consulter l'inventaire
    public static void consulterInventaire(Map<String, Integer> inventaire) {
        System.out.println("Inventaire actuel :");
        for (Map.Entry<String, Integer> entry : inventaire.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
