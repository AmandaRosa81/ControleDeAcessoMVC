package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.AmbienteController;
import com.senai.ProjetoControleDeAcesso.Model.Ambiente;

import java.util.Scanner;

public class AmbienteView {
    private final Scanner scanner = new Scanner(System.in);
    private final AmbienteController controller = new AmbienteController();

    public void menu() {
        String opcao;
        String menuAmbiente = """
                --- MENU DE AMBIENTE ---
                
                    1. Cadastrar Ambiente
                    2. Atualizar Ambiente
                    3. Remover Ambiente
                    4. Listar Ambiente
                    0. Voltar
                    
                """;
        do {
            System.out.print(menuAmbiente);
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
        scanner.close();
    }

    private void cadastrar() {
        String nomeAmbiente = scannerPrompt("Nome do ambiente: ");
        int idAmbiente = scannerPromptInt("ID do ambiente: ");
        System.out.println(controller.cadastrarAmbiente(nomeAmbiente, idAmbiente));
    }

    private void atualizar() {
        String nomeAmbiente = scannerPrompt("Nome do ambiente: ");
        int idAmbiente = scannerPromptInt("ID do ambiente: ");
        System.out.println(controller.atualizarAmbiente(nomeAmbiente, idAmbiente));
    }

    private void remover() {
        listar();
        int idAmbiente = scannerPromptInt("ID do ambiente para remover: ");
        System.out.println(controller.removerAmbiente(idAmbiente));
    }

    public void listar() {
        for (Ambiente a : controller.listarAmbientes()) {
            System.out.printf("Nome do ambiente: %s | Ambiente ID: %d |\n", a.getNomeAmbiente(), a.getIdAmbiente());
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
