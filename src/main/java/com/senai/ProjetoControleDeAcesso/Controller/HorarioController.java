package com.senai.ProjetoControleDeAcesso.Controller;


import com.senai.ProjetoControleDeAcesso.Model.DAO.HorarioDAO;
import com.senai.ProjetoControleDeAcesso.Model.Horario.Horario;
import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioSemanal;

import java.time.LocalTime;
import java.util.List;

public class HorarioController {
    private final HorarioDAO horarioDAO = new HorarioDAO();

    public String cadastrarHorario(int idAluno, int idProfessor, String diaSemana, LocalTime horaInicio, LocalTime horaFim, String tipo) {
        HorarioSemanal novoHorario = new HorarioSemanal(0, idAluno, idProfessor, diaSemana, horaInicio, horaFim, tipo);
        horarioDAO.inserir(novoHorario);
        return "Horário cadastrado.";
    }


    public String atualizarHorario(int id, int idAluno, int idProfessor, String diaSemana, LocalTime horaInicio, LocalTime horaFim, String tipo) {
    HorarioSemanal novoHorario = new HorarioSemanal(0, idAluno, idProfessor, diaSemana, horaInicio, horaFim, tipo);
        horarioDAO.inserir(novoHorario);
        return "Horário cadastrado.";
    }


    public String removerHorario(int id) {
        horarioDAO.remover(id);
        return "Horário removido.";
    }

    public List<Horario> listarHorarios() {
        return horarioDAO.listarTodos();
    }
}

