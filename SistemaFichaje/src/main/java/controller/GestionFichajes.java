package controller;

import model.Usuario;

import java.io.*;
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

    public void verRegistrosFichaje(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("horas.txt"));
            String linea;
            boolean hayRegistros = false;

            while((linea = bufferedReader.readLine()) != null){
                if(!linea.isBlank()){
                    System.out.println(linea);
                    hayRegistros = true;
                }
            }
            bufferedReader.close();
            if(!hayRegistros){
                System.out.println("El registro de fichajes está vacío");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero.");;
        } catch (IOException e) {
            System.out.println("No se pudo leer el fichero.");;
        }
    }
}
