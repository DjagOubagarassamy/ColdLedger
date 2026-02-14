//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//
//public class Main {
//
//    public static void main(String[] args) {
//        System.out.println("Hello World");
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("Please enter your name: ");
//        String name = input.nextLine();
//
//        System.out.println("Hello " + name + "\n Are you gay ? (true/false)");
//
//        boolean bool = false;
//        boolean saisieValide = false;
//        int choix = 0;
//
//        do {
//            while (!saisieValide) {
//                try {
//                    bool = input.nextBoolean();
//                    saisieValide = true;
//                } catch (InputMismatchException e) {
//                    System.out.println("Try again, true/false");
//                    input.next();
//                }
//            }
//            if (bool) {
//                System.out.println("Ahhh you are gay, be ashamed");
//            } else {
//                System.out.println("Pleasure to meet you sir");
//            }
//
//            System.out.println("What do you want to do ? \n");
//            System.out.println("1 - Faire une addition");
//            System.out.println("2 - Faire une addition");
//            System.out.println("3 - Faire une addition");
//            System.out.println("4 - Faire une addition");
//            System.out.println("400 - Test");
//            System.out.println("5 - Quitter");
//            while (!input.hasNextInt()) {
//                System.out.println("Try again");
//                input.next();
//            }
//            choix = input.nextInt();
//            switch (choix)
//            {
//                case 1:
//                    System.out.println("Combien de termes ?");
//                    while (!input.hasNextInt()) {
//                        System.out.println("Réessayez avec un entier");
//                        input.next();
//                    }
//                    int nbTermes = input.nextInt();
//                    for (int i = 0; i < nbTermes; i++) {
//                        System.out.println("Terme " + i + " ?");
//                        while (!input.hasNextInt()) {
//                            System.out.println("Entrez un nombre ou un chiffre.");
//                            input.next();
//                        }
//
//                    }
//                    choix = input.nextInt();
//            }
//        } while (choix != 5);
//        System.out.println("Have a nice day, Sir. \n See you next time");
//        input.close();
//    }
//}
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        boolean continuer = true;
//
//
//
//        while (continuer) {
//            // Saisie du premier nombre avec contrôle
//            double n1 = saisirNombre(sc, "Entrez le premier nombre : ");
//
//            System.out.print("Opérateur (+, -, *, /) ou 'q' pour quitter : ");
//            String op = sc.next();
//
//            if (op.equals("q")) break;
//
//            // Saisie du second nombre
//            double n2 = saisirNombre(sc, "Entrez le second nombre : ");
//
//            try {
//                double resultat = calculer(n1, n2, op);
//                System.out.println("Résultat : " + n1 + " " + op + " " + n2 + " = " + resultat);
//            } catch (Exception e) {
//                System.out.println("Erreur : " + e.getMessage());
//            }
//
//            System.out.println("--- Nouveau calcul ---");
//        }
//        sc.close();
//    }
//
//    // Méthode de saisie contrôlée réutilisable
//    public static double saisirNombre(Scanner sc, String message) {
//        System.out.print(message);
//        while (!sc.hasNextDouble()) {
//            System.out.println("Ce n'est pas un nombre valide !");
//            sc.next(); // Nettoyage du tampon
//        }
//        return sc.nextDouble();
//    }
//}

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ColdLedger - Financial Transaction Engine
 * Core logic for Java 21 certification showcase.
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choix = 0;

        System.out.println("--- 🧊 Welcome to ColdLedger 🧊 ---");
        System.out.println("Secure Transaction Engine Initialized.\n");

        do {
            afficherMenu();
            choix = saisirEntier(input, "Selection: ");

            switch (choix) {
                case 1 -> lancerCalculatrice(input);
                case 2 -> simulationTransactions(input);
                case 5 -> System.out.println("\nExiting ColdLedger. Have a nice day, Sir.");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (choix != 5);

        input.close();
    }

    private static void afficherMenu() {
        System.out.println("\nMAIN MENU");
        System.out.println("1 - Financial Calculator");
        System.out.println("2 - Simulated Transactions");
        System.out.println("5 - Exit");
    }
    private static void lancerCalculatrice(Scanner sc) {
        System.out.println("\n--- Financial Calculator ---");
        double n1 = saisirDouble(sc, "Enter first amount: ");
        System.out.print("Operator (+, -, *, /): ");
        String op = sc.next();
        double n2 = saisirDouble(sc, "Enter second amount: ");

        try {
            double result = switch (op) {
                case "+" -> n1 + n2;
                case "-" -> n1 - n2;
                case "*" -> n1 * n2;
                case "/" -> {
                    if (n2 == 0) throw new ArithmeticException("Division by zero!");
                    yield n1 / n2;
                }
                default -> throw new IllegalArgumentException("Unknown operator: " + op);
            };
            System.out.printf("Result: %.2f %s %.2f = %.2f\n", n1, op, n2, result);
        } catch (Exception e) {
            System.out.println("Calculation Error: " + e.getMessage());
        }
    }

    private static void simulationTransactions(Scanner sc) {
        System.out.println("\n--- Transaction Simulation ---");
        boolean isGay = false; // Reprise de ton test initial
        System.out.print("Authorize encrypted transfer? (true/false): ");

        while (!sc.hasNextBoolean()) {
            System.out.println("Invalid input. Type 'true' or 'false'.");
            sc.next();
        }
        isGay = sc.nextBoolean();

        if (isGay) {
            System.out.println("Status: Transfer Flagged - High Priority.");
        } else {
            System.out.println("Status: Standard Transfer Authorized.");
        }
    }

    /**
     * OUTILS : Saisies sécurisées (Input Validation)
     */
    private static int saisirEntier(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Error: Please enter a valid number.");
            sc.next();
        }
        return sc.nextInt();
    }

    private static double saisirDouble(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.println("Error: Please enter a valid decimal amount.");
            sc.next();
        }
        return sc.nextDouble();
    }
}
