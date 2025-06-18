package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.AlunoDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.JustificativaDAO;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;
import com.senai.ProjetoControleDeAcesso.Model.Ocorrencia;

import java.util.List;
import java.util.Optional;

public class JustificativaController {

    private final JustificativaDAO justificativaDAO = new JustificativaDAO();

    public void criarJustificativa(Justificativa j){
        justificativaDAO.cadastrar(j);
    }

    public List<Justificativa> listarJustificativas(){
        return justificativaDAO.listar();
    }

    public void atualizarJustificativa(Justificativa j) {
        justificativaDAO.atualizar(j);
    }

    public Optional<String> exibirStatus(int id) {
        return justificativaDAO.buscarStatusPorId(id);
    }

    public void deletarJustificativas(int id) {justificativaDAO.remover(id);
    }

    public List<Justificativa> listarJustificativasPorAluno(int idAluno) {
        return justificativaDAO.listar().stream().filter(o-> o.getIdAluno() == idAluno).toList();
    }
}
