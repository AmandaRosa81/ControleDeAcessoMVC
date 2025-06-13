package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aqv;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.UcDAO;
import com.senai.ProjetoControleDeAcesso.Model.Uc;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class UcController {

    private final UcDAO ucDAO = new UcDAO();


    public String cadastrarUC(String nomeUC, int idUC, int idProfessor, int idCurso, LocalTime horarioDia, LocalDateTime horarioSemanal){
        Uc uc = new Uc(nomeUC, idUC, idProfessor, idCurso, horarioDia, horarioSemanal);
        ucDAO.inserir(uc);
        return "Unidade Curricular Cadastrada";
    }
    public String atualizarUC(String nomeUC,int  idUC, int idProfessor, int idCurso,LocalTime horarioDia, LocalDateTime horarioSemanal) {

        Uc uc = new Uc(nomeUC, idUC, idProfessor, idCurso, horarioDia, horarioSemanal);
        ucDAO.atualizar(uc);
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
