package view;

import controller.GestionUsuarios;
import model.Usuario;

import java.util.Scanner;

public class VistaMenus {

    public VistaMenus(){

    }

    public static void menuAdministrador(Scanner sc, GestionUsuarios gestionUsuarios, Usuario usuarioLogueado){
        int opcion;
        do {
            System.out.println("\n---MENÚ ADMINISTRADOR---");
            System.out.println("1. Dar de alta a un trabajador");
            System.out.println("2. Dar de baja a un trabajador");
            System.out.println("3. Ver los datos de un trabajador por su DNI");
            System.out.println("4. Ver el listado de trabajadores de la empresa");
            System.out.println("5. Cambiar contraseña del trabajador");
            System.out.println("6. Ver los registros de fichaje de la jornada");
            System.out.println("0. Salir del menú");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }



            switch (opcion) {
                case 1:
                    System.out.println("Opción 1 pendiente de implementar");
                    break;
                case 2:
                    System.out.println("Opción 2 pendiente de implementar");
                    break;
                case 3:
                    System.out.println("Opción 3 pendiente de implementar");
                    break;
                case 4:
                    System.out.println("Opción 4 pendiente de implementar");
                    break;
                case 5:
                    System.out.println("Opción 5 pendiente de implementar");
                    break;
                case 6:
                    System.out.println("Opción 6 pendiente de implementar");
                    break;
                case 0:
                    System.out.println("Saliendo del menú administrador...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while(opcion != 0);

    }

    public static void menuTrabajador(Scanner sc, GestionUsuarios gestionUsuarios, Usuario usuarioLogueado){
        int opcion;
        do {
            System.out.println("\n=== MENÚ TRABAJADOR ===");
            System.out.println("1. Realizar fichaje");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Fichaje pendiente de implementar");
                    break;
                case 0:
                    System.out.println("Saliendo del menú trabajador...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while(opcion != 0);

    }
}
