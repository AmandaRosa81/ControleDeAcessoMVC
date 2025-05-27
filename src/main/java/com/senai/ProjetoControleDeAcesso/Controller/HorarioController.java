package com.senai.ProjetoControleDeAcesso.Controller;


import com.senai.ProjetoControleDeAcesso.Model.DAO.HorarioDAO;
import com.senai.ProjetoControleDeAcesso.Model.Horario.Horario;
import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioSemanal;

import java.time.LocalTime;
import java.util.List;

public class HorarioController {
    private final HorarioDAO horarioDAO = new HorarioDAO();

    public String cadastrarHorario(int idAluno, int idProfessor, LocalTime hora) {
        horarioDAO.inserir(new HorarioSemanal(0, idAluno, idProfessor, hora));
        return "Horário cadastrado.";
    }

    public String atualizarHorario(int id, int idAluno, int idProfessor, LocalTime hora) {
        horarioDAO.atualizar(new HorarioSemanal(id, idAluno, idProfessor, hora));
        return "Horário atualizado.";
    }

    public String removerHorario(int id) {
        horarioDAO.remover(id);
        return "Horário removido.";
    }

    public List<Horario> listarHorarios() {
        return horarioDAO.listarTodos();
    }
}

