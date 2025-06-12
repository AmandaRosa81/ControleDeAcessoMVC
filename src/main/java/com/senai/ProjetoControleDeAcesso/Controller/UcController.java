package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aqv;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.UcDAO;
import com.senai.ProjetoControleDeAcesso.Model.Uc;

import java.util.List;

public class UcController {

    private final UcDAO ucDAO = new UcDAO();


    public String CadastrarUC( String nomeUC, int idUC, int idProfessor, int idCurso, int horarioDia, int horarioSemanal ){
        Uc uc = new Uc(nomeUC, idUC, idProfessor, idCurso, horarioDia, horarioSemanal);
        UcDAO.inserir(uc);
        return "Unidade Curricular Cadastrada";
    }
    public String AtualizarUC(String nomeUC,int  idUC, int idProfessor, int idCurso, int horarioDia, int horarioSemanal) {

        Uc uc = new Uc(nomeUC, idUC, idProfessor, idCurso, horarioDia, horarioSemanal);
        UcDAO.atualizar(uc);
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
