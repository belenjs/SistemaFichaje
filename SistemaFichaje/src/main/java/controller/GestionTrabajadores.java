package controller;

import model.Usuario;

import java.util.List;

public class GestionTrabajadores {
    private GestionUsuarios gestionUsuarios;

    public GestionTrabajadores(GestionUsuarios gestionUsuarios){
        this.gestionUsuarios = gestionUsuarios;
    }

    public boolean altaTrabajador(String nombre, String apellido, String dni, String correo, String password){
        Usuario usuarioTrabajador = new Usuario(nombre, apellido, dni, correo, password, "trabajador");
        return gestionUsuarios.agregarUsuario(usuarioTrabajador);
    }

    public boolean bajaTrabajador(String dni) {
        Usuario usuario = gestionUsuarios.buscarPorDni(dni);

        if (usuario == null) {
            return false;
        }
        if (!usuario.getPerfil().equalsIgnoreCase("trabajador")) {
            return false;
        }
        return gestionUsuarios.getListaUsuarios().remove(usuario);
    }

    public void mostrarTrabajadores(){
        boolean hayTrabajadores = false;
        for(Usuario usuario : gestionUsuarios.getListaUsuarios()){
            if(usuario.getPerfil().equalsIgnoreCase("trabajador")){
                System.out.println(usuario);
                hayTrabajadores = true;
            }
        }
        if(!hayTrabajadores){
            System.out.println("No hay trabajadores registrados");
        }
    }

    public void mostrartTrabajadorPorDni(String dni){
        Usuario usuario = gestionUsuarios.buscarPorDni(dni);
        if(usuario == null){
            System.out.println("No existe ningún usuario con ese DNI");
        } else if(!usuario.getPerfil().equalsIgnoreCase("trabajador")){
            System.out.println("El usuario encontrado no es un trabajador");
        } else {
            System.out.println(usuario);
        }
    }

    public boolean cambiarPassword(String dni, String nuevaPassword){
        Usuario usuarioTrabajador = gestionUsuarios.buscarPorDni(dni);
        if(usuarioTrabajador == null){
            return  false;
        }
        if(!usuarioTrabajador.getPerfil().equalsIgnoreCase("trabajador")){
            return  false;
        }
        usuarioTrabajador.setPassword(nuevaPassword);
        return true;
    }
}
