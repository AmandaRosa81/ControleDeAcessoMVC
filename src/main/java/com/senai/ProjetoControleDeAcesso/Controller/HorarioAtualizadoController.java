package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.HorarioAtualizadoDAO;
import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioAtualizado;

import java.util.List;

public class HorarioAtualizadoController {

    private final HorarioAtualizadoDAO dao = new HorarioAtualizadoDAO();
    public String cadastrar(String dia, String hora, String turma, String disciplina, String professor) {
        HorarioAtualizado horario = new HorarioAtualizado(dia, hora, turma, disciplina, professor);
        dao.adicionar(horario);
        return "Horário cadastrado com sucesso!";
    }

    public List<HorarioAtualizado> listarTodos() {
        return dao.listarTodos();
    }
}
