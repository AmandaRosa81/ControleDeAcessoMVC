package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.AmbienteController;
import com.senai.ProjetoControleDeAcesso.Model.Ambiente;

import java.util.Scanner;

public class AmbienteView {
    private final Scanner scanner = new Scanner(System.in);
    private final AmbienteController controller = new AmbienteController();

    public static void main(String[] args) {
        AmbienteView ambienteView = new AmbienteView();

        ambienteView.menu();
    }
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
    }

    private void cadastrar() {
        String nomeAmbiente = scannerPrompt("Nome do ambiente: ");
        System.out.println(controller.cadastrarAmbiente(nomeAmbiente));
    }

    private void atualizar() {
        String nomeAmbiente = scannerPrompt("Nome do ambiente: ");
        System.out.println(controller.atualizarAmbiente(nomeAmbiente));
    }

    private void remover() {
        String nomeAmbiente = scannerPrompt("Nome do ambiente: ");
        System.out.println(controller.removerAmbiente(nomeAmbiente));
    }

    public void listar() {
        for (Ambiente a : controller.listarAmbientes()) {
            System.out.printf("Nome do ambiente: %s\n", a.getNomeAmbiente());
        }
    }

    private String scannerPrompt(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

}
