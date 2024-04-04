import java.util.Scanner;

public class TableauExo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tab = {5,10,15,20,25};

        System.out.print("Trouvez un chiffre du tableau");
        int guessUser = scanner.nextInt();

        boolean found = false;

        int indexTableau = -1;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == guessUser) {
                found = true;
                indexTableau = i;
                break;
            }
        }


        String result = found ? ("Votre chiffre " + guessUser + " a été trouvé index " + indexTableau + " dans le tableau") : "Votre chiffre n'est pas dans le tableau";

        System.out.println(result);

        scanner.close();
    }
}
