package com.senai.ProjetoControleDeAcesso.Model;

public class Curso {
    private String titulo;
    private int cargaHoraria;
    private String tipo;
    private int tolerancia;

    public Curso(String titulo, int cargaHoraria, String tipo, int tolerancia) {
        this.titulo = titulo;
        this.cargaHoraria = cargaHoraria;
        this.tipo = tipo;
        this.tolerancia = tolerancia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(int tolerancia) {
        this.tolerancia = tolerancia;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + titulo + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", tipo='" + tipo + '\'' +
                ", tolerancia=" + tolerancia +
                '}';
    }
}
