package modelo;

public class Playlist {
    private String nombre;
    private Cancion[] canciones;  // atributo principal

    // atributos auxiliares
    private int contadorCanciones;
    private int maxCanciones;

    public Playlist(String nombre, int maxCanciones) {
        this.nombre = nombre;
        this.maxCanciones = maxCanciones;
        this.canciones = new Cancion[maxCanciones];
        this.contadorCanciones = 0;
    }

    public boolean agregarCancion(Cancion cancion) {
        if (!estaLlena()) {
            canciones[contadorCanciones] = cancion;
            contadorCanciones++;
            return true;
        } else {
            return false;
        }
    }

    public Cancion[] listarCanciones() {
        Cancion[] listaCanciones = new Cancion[contadorCanciones];
        for (int i = 0; i < contadorCanciones; i++) {
            listaCanciones[i] = canciones[i];
        }
        return listaCanciones;
    }

    public boolean reproducirCancion(int index) {
        if (index >= 0 && index < contadorCanciones) {
            canciones[index].reproducir();
            return true;
        } else {
            return false;
        }
    }

    public boolean estaLlena() {
        return contadorCanciones >= maxCanciones;
    }
    public String getNombre() {
    return nombre;
}
}

