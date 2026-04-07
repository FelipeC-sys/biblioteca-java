import java.io.Console;
import java.util.Scanner;

public class Auth {

    static String usuario = "Felipe";
    static String password = "9991";

    public static boolean login() {

        Scanner sc = new Scanner(System.in);
        Console console = System.console();

        int intentos = 0;

        while (intentos < 3) {

            System.out.print("Usuario: ");
            String u = sc.nextLine();

            String p;

            if (console != null) {
                char[] passArray = console.readPassword("Password: ");
                p = new String(passArray);
            } else {
                System.out.print("Password: ");
                p = sc.nextLine();
            }

            if (u.equals(usuario) && p.equals(password)) {
                return true;
            }

            intentos++;
            System.out.println("Datos incorrectos");
        }

        System.out.println("Sistema bloqueado");
        return false;
    }
}
