package com.senai.ProjetoControleDeAcesso;

import com.senai.ProjetoControleDeAcesso.Controller.AlunoController;
import com.senai.ProjetoControleDeAcesso.Controller.AqvController;
import com.senai.ProjetoControleDeAcesso.Controller.CoordenadorController;
import com.senai.ProjetoControleDeAcesso.Controller.ProfessorController;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.util.Optional;

public class LoginController {

    private final AlunoController alunoController = new AlunoController();
    private final ProfessorController professorController = new ProfessorController();
    private final AqvController aqvController = new AqvController();
    private final CoordenadorController coordenadorController = new CoordenadorController();

    public Optional<Usuario> autenticar(String login, String senha) {

        Optional<? extends Usuario> aqv = aqvController.buscarPorLogin(login);
        if (aqv.isPresent() && aqv.get().getSenha().equals(senha)) return Optional.of(aqv.get());

        Optional<? extends Usuario> coordenador = coordenadorController.buscarPorLogin(login);
        if (coordenador.isPresent() && coordenador.get().getSenha().equals(senha)) return Optional.of(coordenador.get());

        Optional<? extends Usuario> professor = professorController.buscarPorLogin(login);
        if (professor.isPresent() && professor.get().getSenha().equals(senha)) return Optional.of(professor.get());

        Optional<? extends Usuario> aluno = alunoController.buscarPorLogin(login);
        if (aluno.isPresent() && aluno.get().getSenha().equals(senha)) return Optional.of(aluno.get());

        return Optional.empty();
    }
}
