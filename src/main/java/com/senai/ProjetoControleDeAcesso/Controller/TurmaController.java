package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.TurmaDAO;
import com.senai.ProjetoControleDeAcesso.Model.Turma;

import java.util.List;

public class TurmaController {
    private final TurmaDAO turmaDAO = new TurmaDAO();

    public String cadastrarTurma(int idTurma, String nomeTurma, String curso, String dataInicio, int qtdSemanas,
                                 String horarioEntrada, String periodo){
        turmaDAO.inserir(new Turma(idTurma, nomeTurma, curso, dataInicio, qtdSemanas, horarioEntrada, periodo));
        return "Turma cadastrada.";
    }

    public String atualizarTurma(int idTurma, String nomeTurma, String curso, String dataInicio,
                                 int qtdSemanas, String horarioEntrada, String periodo) {
        turmaDAO.atualizar(new Turma(idTurma, nomeTurma, curso, dataInicio, qtdSemanas, horarioEntrada, periodo));
        return "Turma atualizada.";
    }

    public String removerTurma(int idTurma) {
        turmaDAO.remover(idTurma);
        return "Turma removida.";
    }

    public List<Turma> listarTurmas() {
        return turmaDAO.listarTodos();//Temos que ver se aqui nâo adicionamos as subTurmas.
    }
}
