package com.senai.ProjetoControleDeAcesso.Model.DAO;

import java.time.LocalTime;

public class AlunoDAO {
    private int idAluno;
    private String nome;
    private String login;
    private String senha;

    public AlunoDAO(int idAluno, String nome, String login, String senha) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
