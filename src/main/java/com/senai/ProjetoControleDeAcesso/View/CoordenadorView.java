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
                --- MENU DE ADM ---
                
                    1. AQV
                    2. Aluno
                    3. Coordenador
                    4. Ambiente
                    0. Voltar
                    
                """;
        do {
            System.out.print(menuAmbiente);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> menuAQV();
                case "2" -> menuAluno();
                case "3" -> menuCoordenador();
                case "4" -> menuAmbiente();
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
    public static void menuAmbiente (){
        AmbienteView ambienteView = new AmbienteView();
        ambienteView.menu();
    }

}

