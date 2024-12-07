import java.util.Scanner;

// Benutzerdefinierte Ausnahme
class StringTooLongException extends Exception {
    public StringTooLongException(String message) {
        super(message);
    }
}

public class Checker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Bitte geben Sie einen String ein (oder das Code-Wort 'Done' um das Programm zu beenden):");

        while (true) {
            input = scanner.nextLine();

            // Überprüfen, ob der Benutzer "Done" eingegeben hat
            if (input.equalsIgnoreCase("Done")) {
                System.out.println("Programm beendet.");
                break;
            }

            try {
                // Überprüfen, ob der String zu lang ist
                if (input.length() > 20) {
                    throw new StringTooLongException("Der eingegebene String ist zu lang! Maximal 20 Zeichen erlaubt.");
                }
                System.out.println("Eingegebener String: " + input);
            } catch (StringTooLongException e) {
                System.out.println(e.getMessage());
                // Programm nicht beenden, sondern weiter machen
            }
        }

        scanner.close();
    }
}
