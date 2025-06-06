package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aqv;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.UcDAO;
import com.senai.ProjetoControleDeAcesso.Model.Uc;

import java.util.List;

public class UcController {

    private final UcDAO ucDAO = new UcDAO();

    public String CadastrarUc( String nomeUc, int idUC, int idProfessor, int idCurso, int horarioDia, int horarioSemanal ){
        ucDAO.inserir(new UcDAO(nomeUc, idUC, idProfessor, idCurso, horarioDia,horarioSemanal));
        return "Unidade Curricular Cadastrada";
    }
    public String AtualizarUC(String nomeUc,int  idUC, int idProfessor, int idCurso, int horarioDia, int horarioSemanal) {

        ucDAO.atualizar(new UcDAO(nomeUc, idUC, idProfessor, idCurso, horarioDia,horarioSemanal));
        return "A Unidade Curricular foi atualizada";


    }
    public String removerUC(int idUC){
        ucDAO.listarTodos();
        ucDAO.remover(idUC);
        return "Unidade Curricular removida";
    }
    public List<Uc> Listar(){

        return ucDAO.listarTodos();

    }

}
