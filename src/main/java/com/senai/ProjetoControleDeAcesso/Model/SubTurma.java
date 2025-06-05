package com.senai.ProjetoControleDeAcesso.Model;

import java.util.List;

public class SubTurma {
    private int id;
    private List<Aluno> alunos;

    public SubTurma(int id, List<Aluno> alunos) {
        this.id = id;
        this.alunos = alunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", alunos=" + alunos +
                '}';
    }
}
