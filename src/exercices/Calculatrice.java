import java.util.Scanner;
public class Calculatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le premier nombre : ");
        double a = scanner.nextDouble();
        System.out.print("Entrez l'opérateur (+, -, *, /) : ");
        char op = scanner.next().charAt(0);
        System.out.print("Entrez le second nombre : ");
        double b = scanner.nextDouble();
        double resultat = calculer(a, b, op);
        if (resultat != Double.NaN) {
            System.out.println("Résultat : " + resultat);
        }
        scanner.close();
    }

    public static double calculer(double a, double b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0) return a / b;
                else {
                    System.out.println("Erreur: division par zéro");
                    return Double.NaN;
                }
            default:
                System.out.println("Opérateur invalide");
                return Double.NaN;
        }
    }
}
