package modelo;

public class BibliotecaMusical {

    // Atributos
    private Cancion[] catalogo;
    private int contadorCatalogo;
    private int maxCatalogo;

    // Constructor
    public BibliotecaMusical(int maxCatalogo) {
        this.maxCatalogo = maxCatalogo;
        this.catalogo = new Cancion[maxCatalogo];
        this.contadorCatalogo = 0;
    }

    // Agregar canción al catálogo
    public boolean agregarCancion(Cancion c) {
        if (contadorCatalogo < maxCatalogo) {
            catalogo[contadorCatalogo] = c;
            contadorCatalogo++;
            return true;
        } else {
            return false; // catálogo lleno
        }
    }

    // Buscar canción por nombre
    public Cancion buscarPorNombre(String nombre) {
        for (int i = 0; i < contadorCatalogo; i++) {
            if (catalogo[i].getTitulo().equalsIgnoreCase(nombre)) {
                return catalogo[i];
            }
        }
        return null; // no encontrada
    }

    // Listar catálogo
    public Cancion[] listarCatalogo() {
        Cancion[] lista = new Cancion[contadorCatalogo];
        for (int i = 0; i < contadorCatalogo; i++) {
            lista[i] = catalogo[i];
        }
        return lista;
    }
}
