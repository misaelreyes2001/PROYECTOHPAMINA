package com.example.proyectohpamina;

public class Resena {
    private long id;
    private String nombre;
    private String texto;

    public Resena(long id, String nombre, String texto) {
        this.id = id;
        this.nombre = nombre;
        this.texto = texto;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTexto() {
        return texto;
    }
}
