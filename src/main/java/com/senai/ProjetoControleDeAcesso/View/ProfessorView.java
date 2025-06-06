package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Model.Professor;

import java.util.Scanner;

public class ProfessorView {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.printf("Bem vind@");
        final Scanner scanner = new Scanner(System.in);
        final HorarioView horarioView = new HorarioView();

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
                case "1" -> visualizarGrade();
                case "2" -> horarioView.menu();
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
        scanner.close();
    }

    private static void visualizarGrade() {
        Professor professor = new Professor();
        System.out.printf("Exibindo grade de aulas do professor %s...\n", professor.getNome());
    }

    private static void receberNotificacoes() {
        System.out.println("Recebendo notificações de atraso...");
    }
}