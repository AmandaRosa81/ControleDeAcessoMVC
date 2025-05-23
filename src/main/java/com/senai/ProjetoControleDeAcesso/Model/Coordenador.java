package com.senai.ProjetoControleDeAcesso.Model;

public class Coordenador extends Usuario {

    public Coordenador(int id, String nome, String login, String senha) {
        super(id, nome, login, senha);
    }

    public Coordenador() {
        super(0, "", "", "");
    }

    @Override
    public String getTipo() {
        return "Coordenador";
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", login='" + getLogin() + '\'' +
                '}';
    }
}
