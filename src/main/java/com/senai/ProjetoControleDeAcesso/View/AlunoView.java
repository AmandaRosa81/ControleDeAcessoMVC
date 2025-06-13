package com.senai.ProjetoControleDeAcesso.View;

import java.util.Scanner;

public class AlunoView {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AlunoView alunoView =  new AlunoView();

        alunoView.menu();
    }
    public void menu() {
        String opcao;
        String menuAluno = """
                --- MENU DE ALUNO ---
                
                    1. Gerar Ocorrência
                    2. Enviar Justificativa
                    0. Voltar
                    
                """;
        do {
            System.out.print(menuAluno);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> menuOcorrencia();
                case "2" -> menuJustificativa();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
        scanner.close();
    }

    public static void menuOcorrencia (){
        OcorrenciaView ocorrenciaView = new OcorrenciaView();
        ocorrenciaView.menu();
    }

    public static void menuJustificativa(){
        JustificativaView justificativaView = new JustificativaView();
        justificativaView.menu();
    }
}
