package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Ambiente;
import com.senai.ProjetoControleDeAcesso.Model.DAO.AmbienteDAO;

import java.util.List;

public class AmbienteController {
    private final AmbienteDAO ambienteDAO = new AmbienteDAO();

    public String cadastrarAmbiente(String nomeAmbiente) {
        ambienteDAO.inserir(new Ambiente(nomeAmbiente));
        return "Ambiente cadastrado.";
    }

    public String atualizarAmbiente(String nomeAmbiente) {
        ambienteDAO.atualizar(new Ambiente(nomeAmbiente));
        return "Ambiente atualizado.";
    }

    public String removerAmbiente(String nomeAmbiente) {
        ambienteDAO.remover(Integer.parseInt(nomeAmbiente));
        return "Ambiente removido.";
    }

    public List<Ambiente> listarAmbientes() {
        return ambienteDAO.listarTodos();
    }
}
