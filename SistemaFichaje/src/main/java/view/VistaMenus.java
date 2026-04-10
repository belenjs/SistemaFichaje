package view;

import controller.GestionTrabajadores;
import controller.GestionUsuarios;
import model.Usuario;

import java.util.Scanner;

public class VistaMenus {

    public VistaMenus(){

    }

    public static void menuAdministrador(Scanner sc, GestionUsuarios gestionUsuarios, GestionTrabajadores gestionTrabajadores){
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
                    System.out.print("Introduce el DNI: ");
                    String dniAlta = sc.nextLine();
                    if(gestionUsuarios.existeDni(dniAlta)){
                        System.out.println("Ya existe un usuario con ese DNI. No se puede agregar el usuario.");
                        break;
                    }
                    System.out.print("Introduce el correo: ");
                    String correoAlta = sc.nextLine();
                    if(gestionUsuarios.existeCorreo(correoAlta)){
                        System.out.println("Ya existe un usuario con ese correo. No se puede agregar el usuario.");
                        break;
                    }
                    System.out.print("Introduce el nombre: ");
                    String nombreAlta = sc.nextLine();
                    System.out.print("Introduce el apellido: ");
                    String apellidoAlta = sc.nextLine();
                    System.out.print("Introduce la contraseña: ");
                    String passwordAlta = sc.nextLine();
                    boolean altaCorrecta = gestionTrabajadores.altaTrabajador(nombreAlta,apellidoAlta,dniAlta,correoAlta,passwordAlta);

                    if(altaCorrecta){
                        System.out.println("Trabajador dado de alta de forma exitosa");
                    } else {
                        System.out.println("No se ha podido dar de alta al trabajador por existencia de DNI o correo");
                    }
                    break;
                case 2:
                    System.out.print("Introduce el DNI del trabajador que quieres dar de baja: ");
                    String dniBaja = sc.nextLine();
                    boolean bajaCorrecta = gestionTrabajadores.bajaTrabajador(dniBaja);
                    if(bajaCorrecta){
                        System.out.println("Trabajador dado de baja correctamente");
                    } else {
                        System.out.println("No se ha podido dar de baja al trabajador.");
                    }
                    break;
                case 3:
                    System.out.print("Introduce el DNI del trabajador a buscar");
                    String dni = sc.nextLine();
                    gestionTrabajadores.mostrartTrabajadorPorDni(dni);
                    break;
                case 4:
                    gestionTrabajadores.mostrarTrabajadores();
                    break;
                case 5:
                    System.out.print("Introduce el DNI del trabajador");
                    String dniPassword = sc.nextLine();
                    System.out.print("Introduce la nueva contraseña");
                    String nuevaPassword = sc.nextLine();
                    boolean passwordCambiada = gestionTrabajadores.cambiarPassword(dniPassword,nuevaPassword);
                    if(passwordCambiada){
                        System.out.println("Contraseña cambiada correctamente");
                    } else {
                        System.out.println("No se ha podido cambiar la contraseña.");
                    }
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
