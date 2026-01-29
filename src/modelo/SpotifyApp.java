package modelo;

import java.util.Scanner;

public class SpotifyApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // === PREPARACIÓN ANTES DEL MENÚ ===
        CuentaSpotify cuenta = new CuentaSpotify("admin", "1234", 5, 20);

        // Cargar canciones de prueba en la biblioteca
        cuenta.getBiblioteca().agregarCancion(
                new Cancion("Imagine", "John Lennon", 183));
        cuenta.getBiblioteca().agregarCancion(
                new Cancion("Bohemian Rhapsody", "Queen", 354));
        cuenta.getBiblioteca().agregarCancion(
                new Cancion("Billie Jean", "Michael Jackson", 294));

        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MINI SPOTIFY =====");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Crear playlist");
            System.out.println("3. Agregar canción a playlist");
            System.out.println("4. Reproducir canción");
            System.out.println("5. Listar canciones del catálogo");
            System.out.println("6. Cerrar sesión");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Usuario: ");
                    String u = sc.nextLine();
                    System.out.print("Password: ");
                    String p = sc.nextLine();

                    if (cuenta.iniciarSesion(u, p)) {
                        System.out.println("✅ Sesión iniciada correctamente");
                    } else {
                        System.out.println("❌ Usuario o contraseña incorrectos");
                    }
                    break;

                case 2:
                    System.out.print("Nombre de la playlist: ");
                    String nombrePlaylist = sc.nextLine();
                    System.out.print("Máx canciones: ");
                    int max = sc.nextInt();
                    sc.nextLine();

                    if (cuenta.agregarPlaylist(new Playlist(nombrePlaylist, max))) {
                        System.out.println("🎵 Playlist creada");
                    } else {
                        System.out.println("❌ No se pudo crear la playlist");
                    }
                    break;

                case 3:
                    System.out.print("Nombre de la playlist: ");
                    String pl = sc.nextLine();

                    System.out.print("Nombre de la canción: ");
                    String nombreCancion = sc.nextLine();

                    Cancion c = cuenta.getBiblioteca().buscarPorNombre(nombreCancion);
                    if (c != null && cuenta.agregarCancionAPlaylist(pl, c)) {
                        System.out.println("✅ Canción agregada a la playlist");
                    } else {
                        System.out.println("❌ Error al agregar canción");
                    }
                    break;

                case 4:
                    System.out.print("Nombre de la playlist: ");
                    String playlistRep = sc.nextLine();
                    System.out.print("Índice de la canción: ");
                    int index = sc.nextInt();
                    sc.nextLine();

                    if (!cuenta.reproducir(playlistRep, index)) {
                        System.out.println("❌ No se pudo reproducir la canción");
                    }
                    break;

                case 5:
                    Cancion[] catalogo = cuenta.getBiblioteca().listarCatalogo();
                    System.out.println("\n🎶 CATÁLOGO:");
                    for (int i = 0; i < catalogo.length; i++) {
                        System.out.println(i + ". " + catalogo[i]);
                    }
                    break;

                case 6:
                    cuenta.cerrarSesion();
                    System.out.println("🔒 Sesión cerrada");
                    break;

                case 0:
                    salir = true;
                    System.out.println("👋 Gracias por usar Mini Spotify");
                    break;

                default:
                    System.out.println("❌ Opción inválida");
            }
        }

        sc.close();
    }
}
