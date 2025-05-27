package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.AlunoDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JustificativaDAO;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.util.List;

public class JustificativaController {

    private final JustificativaDAO justificativaDAO = new JustificativaDAO();


    public void anexarJustificativa() {
        System.out.println("Justificativa anexada!!! " );
    }


    public List<Justificativa> listarJustificativas() { return justificativaDAO.listarTodos(); }

}




