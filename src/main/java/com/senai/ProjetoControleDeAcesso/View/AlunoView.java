package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.HorarioController;

import java.time.LocalTime;
import java.util.Scanner;

public class AlunoView {
    private final Scanner scanner = new Scanner(System.in);
    private final AlunoController controller = new ALunoController();

    public static void main(String[] args) {
         AlunoView alunoView =  new AlunoView();

         alunoView.menu();
    }

    public void menu() {
        String opcao;
        String menuAluno = """
                --- MENU DE HORÁRIOS ---
                
                    1. Cadastrar aluno
                    2. Atualizar aluno
                    3. Remover aluno
                    4. Listar aluno
                    0. Voltar
                    
                """;
        do {
            System.out.print(menuAluno);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> cadastrar();
                case "2" -> atualizar();
                case "3" -> remover();
                case "4" -> listar();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
    }

    private void cadastrar() {
        int id = scannerPromptInt("ID do aluno: ");
        String nome = scannerPrompt("Nome: ");
        String login = scannerPrompt("Login: ");
        String senha = scannerPrompt("Senha: ");

        System.out.println(controller.cadastrarAluno(id,nome,login,senha));
    }

    private void atualizar() {
        int id = scannerPromptInt("ID do aluno: ");
        String nome = scannerPrompt("Novo nome: ");
        String login = scannerPrompt("Novo Login: ");
        String senha = scannerPrompt("Nova Senha: ");

        System.out.println(controller.atualizarAluno(id, nome,login,senha));
    }

    private void remover() {
        listar();
        int id = scannerPromptInt("ID do aluno: ");
        System.out.println(controller.removerAluno(id));
    }

    public void listar() {
        for (Aluno a : controller.listarAlunos()) {
            System.out.printf("ID: %d | Nome: %s |", a.getId(), a.getNome());
        }
    }

    private String scannerPrompt(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }


    private int scannerPromptInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine());
    }
}
















