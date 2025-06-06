package com.senai.ProjetoControleDeAcesso.Model;

import java.time.LocalTime;

public class Aluno extends Usuario {

    public Aluno(int id, String nome, String login, String senha) {
        super(id, nome, login, senha);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login);
    }

    @Override
    public String getSenha() {
        return super.getSenha();
    }

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
    }

    @Override
    public String getTipo() {
        return "";
    }

    public boolean estaAtrasado(LocalTime horarioEntrada, int tolerancia) {
        return LocalTime.now().isAfter(horarioEntrada.plusMinutes(5));
    }

    @Override
    public String toString() {
        return "Aluno" +
                "id =" + id +
                ", nome =" + nome;
    }
}
