package com.senai.ProjetoControleDeAcesso.Model;

public class Professor extends Usuario{
    private String Disciplina;

    public Professor(int id, String nome, String login, String senha, String disciplina) {
        super(id, nome, login, senha);
        Disciplina = disciplina;
    }

    public String getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(String disciplina) {
        Disciplina = disciplina;
    }

    @Override
    public String getTipo() {
        return "Professor";
    }
}

