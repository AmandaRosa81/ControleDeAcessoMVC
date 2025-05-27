package com.senai.ProjetoControleDeAcesso.Model;

public class Ambiente {
    private String nomeAmbiente;
    private int idAmbiente;

    public Ambiente(String nomeAmbiente, int id) {
        this.nomeAmbiente = nomeAmbiente;
        this.idAmbiente = id;
    }

    public String getNomeAmbiente() {
        return nomeAmbiente;
    }

    public void setNomeAmbiente(String nomeAmbiente) {
        this.nomeAmbiente = nomeAmbiente;
    }

    public int getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(int idAmbiente) {
        this.idAmbiente = idAmbiente;
    }
}
