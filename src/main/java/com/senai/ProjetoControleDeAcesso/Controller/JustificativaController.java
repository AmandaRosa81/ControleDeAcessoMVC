package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.AlunoDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.JustificativaDAO;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;
import com.senai.ProjetoControleDeAcesso.Model.Ocorrencia;

import java.util.List;

public class JustificativaController {
    private final JustificativaDAO justificativaDAO = new JustificativaDAO();

    public String Tipo ( String Falta, String Ocorrencia) {
        justificativaDAO.selecionar(new Justificativa(Falta,Ocorrencia));
        return "Opçao selecionada.";
    }

    public String Descricao ( String Descricao) {
        justificativaDAO.descricao(new Justificativa(Descricao));
        return "Descrição:";
    }

    public String Status ( String Status) {
        justificativaDAO.status(new Justificativa(Status));
        return "Status:";
    }

    public String Anexar () {Add commentMore actions
        justificativaDAO.anexarJustificativa();Add commentMore actions
        return "Justificativa anexada!!! ";
    }
}
