package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.Curso;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.AlunoDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.HorarioDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.ProfessorDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.TurmaDAO;
import com.senai.ProjetoControleDeAcesso.Model.Horario.Horario;
import com.senai.ProjetoControleDeAcesso.Model.Professor;
import com.senai.ProjetoControleDeAcesso.Model.Turma;
import com.senai.ProjetoControleDeAcesso.WebSocket.WebSocketSender;

import java.time.LocalTime;
import java.util.Optional;

public class ControleDeAcessoController {
    private final AlunoDAO alunoDAO = new AlunoDAO();
    private final HorarioDAO horarioDAO = new HorarioDAO();
    private final ProfessorDAO professorDAO = new ProfessorDAO();
    private final TurmaDAO turmaDAO = new TurmaDAO();

    public String processarEntrada(String idAcesso) {
        Optional<Aluno> alunoOpt = alunoDAO.buscarPorIdAcesso(idAcesso);
        if (alunoOpt.isEmpty()) {
            return "[ACESSO NEGADO] Aluno não encontrado pelo idAcesso: " + idAcesso;
        }

        Aluno aluno = alunoOpt.get();

        Optional<Turma> turmaOpt = turmaDAO.buscarPorAluno(aluno);

        if (turmaOpt.isEmpty()) {
            return "[ACESSO] Aluno: " + aluno.getNome() + " - Nenhuma turma atribuída.";
        }

        Optional<Horario> horarioOpt = horarioDAO.buscarHorarioDaTurma (turmaOpt.get().getIdTurma());

        if (horarioOpt.isEmpty()) {
            return "[ACESSO] Aluno: " + aluno.getNome() + " - Nenhum horário atribuído.";
        }

        Horario horario = horarioOpt.get();

        LocalTime horarioEntrada = LocalTime.parse(turmaOpt.get().getHorarioEntrada());
        int tolerancia = turmaOpt.get().getCurso().getTolerancia();


        boolean atrasado = aluno.estaAtrasado(horarioEntrada,tolerancia);

        if (atrasado) {
            Optional<Professor> professorOpt = professorDAO.buscarPorId(horario.getIdProfessor());

            professorOpt.ifPresent(professor -> {
                String msg = "[ATRASO] Aluno " + aluno.getNome() + " chegou atrasado.";
                WebSocketSender.enviarMensagem(msg);
            });
            return "[ATRASO DETECTADO] Aluno: " + aluno.getNome();
        }

        return "[ENTRADA AUTORIZADA] Aluno: " + aluno.getNome();
    }
}
