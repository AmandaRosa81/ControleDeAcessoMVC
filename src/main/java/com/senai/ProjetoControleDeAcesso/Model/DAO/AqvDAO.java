package com.senai.ProjetoControleDeAcesso.Model.DAO;

import com.senai.ProjetoControleDeAcesso.Controller.AqvController;

public class AqvDAO extends AqvController {

    protected int id;
    protected String nome;
    private String login;
    private String senha;

    public AqvDAO(int id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    }
}
