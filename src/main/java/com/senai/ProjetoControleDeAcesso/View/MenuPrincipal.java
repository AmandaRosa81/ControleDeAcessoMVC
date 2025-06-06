package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.AlunoDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.AqvDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.CoordenadorDAO;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.ProfessorDAO;
import com.senai.ProjetoControleDeAcesso.Model.Professor;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        final Scanner scanner = new Scanner(System.in);
        String opcao;
        String menuAmbiente = """
                --- MENU ---
                
                    1. AQV
                    2. Aluno
                    3. Coordenador
                    4. Professor
                    0. Voltar
                    
                """;
        do {
            System.out.print(menuAmbiente);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> loginAQV();
                case "2" -> loginAluno();
                case "3" -> loginCoordenador();
                case "4" -> loginProfessor();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
        scanner.close();
    }

    public static void loginAQV (){
        LoginView loginView = new LoginView();
         AqvDAO aqvDAO = new AqvDAO();
         loginView.exibirLogin();
        if (loginView == aqvDAO.listarTodos()){
            new AqvView().menu();
        }else {
            System.out.println("Erro: Login inválido");
        }
    }

    public static void loginAluno (){
        LoginView loginView = new LoginView();
        AlunoDAO alunoDAO = new AlunoDAO();
        loginView.exibirLogin();
        if (loginView == alunoDAO.listarTodos()){
            new AlunoView().menu();
        }else {
            System.out.println("Erro: Login inválido");
        }
    }

    public static void loginCoordenador (){
        LoginView loginView = new LoginView();
        CoordenadorDAO coordenadorDAO = new CoordenadorDAO();
        loginView.exibirLogin();
        if (loginView == coordenadorDAO.listar()){
            new CoordenadorView().menu();
        }else {
            System.out.println("Erro: Login inválido");
        }
    }

    public static void loginProfessor (){
        LoginView loginView = new LoginView();
        ProfessorDAO professorDAO = new ProfessorDAO();
        loginView.exibirLogin();
        if (loginView == professorDAO.listar()){
            new ProfessorView().menu();
        }else {
            System.out.println("Erro: Login inválido");
        }
    }

}
