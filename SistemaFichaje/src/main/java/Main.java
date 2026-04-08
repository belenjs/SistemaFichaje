public class Main {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Belén", "Jiménez", "123456789A", "admin@example.com", "admin123", "admin");
        Usuario usuario2 = new Usuario("Raúl", "Jiménez", "234567891B", "trabajador1@example.com", "trabajador123", "trabajador");


        System.out.println(usuario1.toString());
        System.out.println(usuario2.toString());
    }
}
