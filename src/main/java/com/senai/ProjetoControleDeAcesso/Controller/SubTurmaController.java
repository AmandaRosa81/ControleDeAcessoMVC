package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.SubTurmaDAO;
import com.senai.ProjetoControleDeAcesso.Model.SubTurma;

import java.util.List;

public class SubTurmaController {
    private final SubTurmaDAO subTurmaDAO = new SubTurmaDAO();

    public String cadastrar(int idSubTurma, String nomeSubTurma, List<Aluno> alunos){
        subTurmaDAO.inserir(new SubTurma(idSubTurma, nomeSubTurma, alunos));
        return "Subturma cadastrada.";
    }

    public String atualizar(int id, String nomeSubTurma, List<Aluno> alunos) {
        subTurmaDAO.atualizar(new SubTurma(id, nomeSubTurma, alunos));
        return "Subturma atualizada.";
    }

    public String remover(int idSubTurma) {
        subTurmaDAO.remover(idSubTurma);
        return "Subturma removida.";
    }

    public List<SubTurma> listar() {
        return subTurmaDAO.listarTodos();
    }
}

