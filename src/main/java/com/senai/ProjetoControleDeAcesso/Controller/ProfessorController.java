package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.ProfessorDAO;
import com.senai.ProjetoControleDeAcesso.Model.Professor;
import java.util.List;

public class ProfessorController {
    private ProfessorDAO ProfessorDAO = new ProfessorDAO();

    public List<Professor> listarProfessor() {

        return ProfessorDAO.listar();
    }

    public boolean cadastrarProfessor(Professor professor) {
        if (professor != null) {
            ProfessorDAO.salvar(professor);
            return true;
        }
        return false;
    }

    public boolean atualizarProfessor(Professor professor) {
        if (professor != null) {
            ProfessorDAO.atualizar(professor);
            return true;
        }
        return false;
    }

    public boolean deletarProfessor(int id) {
        if (id >= 0) {
            ProfessorDAO.deletar(id);
            return true;
        }
        return false;
    }
}
