import java.util.Scanner;

public class Auth {

    static String usuario = "Felipe";
    static String password = "9991";

    public static boolean login() {

        Scanner sc = new Scanner(System.in);

        int intentos = 0;

        while (intentos < 3) {

            System.out.print("Usuario: ");
            String u = sc.nextLine();

            System.out.print("Password: ");
            String p = sc.nextLine();

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