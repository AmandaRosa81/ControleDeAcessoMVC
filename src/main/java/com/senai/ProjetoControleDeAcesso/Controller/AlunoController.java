package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.AlunoDAO;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class AlunoController {
    private final AlunoDAO alunoDAO = new AlunoDAO();

    public String cadastrarAluno(int id, String nome, String login, String senha) {
        alunoDAO.inserir(new Aluno(id, nome, login, senha));
        return "Aluno cadastrado.";
    }

    public String atualizarAluno(int id, String nome, String login, String senha ) {
        alunoDAO.atualizar(new Aluno(id, nome, login, senha));
        return "Aluno atualizado.";
    }

    public String removerAluno(int id) {
        alunoDAO.listarTodos();
        alunoDAO.remover(id);
        return "Aluno removido.";
    }

    public List<Aluno> listarAlunos() {
        return alunoDAO.listarTodos();
    }

}
