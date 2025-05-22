package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Coordenador;

import java.util.List;

public class CoordenadorController {
    private coordenadorDAO coordenadorDAO = new CoordenadorDAO();

    public List<Coordenador> listarCoordenador(){
        return coordenadorDAO.listar();
    }

    public boolean cadastrarCoordenador(Coordenador coordenador){
        if (coordenador!=null){
            coordenadorDAO.salvar(coordenador);
            return true;
        }
        return false;
    }

    public boolean atualizarCoordenador(Coordenador coordenador){
        if (coordenador !=null){
            coordenadorDAO.atualizar(coordenador);
            return true;
        }
        return false;
    }

    public boolean deletarCoordenador(int id){
        if (id>0){
            coordenadorDAO.deletar(id);
            return true;
        }
        return false;
    }


}
