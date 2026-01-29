package modelo;

public class Cancion extends Multimedia implements Reproducible {

    private String artista;

    public Cancion(String titulo, String artista, int duracionSegundos) {
        super(titulo, duracionSegundos);
        this.artista = artista;
    }

    @Override
    public String getInfo() {
        return "Canción: " + titulo +
               " | Artista: " + artista +
               " | Duración: " + duracionSegundos + "s";
    }

    @Override
    public void reproducir() {
        System.out.println("▶ Reproduciendo: " + titulo + " - " + artista);
    }

    @Override
    public void detener() {
        System.out.println("⏹ Deteniendo: " + titulo);
    }

    @Override
    public String toString() {
        return getInfo();
    }
}

