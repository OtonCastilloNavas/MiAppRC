package com.cam.miapprc;

public class Foto {
    private String nombre;
    private String fecha;
    private int imagen;
    private int id;
    public Foto(String nombre, String fecha, int imagen, int id) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.imagen = imagen;
        this.id=id;
    }

    public int getId(){
        return this.id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public int getImagen() {
        return imagen;
    }
}
