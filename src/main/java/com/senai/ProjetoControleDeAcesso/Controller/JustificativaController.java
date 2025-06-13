package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.AlunoDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.JustificativaDAO;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;
import com.senai.ProjetoControleDeAcesso.Model.Ocorrencia;

import java.util.List;

public class JustificativaController {
    private final JustificativaDAO justificativaDAO = new JustificativaDAO();

    public void criarJustificativa(Justificativa j){
        justificativaDAO.cadastrar(j);
    }

    public List<Ocorrencia> listarJustificativas(){
        return justificativaDAO.listar();
    }

    public void atualizarJustificativa(Justificativa j) {
        justificativaDAO.atualizar(j);
    }

    public void deletarJustificativas(int id) {justificativaDAO.deletar(id);
    }

}
