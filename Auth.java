import java.util.Scanner;

public class Auth {

    static String usuario = "admin";
    static String password = "1234";

    public static boolean login() {

        Scanner sc = new Scanner(System.in);
        sc.close();

        System.out.print("Usuario: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        if (u.equals(usuario) && p.equals(password)) {
            return true;
        }

        return false;
    }
}