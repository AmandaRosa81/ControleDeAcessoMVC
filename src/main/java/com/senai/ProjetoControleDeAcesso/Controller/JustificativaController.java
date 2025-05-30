package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.DAO.AlunoDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JustificativaDAO;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.util.List;

public class JustificativaController {
    private final JustificativaDAO justificativaDAO = new JustificativaDAO();


    public String anexarAnexo () {
        justificativaDAO.anexarJustificativa();
        return "Justificativa anexada!!! ";
    }

    public  String removerAnexo(String anexo) {
        justificativaDAO.listarTodos();
        justificativaDAO.remover(anexo);
        return "Anexo removido.";
    }



    public List<Justificativa> listarJustificativas() { return justificativaDAO.listarTodos(); }

}




