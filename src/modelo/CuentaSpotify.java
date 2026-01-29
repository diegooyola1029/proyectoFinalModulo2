package modelo;

public class CuentaSpotify {

    // Atributos
    private String usuario;
    private String password;
    private Playlist[] playlists;
    private BibliotecaMusical biblioteca;
    private boolean sesionIniciada;

    // Atributos auxiliares
    private int contadorPlaylists;
    private int maxPlaylists;

    // Constructor
    public CuentaSpotify(String usuario, String password, int maxPlaylists, int maxCatalogo) {
        this.usuario = usuario;
        this.password = password;
        this.maxPlaylists = maxPlaylists;
        this.playlists = new Playlist[maxPlaylists];
        this.contadorPlaylists = 0;
        this.biblioteca = new BibliotecaMusical(maxCatalogo);
        this.sesionIniciada = false;
    }

    // Iniciar sesión
    public boolean iniciarSesion(String u, String p) {
        if (usuario.equals(u) && password.equals(p)) {
            sesionIniciada = true;
            return true;
        }
        return false;
    }

    // Agregar playlist
    public boolean agregarPlaylist(Playlist p) {
        if (sesionIniciada && contadorPlaylists < maxPlaylists) {
            playlists[contadorPlaylists] = p;
            contadorPlaylists++;
            return true;
        }
        return false;
    }

    // Agregar canción a una playlist por nombre
    public boolean agregarCancionAPlaylist(String nombrePlaylist, Cancion c) {
        if (!sesionIniciada) {
            return false;
        }

        for (int i = 0; i < contadorPlaylists; i++) {
            if (playlists[i].getNombre().equalsIgnoreCase(nombrePlaylist)) {
                return playlists[i].agregarCancion(c);
            }
        }
        return false; // playlist no encontrada
    }

    // Reproducir canción de una playlist
    public boolean reproducir(String nombrePlaylist, int indexCancion) {
        if (!sesionIniciada) {
            return false;
        }

        for (int i = 0; i < contadorPlaylists; i++) {
            if (playlists[i].getNombre().equalsIgnoreCase(nombrePlaylist)) {
                return playlists[i].reproducirCancion(indexCancion);
            }
        }
        return false;
    }

    // Cerrar sesión
    public void cerrarSesion() {
        sesionIniciada = false;
    }

    // Getter útil
    public BibliotecaMusical getBiblioteca() {
        return biblioteca;
    }
}
