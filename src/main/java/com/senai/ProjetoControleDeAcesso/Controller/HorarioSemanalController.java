package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.HorarioSemanalDAO;
import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioSemanal;

import java.time.LocalTime;
import java.util.List;

public class HorarioSemanalController {

    private final HorarioSemanalDAO horarioSemanalDAO = new HorarioSemanalDAO();


    public String cadastrarHorarioSemanal(int idAluno, int idProfessor, String diaSemana, LocalTime horaInicio, LocalTime horaFim, String tipo) {
        HorarioSemanal horario = new HorarioSemanal(0, idAluno, idProfessor, diaSemana, horaInicio, horaFim, tipo);
        horarioSemanalDAO.atualizar(horario);
        return "Horário padrão atualizado.";
    }
    public String atualizarHorarioSemanal(int id, int idAluno, int idProfessor, String diaSemana, LocalTime horaInicio, LocalTime horaFim, String tipo) {
        HorarioSemanal horario = new HorarioSemanal(id, idAluno, idProfessor, diaSemana, horaInicio, horaFim, tipo);
        horarioSemanalDAO.atualizar(horario);
        return "Horário semanal atualizado.";
    }

    public String removerHorarioSemanal(int id) {
        horarioSemanalDAO.remover(id);
        return "Horário semanal removido.";
    }

    public List<HorarioSemanal> listarHorariosSemanais() {
        return horarioSemanalDAO.listarTodos();
    }
}

