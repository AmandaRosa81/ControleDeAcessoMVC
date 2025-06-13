package com.senai.ProjetoControleDeAcesso.Model;

import java.time.LocalTime;

public class Aluno extends Usuario {
    private String idAcesso;

    public Aluno(int id, String nome, String login, String senha, String idAcesso) {
        super(id, nome, login, senha);
        this.idAcesso = idAcesso;
    }

    public String getIdAcesso() {
        return idAcesso;
    }

    public void setIdAcesso(String idAcesso) {
        this.idAcesso = idAcesso;
    }

    public boolean estaAtrasado(LocalTime horarioEntrada, int toleranciaMinutos) {
        LocalTime limite = horarioEntrada.plusMinutes(toleranciaMinutos);
        return LocalTime.now().isAfter(limite);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "idAcesso='" + idAcesso + '\'' +
                '}';
    }

    @Override
    public String getTipo() {
        return "Aluno";
    }
}
