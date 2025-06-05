package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.AqvController;
import com.senai.ProjetoControleDeAcesso.Model.Aqv;

import java.util.List;
import java.util.Scanner;

public class AqvView {
    private final Scanner scanner = new Scanner(System.in);
    private final AqvController aqvController = new AqvController();

    public static void main(String[] args) {
        AqvView aqvView = new AqvView();
        aqvView.menu();
    }

    public void menu(){
        String opcao;
        String menuAQV = """
                --------MENU DE AQV------------
                |   1. Visualizar ocorrências |
                |   2. Autorizar Aluno        |
                |   0. Voltar                 |
                -------------------------------
                Escolha uma opção: 
               """;

        do {
            System.out.print(menuAQV);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> visualizarOcorrencias();
                case "2" -> autorizarAluno();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
    }

    public void visualizarOcorrencias() {
        List<Aqv> ocorrencias = aqvController.listarOcorrencias();
        if (ocorrencias.isEmpty()) {
            System.out.println("Nenhuma ocorrência encontrada.");
        } else {
            System.out.println("----- Ocorrências -----");
            for (Aqv aqv : ocorrencias) {
                System.out.println(aqv);
            }
        }
    }

    public void autorizarAluno() {
        System.out.print("Digite o nome do aluno para autorizar: ");
        String nome = scanner.nextLine();
        boolean sucesso = aqvController.autorizarAluno(nome);
        if (sucesso) {
            System.out.println("Aluno autorizado com sucesso.");
        } else {
            System.out.println("Erro ao autorizar aluno.");
        }
    }
}
