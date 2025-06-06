package com.senai.ProjetoControleDeAcesso.View;

import java.util.Scanner;

public class CoordenadorView {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        final Scanner scanner = new Scanner(System.in);
        String opcao;
        String menuAmbiente = """
                --- MENU DE GERENCIAMENTO DE USUÁRIOS ---
                
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
                case "1" -> menuAQV();
                case "2" -> menuAluno();
                case "3" -> menuCoordenador();
                case "4" -> menuProfessor();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
        scanner.close();
    }


    public static void menuAQV (){
        AqvADM aqvADM = new AqvADM();
        aqvADM.menu();
    }
    public static void menuAluno (){
        AlunoADM alunoADM = new AlunoADM();
        alunoADM.menu();
    }
    public static void menuCoordenador (){
        CoordenadorADM coordenadorADM = new CoordenadorADM();
        coordenadorADM.menu();
    }
    public static void menuProfessor (){
        ProfessorADM professorADM = new ProfessorADM();
        professorADM.menu();
    }

}

