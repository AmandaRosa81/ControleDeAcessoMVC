package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Ambiente;
import com.senai.ProjetoControleDeAcesso.Model.DAO.AmbienteDAO;

import java.util.List;

public class AmbienteController {
    private final AmbienteDAO ambienteDAO = new AmbienteDAO();

    public String cadastrarAmbiente(String nomeAmbiente, int idAmbiente) {
        ambienteDAO.inserir(new Ambiente(nomeAmbiente, idAmbiente));
        return "Ambiente cadastrado.";
    }

    public String atualizarAmbiente(String nomeAmbiente, int idAmbiente){
        ambienteDAO.atualizar(new Ambiente(nomeAmbiente, idAmbiente));
        return "Ambiente atualizado.";
    }

    public String removerAmbiente(int idAmbiente) {
        ambienteDAO.listarTodos();
        ambienteDAO.remover(idAmbiente);
        return "Ambiente removido.";
    }

    public List<Ambiente> listarAmbientes() {
        return ambienteDAO.listarTodos();
    }
}
