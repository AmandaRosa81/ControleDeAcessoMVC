package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.OcorrenciaDAO;
import com.senai.ProjetoControleDeAcesso.Model.Ocorrencia;

import java.util.List;

public class OcorrenciaController {

    private final OcorrenciaDAO ocorrenciaDAO = new OcorrenciaDAO();

    public void criarOcorrencia(Ocorrencia o) {
        ocorrenciaDAO.criar(o);
    }

    public List<Ocorrencia> listarOcorrencias() {
        return ocorrenciaDAO.listar();
    }

    public void atualizarOcorrencia(Ocorrencia o) {
        ocorrenciaDAO.atualizar(o);
    }

    public void deletarOcorrencia(int id) {
        ocorrenciaDAO.deletar(id);
    }

    public List<Ocorrencia> listarOcorrenciasPorAluno(int idAluno) {
        return ocorrenciaDAO.listar().stream()
                .filter(o -> o.getIdAluno() == idAluno)
                .toList();
    }

    public boolean atualizarStatusOcorrencia(int idOcorrencia, String novoStatus) {
        List<Ocorrencia> todas = ocorrenciaDAO.listar();
        for (Ocorrencia o : todas) {
            if (o.getId() == idOcorrencia) {
                o.setStatus(novoStatus);
                ocorrenciaDAO.atualizar(o);
                return true;
            }
        }
        return false;
    }
}

