package com.cam.miapprc;

public class Persona {
    private String nombre;
    private String apellido;
    private int imagen;

    public Persona(String nombre, String apellido, int imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getImagen() {
        return imagen;
    }
}
