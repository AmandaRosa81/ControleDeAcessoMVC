package com.senai.ProjetoControleDeAcesso.Model;

import java.util.Objects;

public class Uc {
    private int idUC;
    private String nomeUc;
    private int IdProfessor;
    private int idCurso;
    private double horarioDia;
    private double horarioSemanal;

    public Uc(String nomeUC, int idUC, int idProfessor, int idCurso, int horarioDia,int horarioSemanal){
        this.nomeUc=nomeUC;
        this.idUC=idUC;
        this.IdProfessor=idProfessor;
        this.idCurso=idCurso;
        this.horarioDia=horarioDia;
        this.horarioSemanal=horarioSemanal;
    }

    public String getNomeUc() {
        return nomeUc;
    }

    public int getIdUC() {
        return idUC;
    }

    public void setIdProfessor(int idProfessor) {
        IdProfessor = idProfessor;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public double getHorarioDia() {
        return horarioDia;
    }

    public void setHorarioSemanal(double horarioSemanal) {
        this.horarioSemanal = horarioSemanal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Uc uc = (Uc) o;
        return idUC == uc.idUC && IdProfessor == uc.IdProfessor && idCurso == uc.idCurso && horarioDia == uc.horarioDia && horarioSemanal == uc.horarioSemanal && Objects.equals(nomeUc, uc.nomeUc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUC, nomeUc, IdProfessor, idCurso, horarioDia, horarioSemanal);
    }
}
