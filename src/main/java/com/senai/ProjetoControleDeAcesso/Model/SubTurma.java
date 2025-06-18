package com.senai.ProjetoControleDeAcesso.Model;

import java.util.List;

public class SubTurma {
    private int idSubTurma;
    private String nomeSubTurma;
    private List<Aluno> alunos;

    public SubTurma(int idSubTurma, String nomeSubTurma, List<Aluno> alunos) {
        this.idSubTurma = idSubTurma;
        this.nomeSubTurma = nomeSubTurma;
        this.alunos = alunos;
    }

    public int getIdSubTurma() {
        return idSubTurma;
    }

    public void setIdSubTurma(int idSubTurma) {
        this.idSubTurma = idSubTurma;
    }

    public String getNomeSubTurma() {
        return nomeSubTurma;
    }

    public void setNomeSubTurma(String nomeSubTurma) {
        this.nomeSubTurma = nomeSubTurma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "SubTurma{" +
                "idSubTurma=" + idSubTurma +
                ", nomeSubTurma='" + nomeSubTurma + '\'' +
                ", alunos=" + alunos +
                '}';
    }
}
