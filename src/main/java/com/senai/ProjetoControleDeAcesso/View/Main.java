package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.AlunoController;
import com.senai.ProjetoControleDeAcesso.Model.DAO.AlunoDAO;

public class Main {
    public static void main(String[] args) {

        AlunoController alunoController = new AlunoController();

        alunoController.cadastrarAluno(1,"Laura1","LauraAluno","L");
        alunoController.cadastrarAluno(2,"Gustavo","GustavoAluno","G");
        alunoController.cadastrarAluno(3,"Pedro","PedroAluno","P");
        alunoController.atualizarAluno(1,"Laura4","LauraAluno","L");
        alunoController.removerAluno(2);
        alunoController.listarAlunos();


    }
}
