package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Aqv;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.AqvDAO;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.util.List;

public class AqvController {
    private final AqvDAO aqvDAO = new AqvDAO();


    public String CadastrarAQV(int idAQV,String nomeAQV, String senhaAQV, String loginAQV ) {
        aqvDAO.inserir(new Aqv(idAQV, nomeAQV,senhaAQV,loginAQV) );
        return "AQV Cadastrado";


    }

    public String AtualizarAQV(int idAQV, String nomeAQV,String loginAQV,String senhaAQV) {

        aqvDAO.atualizar(new Aqv(idAQV,nomeAQV,loginAQV,senhaAQV));
        return "O AQV foi atualizado";


    }
    public String removerAQV(int idAQV){
        aqvDAO.listarTodos();
        aqvDAO.remover(idAQV);
        return "AQV removido";
    }
    public List<Aqv> Listar(){

        return aqvDAO.listarTodos();
    }

    public List<Aqv> listarOcorrencias() {
        return aqvDAO.listarTodos();
    }

    public boolean autorizarAluno(String nomeAluno) {
        System.out.println("Autorizando aluno: " + nomeAluno);
        return nomeAluno != null && !nomeAluno.isBlank();
    }

}
