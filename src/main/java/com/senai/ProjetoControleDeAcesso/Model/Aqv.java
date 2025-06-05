package com.senai.ProjetoControleDeAcesso.Model;

public class Aqv extends Usuario{
    public Aqv(int id, String nome, String login, String senha) {
        super(id, nome, login, senha);
    }

    @Override
    public String getTipo() {
        return "AQV";
    }
}
