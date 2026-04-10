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
        if(existeDni(usuario.getDni()) || existeCorreo(usuario.getCorreo())){
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

    public boolean existeDni(String dni){
        return buscarPorDni(dni) != null;
    }

    public boolean existeCorreo(String correo){
        return buscarPorCorreo(correo) != null;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}
