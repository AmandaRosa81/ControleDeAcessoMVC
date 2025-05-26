package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.HorarioSemanalDAO;
import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioSemanal;

import java.time.LocalTime;
import java.util.List;

public class HorarioSemanalController {

    private final HorarioSemanalDAO horarioSemanalDAO = new HorarioSemanalDAO();

    public String cadastrarHorarioSemanal(int idProfessor, int idAluno, String diaSemana, LocalTime hora) {
        HorarioSemanal horario = new HorarioSemanal(0, idProfessor, idAluno, diaSemana, hora);
        horarioSemanalDAO.inserir(horario);
        return "Horário semanal cadastrado.";
    }

    public String atualizarHorarioSemanal(int id, int idProfessor, int idAluno, String diaSemana, LocalTime hora) {
        HorarioSemanal horario = new HorarioSemanal(id, idProfessor, idAluno, diaSemana, hora);
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

