package com.senai.ProjetoControleDeAcesso.Model;

public class Turma {
    private int idTurma;
    private String nomeTurma;
    private String curso;
    private String dataInicio;
    private int qtdSemanas;
    private String horarioEntrada;
    private String periodo;

    public Turma(int idTurma, String nomeTurma, String curso, String dataInicio, int qtdSemanas, String horarioEntrada, String periodo) {
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
                ", curso='" + curso + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", qtdSemanas=" + qtdSemanas +
                ", horarioEntrada='" + horarioEntrada + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
