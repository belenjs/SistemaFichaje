package controller;

import model.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestionFichajes {

    public GestionFichajes(){

    }

    public boolean realizarFichaje(Usuario usuarioLogueado){
        if(usuarioLogueado == null){
            return false;
        }
        if(!usuarioLogueado.getPerfil().equalsIgnoreCase("trabajador")){
            return false;
        }
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter horaFormateada = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        String fechaHora = ahora.format(horaFormateada);

        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("horas.txt", true));
            printWriter.println(usuarioLogueado.getCorreo() + " - " + fechaHora);
            printWriter.close();
            return true;
        } catch (IOException e) {
            return false;
        }

    }
}
