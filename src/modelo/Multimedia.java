package modelo;

public abstract class Multimedia {
    protected String titulo;
    protected int duracionSegundos ; //duracion en segundos 

    public Multimedia(String titulo , int duracion ){
        this.titulo = titulo;
        this.duracionSegundos = duracion;
    }
    public  Multimedia (){
        this.titulo="Desconocido";
        this.duracionSegundos= 0 ;
    }

    public Multimedia(String titulo){
        this.titulo =titulo;
        this.duracionSegundos =0;

    }

    public String getTitulo(){
        return titulo;

    }

    public int getDuracion(){
        return duracionSegundos;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setDuracion(String titulo) {
        this.duracionSegundos = getDuracion();
    }

    public abstract String getInfo();
}
