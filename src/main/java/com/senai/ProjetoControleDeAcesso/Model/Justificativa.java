package com.senai.ProjetoControleDeAcesso.Model;

public class Justificativa {
    private int id;
    private String descricao;
    private String data;
    private String tipo;
    private int IdAluno;
    private String status;

    public Justificativa(String descricao, int id, int idAluno, String data, String tipo, String status) {
        this.descricao = descricao;
        this.id = id;
        IdAluno = idAluno;
        this.data = data;
        this.tipo = tipo;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
}
