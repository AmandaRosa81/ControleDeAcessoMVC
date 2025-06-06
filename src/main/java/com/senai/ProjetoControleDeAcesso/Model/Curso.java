package com.senai.ProjetoControleDeAcesso.Model;

import java.time.LocalTime;

public class Curso {
    private int idCurso;
    private String nomeCurso;
    private String cargaHoraria;
    private String tipo;
    private LocalTime tolerancia;

    public Curso(int idCurso, String nomeCurso, String cargaHoraria, String tipo, LocalTime tolerancia) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.tipo = tipo;
        this.tolerancia = tolerancia;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
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

    public void setTolerancia(LocalTime tolerancia) {
        this.tolerancia = tolerancia;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", nomeCurso='" + nomeCurso + '\'' +
                ", cargaHoraria='" + cargaHoraria + '\'' +
                ", tipo='" + tipo + '\'' +
                ", tolerancia=" + tolerancia +
                '}';
    }
}
