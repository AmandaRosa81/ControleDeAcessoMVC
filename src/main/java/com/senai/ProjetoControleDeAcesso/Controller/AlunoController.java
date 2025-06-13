package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.AlunoDAO;

import java.util.List;

public class AlunoController {
    private final AlunoDAO alunoDAO = new AlunoDAO();

    public String cadastrarAluno(int id, String nome, String login, String senha) {
        alunoDAO.inserir(new Aluno(id, nome, login, senha));
        return "Aluno cadastrado.";
    }

    public String atualizarAluno(int id, String nome, String login, String senha) {
        alunoDAO.atualizar(new Aluno(id, nome, login, senha));
        return "Aluno atualizado.";
    }

    public String removerAluno(int id) {
        alunoDAO.remover(id);
        return "Aluno removido.";
    }

    public List<Aluno> listarAlunos() {
        return alunoDAO.listarTodos();
    }

    public int buscarIdPorNome(String nome) {
        List<Aluno> alunos = alunoDAO.listarTodos();
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno.getId();
            }
        }
        return -1;
    }


}

