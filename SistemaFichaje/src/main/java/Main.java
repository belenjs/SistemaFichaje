import controller.GestionFichajes;
import controller.GestionTrabajadores;
import controller.GestionUsuarios;
import model.Usuario;
import view.VistaMenus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        GestionTrabajadores gestionTrabajadores = new GestionTrabajadores(gestionUsuarios);
        GestionFichajes gestionFichajes = new GestionFichajes();

        // Crear usuarios iniciales
        Usuario admin = new Usuario(
                "Belén",
                "Jiménez",
                "1234A",
                "admin@empresa.com",
                "1234",
                "admin"
        );

        Usuario trabajador = new Usuario(
                "Laura",
                "Gomez",
                "1234B",
                "laura@empresa.com",
                "abcd",
                "trabajador"
        );

        boolean adminAgregado = gestionUsuarios.agregarUsuario(admin);
        boolean trabajadorAgregado = gestionUsuarios.agregarUsuario(trabajador);


        System.out.println(" ---- SISTEMA DE LOGIN Y FICHAJE ---- ");

        if (adminAgregado) {
            System.out.println("Administrador inicial creado correctamente.");
        } else {
            System.out.println("No se pudo crear el administrador inicial.");
        }

        if (trabajadorAgregado) {
            System.out.println("Trabajador inicial creado correctamente.");
        } else {
            System.out.println("No se pudo crear el trabajador inicial.");
        }

        System.out.println("\n ---- INICIO DE SESIÓN ---- ");
        System.out.print("Introduce tu correo: ");
        String correo = scanner.nextLine();

        System.out.print("Introduce tu contraseña: ");
        String password = scanner.nextLine();

        Usuario usuarioLogueado = gestionUsuarios.iniciarSesion(correo, password);

        if (usuarioLogueado != null) {
            System.out.println("\nLogin correcto.");
            System.out.println("Bienvenido/a, " + usuarioLogueado.getNombre() + ".");

            if (usuarioLogueado.getPerfil().equalsIgnoreCase("admin")) {
                VistaMenus.menuAdministrador(scanner, gestionUsuarios, gestionTrabajadores, gestionFichajes);
            } else if (usuarioLogueado.getPerfil().equalsIgnoreCase("trabajador")) {
                VistaMenus.menuTrabajador(scanner, usuarioLogueado, gestionFichajes);
            }
        } else {
            System.out.println("\nCorreo o contraseña incorrectos.");
        }

        scanner.close();
    }
}