package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.DAO.AqvDAO;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

public class AqvController {
    private AqvDAO aqvDAO = new AqvDAO();

    public String CadastrarAQV(String nomeAQV, int idAQV,String loginAQV, int senhaAQV){
        aqvDAO.inserir( new AQV(nomeAQV,idAQV,loginAQV,senhaAQV));
        return "AQV Cadastrado";

    }
    public String ExibirAQV(String nomeAQV, int idAQV,String loginAQV, int senhaAQV){
        return aqvDAO.ExibirAQV(nomeAQV ,idAQV, loginAQV, senhaAQV);

    }
    public String AtualizarAQV(String nomeAQV, int idAQV,String loginAQV, int senhaAQV){
        aqvDAO.Atualizar( new AQV(nomeAQV,idAQV,loginAQV,senhaAQV));
        return "AQV Cadastrado";

    }
    public String DeletarAQV(int idAQV){
        aqvDAO.Deletar(idAQV);
        return "AQV Deletado";

    }
}
