package controller;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    private List<Usuario> listaUsuarios;

    public GestionUsuarios() {
        listaUsuarios = new ArrayList<>();
    }

    public boolean agregarUsuario(Usuario usuario){
        if(buscarPorDni(usuario.getDni()) != null || buscarPorCorreo(usuario.getCorreo()) != null){
            return false;
        } else {
            listaUsuarios.add(usuario);
            return true;
        }
    }

    public Usuario buscarPorCorreo(String correo){
        for(Usuario usuario : listaUsuarios){
            if(usuario.getCorreo().equalsIgnoreCase(correo)){
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarPorDni(String dni){
        for(Usuario usuario : listaUsuarios){
            if(usuario.getDni().equalsIgnoreCase(dni)){
                return usuario;
            }
        }
        return null;
    }

    public Usuario iniciarSesion(String correo, String password){
        for(Usuario usuario : listaUsuarios){
          if(usuario.getCorreo().equalsIgnoreCase(correo) && usuario.getPassword().equals(password)){
              return usuario;
          }
        }
        return null;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}
