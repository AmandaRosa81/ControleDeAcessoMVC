package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioPadrao;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.HorarioPadraoDAO;

import java.time.LocalTime;
import java.util.List;

public class HorarioPadraoController {

    private final HorarioPadraoDAO horarioPadraoDAO = new HorarioPadraoDAO();

    public String cadastrarHorarioPadrao(int idAluno, int idProfessor, String diaSemana, LocalTime horaInicio, LocalTime horaFim, String tipo) {
        HorarioPadrao horario = new HorarioPadrao(0, idAluno, idProfessor, diaSemana, horaInicio, horaFim, tipo);
        horarioPadraoDAO.inserir(horario);
        return "Horário padrão cadastrado.";
    }

    public String atualizarHorarioPadrao(int id, int idAluno, int idProfessor, String diaSemana, LocalTime horaInicio, LocalTime horaFim, String tipo) {
        HorarioPadrao horario = new HorarioPadrao(id, idAluno, idProfessor, diaSemana, horaInicio, horaFim, tipo);
        horarioPadraoDAO.atualizar(horario);
        return "Horário padrão atualizado.";
    }


    public String removerHorarioPadrao(int id) {
        horarioPadraoDAO.remover(id);
        return "Horário padrão removido.";
    }

    public List<HorarioPadrao> listarHorariosPadrao() {
        return horarioPadraoDAO.listarTodos();
    }
}
