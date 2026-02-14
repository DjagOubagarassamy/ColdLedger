import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = input.nextLine();

        System.out.println("Hello " + name + "\n Are you gay ? (true/false)");

        boolean bool = false;
        boolean saisieValide = false;
        int choix = 0;

        do {
            while (!saisieValide) {
                try {
                    bool = input.nextBoolean();
                    saisieValide = true;
                } catch (InputMismatchException e) {
                    System.out.println("Try again, true/false");
                    input.next();
                }
            }
            if (bool) {
                System.out.println("Ahhh you are gay, be ashamed");
            } else {
                System.out.println("Pleasure to meet you sir");
            }

            System.out.println("What do you want to do ? \n");
            System.out.println("1 - Faire une addition");
            System.out.println("2 - Faire une addition");
            System.out.println("3 - Faire une addition");
            System.out.println("4 - Faire une addition");
            System.out.println("400 - Test");
            System.out.println("5 - Quitter");
            choix = input.nextInt();
            while (!input.hasNextInt()) {
                System.out.println("Try again");
                input.next();
            }
            if (choix == 400) {
                System.out.println("Test réussi");
            }
        } while (choix != 5);
        System.out.println("Have a nice day, Sir. \n See you next time");
        input.close();
    }
}
