package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.UsuarioController;

import java.util.Scanner;

public class UsuarioView {
    private final Scanner scanner = new Scanner(System.in);
    private final UsuarioController controller = new UsuarioController();

    public static void main(String[] args) {

        UsuarioView usuarioView = new UsuarioView();

        usuarioView.menu();
    }
    public void menu() {
        String opcao;
        String menuUsuario = """
                    --- MENU DE USUÁRIOS ---
                1. Cadastrar usuário
                2. Atualizar usuário
                3. Remover usuário
                4. Listar usuários
                0. Voltar
                """;
        do {

            System.out.print(menuUsuario);
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
        String tipo = scannerPrompt("Tipo (1=Aluno, 2=Professor, 3=AQV, 4= Coordenador): ");
        String nome = scannerPrompt("Nome: ");
        String login = scannerPrompt("Login: ");
        String senha = scannerPrompt("Senha: ");
        System.out.println(controller.cadastrarUsuario(tipo, nome, dadoExtra,login,senha));
    }

    private void atualizar() {
        String tipo = scannerPrompt("Tipo (1=Aluno, 2=Professor, 3=AQV, 4= Coordenador): ");
        int id = scannerPromptInt("ID: ");
        String nome = scannerPrompt("Novo nome: ");
        String login = scannerPrompt("Novo Login: ");
        String senha = scannerPrompt("Nova Senha: ");
        System.out.println(controller.atualizarUsuario(tipo, id, nome, dadoExtra,login,senha));
    }

    private void remover() {
        System.out.print("Tipo (1=Aluno, 2=Professor, 3=AQV, 4= Coordenador): ");
        String tipo = scanner.nextLine();
        int id = scannerPromptInt("ID: ");
        System.out.println(controller.removerUsuario(tipo, id));
    }

    private void listar() {
        System.out.println("--- Alunos ---");
        for (Aluno a : controller.listarAlunos()) {
            System.out.printf("ID: %d | Nome: %s | RFID: %s\n", a.getId(), a.getNome(), a.getIdCartaoRfid());
        }
        System.out.println("--- Professores ---");
        for (Professor p : controller.listarProfessores()) {
            System.out.printf("ID: %d | Nome: %s | Disciplina: %s\n", p.getId(), p.getNome(), p.getDisciplina());
        }
        System.out.println("--- AQV ---");
        for (AQV aq : controller.listarAQV()) {
            System.out.printf("ID: %d | Nome: %s \n", aq.getId(), aq.getNome());
        }
        System.out.println("--- Coordenador ---");
        for (Coordenador c : controller.listarCoordenador()) {
            System.out.printf("ID: %d | Nome: %s \n", c.getId(), c.getNome());
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
