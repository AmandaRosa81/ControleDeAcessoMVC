package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.JustificativaDAO;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;

import java.util.List;

public class JustificativaController {
    private final JustificativaDAO justificativaDAO = new JustificativaDAO();


    public String anexar () {
        justificativaDAO.anexarJustificativa();
        return "Justificativa anexada!!! ";
    }

    public  String remover(int Id) {
        justificativaDAO.remover(Id);
        return "Anexo removido.";
    }



    public List<Justificativa> listarJustificativas() { return justificativaDAO.listarTodos(); }

}




