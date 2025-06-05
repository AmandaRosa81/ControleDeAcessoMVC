package com.senai.ProjetoControleDeAcesso.Model;

public class Ocorrencia {
    private int id;
    private String descricao;
    private String data;
    private String tipo;
    private int IdAluno;

    public Ocorrencia(int id, String descricao, String data, String tipo, int idAluno){

        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.tipo = tipo;
        this.IdAluno = idAluno;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdAluno() {
        return IdAluno;
    }

    public void setIdAluno(int idAluno) {
        IdAluno = idAluno;
    }
}
