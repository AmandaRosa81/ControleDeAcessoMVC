package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.AqvDAO;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.util.List;

public class AqvController {
    private AqvDAO aqvDAO = new AqvDAO();

    public String CadastrarAQV(String nomeAQV, int idAQV, String loginAQV, int senhaAQV) {
        aqvDAO.inserir(new Usuario(nomeAQV, idAQV, loginAQV, senhaAQV) {
            @Override
            public String getTipo() {
                return "";
            }
        });
        return "AQV Cadastrado";


    }

    public String AtualizarAQV(String nomeAQV, int idAQV, String loginAQV, int senhaAQV) {
        aqvDAO.atualizar(new Usuario(nomeAQV, idAQV, loginAQV, senhaAQV));


    }
        public void removerAQV(int idAQV){
            aqvDAO.listarTodos();
            aqvDAO.remover(idAQV);
            return "AQV removido";
        }
    }

