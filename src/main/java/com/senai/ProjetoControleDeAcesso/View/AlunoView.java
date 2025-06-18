package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.AlunoController;
import com.senai.ProjetoControleDeAcesso.Controller.OcorrenciaController;

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
                    3. Status ocorrência
                    0. Volta
                """;
        do {
            System.out.print(menuAluno);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> menuOcorrencia();
                case "2" -> menuJustificativa();
                case "3" -> statusOcorrencias();
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

    public void statusOcorrencias() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        AlunoController alunoController = new AlunoController();
        int idAluno = alunoController.buscarIdPorNome(nome);

        if (idAluno == -1) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        OcorrenciaController ocorrenciaController = new OcorrenciaController();
        var ocorrencias = ocorrenciaController.listarOcorrenciasPorAluno(idAluno);

        if (ocorrencias.isEmpty()) {
            System.out.println("Nenhuma ocorrência registrada.");
        } else {
            System.out.println("Suas ocorrências:");
            for (var o : ocorrencias) {
                System.out.printf("ID: %d | Tipo: %s | Data: %s | Status: %s | Descrição: %s%n",
                        o.getId(), o.getTipo(), o.getData(), o.getStatus(), o.getDescricao());
            }
        }
    }


}
