package com.example.proyectohpamina;

public class InfoConceptos {
    private int imagenResId;
    private String titulo;
    private String textoInformativo;
    private boolean mostrarTextoCompleto;

    public InfoConceptos(int imagenResId, String titulo, String textoInformativo) {
        this.imagenResId = imagenResId;
        this.textoInformativo = textoInformativo;
        this.titulo = titulo;
        this.mostrarTextoCompleto = false;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public String getTitulo() {
        return titulo;
    }


    public String getTextoInformativo() {
        if (mostrarTextoCompleto) {
            return textoInformativo;
        } else if (textoInformativo.length() > 50) {
            return textoInformativo.substring(0, 50) + "... Ver más";
        } else {
            return textoInformativo;
        }
    }


    public boolean isMostrarTextoCompleto() {
        return mostrarTextoCompleto;
    }

    public void setMostrarTextoCompleto(boolean mostrarTextoCompleto) {
        this.mostrarTextoCompleto = mostrarTextoCompleto;
    }
}

