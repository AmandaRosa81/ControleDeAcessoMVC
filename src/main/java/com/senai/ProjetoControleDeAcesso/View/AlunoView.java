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
            System.out.print(menu);
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
        int idAluno = scannerPromptInt("ID do aluno: ");
        String nome = scannerPrompt("Nome: ");
        String login = scannerPrompt("Login: ");
        String senha = scannerPrompt("Senha: ");

        System.out.println(controller.cadastrarAluno(idAluno,nome,login,senha));
    }

    private void atualizar() {
        int idAluno = scannerPromptInt("ID do aluno: ");
        String nome = scannerPrompt("Novo nome: ");
        String login = scannerPrompt("Novo Login: ");
        String senha = scannerPrompt("Nova Senha: ");

        System.out.println(controller.atualizarAluno(idAluno, nome,login,senha));
    }

    private void remover() {
        int idAluno = scannerPromptInt("ID do aluno: ");
        System.out.println(controller.removerAluno(idAluno));
    }

    public void listar() {
        for (Aluno a : controller.listarAlunos()) {
            System.out.printf("ID: %d | Nome: %s | RFID: %s\n", a.getIdAluno(), a.getNome(), a.getIdCartaoRfid());
        }
    }

    private int scannerPromptInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine());
    }
}
















