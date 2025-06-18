package com.senai.ProjetoControleDeAcesso.Model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Uc {
    private int idUC;
    private String nomeUc;
    private int IdProfessor;
    private int idCurso;
    private LocalTime horarioDia;
    private LocalDateTime horarioSemanal;

    public Uc(String nomeUC, int idUC, int idProfessor, int idCurso, LocalTime horarioDia, LocalDateTime horarioSemanal){
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

    public void setNomeUc(String nomeUc) {
        this.nomeUc = nomeUc;
    }

    public int getIdUC() {
        return idUC;
    }

    public void setIdUC(int idUC) {
        this.idUC = idUC;
    }

    public void setIdProfessor(int idProfessor) {
        IdProfessor = idProfessor;
    }

    public int getIdProfessor() {
        return IdProfessor;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public LocalTime getHorarioDia() {
        return horarioDia;
    }

    public void setHorarioDia(LocalTime horarioDia) {
        this.horarioDia = horarioDia;
    }

    public LocalDateTime getHorarioSemanal() {
        return horarioSemanal;
    }

    public void setHorarioSemanal(LocalDateTime horarioSemanal) {
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
