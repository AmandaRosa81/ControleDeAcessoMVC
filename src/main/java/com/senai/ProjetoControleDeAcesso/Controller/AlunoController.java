package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.AlunoDAO;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class AlunoController {
    private final AlunoDAO alunoDAO = new AlunoDAO();

    public String cadastrarAluno(int idAluno, String nome, String login, String senha) {
        alunoDAO.inserir(new AlunoDAO(idAluno, nome, login, senha));
        return "Aluno cadastrado.";
    }

    public String atualizarAluno(int idAluno, String nome, String login, String senha ) {
        alunoDAO.atualizar(new AlunoDAO(idAluno, nome, login, senha));
        return "Aluno atualizado.";
    }

    public String removerAluno(int idAluno) {
        alunoDAO.remover(idAluno);
        return "Aluno removido.";
    }

    public List<AlunoDAO> listarAlunos() {
        return alunoDAO.listarTodos();
    }

}
