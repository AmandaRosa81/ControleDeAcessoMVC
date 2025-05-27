package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.AlunoController;
import com.senai.ProjetoControleDeAcesso.Controller.JustificativaController;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.util.Scanner;

public class Justificativaview {

    private final Scanner scanner = new Scanner(System.in);
    private final JustificativaController justificativaController = new JustificativaController();

    public static void main(String[] args) {

        Justificativaview justificativaView =  new Justificativaview();

        justificativaView.menu();
    }

    public void menu() {
        String opcao;
        String menuJustificativa = """
                --- MENU DE JUSTIFICATIVA ---
                
                    1. Anexar Justificativa
                    2. Atualizar Justificativa
                    3. Remover Justificativa
                    4. Listar Justificativa
                    0. Voltar
                    
                """;
        do {
            System.out.print(menuJustificativa);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> anexar();
                case "2" -> atualizar();
                case "3" -> remover();
                case "4" -> listar();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
    }

    private void anexar() {

        System.out.println("Justificativa anexada com sucesso!!!");
    }

    private void atualizar() {

        System.out.println("Justificativa atualizada com sucesso!!!");
    }

    private void remover() {
        System.out.println("Justificativa removida com sucesso!!!");
    }

    public void listar() {
        for (Justificativa j : justificativaController.listarJustificativas()) {
            System.out.printf( j.getAnexar());
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
