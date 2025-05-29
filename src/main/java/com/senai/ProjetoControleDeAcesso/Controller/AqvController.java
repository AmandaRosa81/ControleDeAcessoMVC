package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.AqvDAO;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.util.List;

public class AqvController {
    private final AqvDAO aqvDAO = new AqvDAO();


    public String CadastrarAQV(int idAQV,String nomeAQV, String senhaAQV, String loginAQV ) {
        aqvDAO.inserir(new Usuario(idAQV, nomeAQV,senhaAQV,loginAQV) {
            @Override
            public String getTipo() {
                return "";
            }
        });
        return "AQV Cadastrado";


    }

    public String AtualizarAQV(int idAQV, String nomeAQV,String loginAQV,String senhaAQV) {

        aqvDAO.atualizar(new Usuario(idAQV,nomeAQV,loginAQV,senhaAQV) {
            @Override
            public String getTipo() {
                return "";
            }
        });
        return "O AQV foi atualizado";


    }
    public String removerAQV(int idAQV){
        aqvDAO.listarTodos();
        aqvDAO.remover(idAQV);
        return "AQV removido";
    }
    public List<Usuario> Listar(){

        return aqvDAO.listarTodos();
    }
}
