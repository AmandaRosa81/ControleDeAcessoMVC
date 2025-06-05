package com.senai.ProjetoControleDeAcesso;

import com.senai.ProjetoControleDeAcesso.Controller.AlunoController;
import com.senai.ProjetoControleDeAcesso.Controller.AqvController;
import com.senai.ProjetoControleDeAcesso.Controller.CoordenadorController;
import com.senai.ProjetoControleDeAcesso.Controller.ProfessorController;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.AlunoDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.AqvDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.CoordenadorDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.ProfessorDAO;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.util.Optional;

public class LoginController {

    private final AlunoDAO alunoDAO = new AlunoDAO();
    private final ProfessorDAO professorDAO = new ProfessorDAO();
    private final AqvDAO aqvDAO = new AqvDAO();
    private final CoordenadorDAO coordenadorDAO = new CoordenadorDAO();

    public Optional<Usuario> autenticar(String login, String senha) {

        Optional<? extends Usuario> aqv = aqvDAO.buscarPorLogin(login);
        if (aqv.isPresent() && aqv.get().getSenha().equals(senha)) return Optional.of(aqv.get());

        Optional<? extends Usuario> coordenador = coordenadorDAO.buscarPorLogin(login);
        if (coordenador.isPresent() && coordenador.get().getSenha().equals(senha)) return Optional.of(coordenador.get());

        Optional<? extends Usuario> professor = professorDAO.buscarPorLogin(login);
        if (professor.isPresent() && professor.get().getSenha().equals(senha)) return Optional.of(professor.get());

        Optional<? extends Usuario> aluno = alunoDAO.buscarPorLogin(login);
        if (aluno.isPresent() && aluno.get().getSenha().equals(senha)) return Optional.of(aluno.get());

        return Optional.empty();
    }
}
