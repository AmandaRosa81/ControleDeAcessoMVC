package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.SubTurmaDAO;
import com.senai.ProjetoControleDeAcesso.Model.SubTurma;

import java.util.List;

public class SubTurmaController {
    private final SubTurmaDAO subTurmaDAO = new SubTurmaDAO();

    public String cadastrar(int id, List<Aluno> alunos){
        subTurmaDAO.inserir(new SubTurma(id, alunos));
        return "Subturma cadastrada.";
    }

    public String atualizar(int id, List<Aluno> alunos) {
        subTurmaDAO.atualizar(new SubTurma(id, alunos));
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

