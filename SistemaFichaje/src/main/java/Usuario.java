public class Usuario {

    private String nombre, apellido, dni, correo, password, perfil;

    public Usuario(){

    }

    public Usuario(String nombre, String apellido, String dni, String correo, String password, String perfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.password = password;
        this.perfil = perfil;
    }

    @Override
    public String toString(){
        return "El usuario: "+nombre+" "+apellido+" con dni: "+dni+" y correo eléctronico: "+correo+" es: "+perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPerfil() {
        return perfil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
