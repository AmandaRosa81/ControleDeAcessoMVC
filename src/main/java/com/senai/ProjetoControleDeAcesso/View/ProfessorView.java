package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Model.Professor;

import java.util.Scanner;

public class ProfessorView {

    private static final Scanner scanner = new Scanner(System.in);

    public void menu(Professor professor) {
        System.out.printf("Bem vind@ %s \n", professor.getNome());


        String opcao;
        do {
            System.out.print("""
                    ===== MENU PROFESSOR =====
                    1.Visualizar grade de aula 
                    2. Gerenciar Horários
                    3. Receber notificações de atraso
                    4. Deslogar
                    0. Sair
                    """);

            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> visualizarGrade(professor);
                case "2" -> HorarioView.menu();
                case "3" -> receberNotificacoes();
                case "4" -> {
                    System.out.println("Deslogando...");
                    System.exit(0);
                }
                case "0" -> {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
    }

    private void visualizarGrade(Professor professor) {
        System.out.printf("Exibindo grade de aulas do professor %s...\n", professor.getNome());
    }

    private void receberNotificacoes() {
        System.out.println("Recebendo notificações de atraso...");
    }
}