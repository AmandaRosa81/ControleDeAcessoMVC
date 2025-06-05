package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Curso;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.CursoDAO;

import java.util.List;

public class CursoController {
    private final CursoDAO cursoDAO = new CursoDAO();

    public String cadastrarCurso(int idCurso, String nomeCurso, String cargaHoraria, String tipo, String tolerancia) {
        cursoDAO.inserir(new Curso(idCurso, nomeCurso, cargaHoraria, tipo, tolerancia));
        return "Curso cadastrado com sucesso!";
    }

    public String atualizarCurso(int idCurso, String nomeCurso, String cargaHoraria, String tipo, String tolerancia) {
        cursoDAO.atualizar(new Curso(idCurso, nomeCurso, cargaHoraria, tipo, tolerancia));
        return "Curso atualizado com sucesso";
    }

    public String removerCurso(int idCurso) {
        cursoDAO.remover(idCurso);
        return "Curso removido com sucesso";
    }

    public List<Curso> listarCursos() {
        return cursoDAO.listarTodos();
    }
}
