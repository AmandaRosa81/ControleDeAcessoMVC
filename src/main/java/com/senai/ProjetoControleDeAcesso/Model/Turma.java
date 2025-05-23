package com.senai.ProjetoControleDeAcesso.Model;

public class Turma {
    private int idTurma;
    private String nomeTurma;
    private String curso;
    private int dataInicio;
    private int qtdSemanas;
    private int horarioEntrada;
    private String periodo;

    public Turma(int idTurma, String nomeTurma, String curso, int dataInicio, int qtdSemanas, int horarioEntrada, String periodo) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.curso = curso;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(int dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getQtdSemanas() {
        return qtdSemanas;
    }

    public void setQtdSemanas(int qtdSemanas) {
        this.qtdSemanas = qtdSemanas;
    }

    public int getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(int horarioEntrada) {
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
                ", curso='" + curso + '\'' +
                ", dataInicio=" + dataInicio +
                ", qtdSemanas=" + qtdSemanas +
                ", horarioEntrada=" + horarioEntrada +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
