package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.AlunoDAO;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class AlunoController {
    private final AlunoDAO alunoDAO = new AlunoDAO();

    public String cadastrarAluno(int id, String nome, String login, String senha) {
        alunoDAO.inserir(new Usuario(id, nome, login, senha) {
            @Override
            public String getTipo() {
                return "";
            }
        });
        return "Aluno cadastrado.";
    }

    public String atualizarAluno(int id, String nome, String login, String senha ) {
        alunoDAO.atualizar(new Usuario(id, nome, login, senha) {
            @Override
            public String getTipo() {
                return "";
            }
        });
        return "Aluno atualizado.";
    }

    public String removerAluno(int id) {
        alunoDAO.listarTodos();
        alunoDAO.remover(id);
        return "Aluno removido.";
    }

    public List<Usuario> listarAlunos() {
        return alunoDAO.listarTodos();
    }

}
