package com.senai.ProjetoControleDeAcesso.Model;

import java.util.List;

public class Turma {
    private int idTurma;
    private String nomeTurma;
    private Curso curso;
    private List<SubTurma> subturmas;
    private String dataInicio;
    private int qtdSemanas;
    private String horarioEntrada;
    private String periodo;

    public Turma(int idTurma, String nomeTurma, Curso curso, List<SubTurma> subturmas, String dataInicio, int qtdSemanas, String horarioEntrada, String periodo) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.curso = curso;
        this.subturmas = subturmas;
        this.dataInicio = dataInicio;
        this.qtdSemanas = qtdSemanas;
        this.horarioEntrada = horarioEntrada;
        this.periodo = periodo;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<SubTurma> getSubturmas() {
        return subturmas;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getQtdSemanas() {
        return qtdSemanas;
    }

    public void setQtdSemanas(int qtdSemanas) {
        this.qtdSemanas = qtdSemanas;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "idTurma=" + idTurma +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", curso= " + curso + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", qtdSemanas=" + qtdSemanas +
                ", horarioEntrada='" + horarioEntrada + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
