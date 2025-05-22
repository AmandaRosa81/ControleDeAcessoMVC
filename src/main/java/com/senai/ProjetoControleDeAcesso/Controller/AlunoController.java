package com.senai.ProjetoControleDeAcesso.Controller;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class AlunoController {
    private final AlunoDAO horarioDAO = new AlunoDAO();

    public String cadastrarAluno(int idAluno, int idProfessor, LocalTime hora) {
        horarioDAO.inserir(new Horario(0, idAluno, idProfessor, hora));
        return "Horário cadastrado.";
    }

    public String atualizarAluno(int id, int idAluno, int idProfessor, LocalTime hora) {
        horarioDAO.atualizar(new Horario(id, idAluno, idProfessor, hora));
        return "Horário atualizado.";
    }

    public String removerAluno(int id) {
        horarioDAO.remover(id);
        return "Horário removido.";
    }

    public List<Horario> listarAlunos() {
        return horarioDAO.listarTodos();
    }

}
