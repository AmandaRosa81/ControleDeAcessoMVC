package com.senai.ProjetoControleDeAcesso.View;
import com.senai.ProjetoControleDeAcesso.Controller.AqvController;
import com.senai.ProjetoControleDeAcesso.Controller.OcorrenciaController;
import com.senai.ProjetoControleDeAcesso.Model.Ocorrencia;

import java.util.List;
import java.util.Scanner;

public class AqvView {
    private final Scanner scanner = new Scanner(System.in);
    private final OcorrenciaController ocorrenciaController = new OcorrenciaController();
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
        List<Ocorrencia> ocorrencias = ocorrenciaController.listarOcorrencias();
        if (ocorrencias.isEmpty()) {
            System.out.println("Nenhuma ocorrência encontrada.");
        } else {
            System.out.println("----- Ocorrências -----");
            for (Ocorrencia o : ocorrencias) {
                System.out.printf("ID: %d | Tipo: %s | Data: %s | Descrição: %s | ID aluno: %d%n",
                        o.getId(),o.getTipo(),o.getData(),o.getDescricao(),o.getIdAluno());
            }
        }
    }

    public void autorizarAluno() {
        System.out.print("Digite o ID da ocorrência: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o novo status (Aceita/Negada): ");
        String status = scanner.nextLine();

        boolean atualizado = ocorrenciaController.atualizarStatusOcorrencia(id, status);

        if (atualizado) {
            System.out.println("Status atualizado com sucesso.");
        } else {
            System.out.println("Erro: Ocorrência não encontrada.");
        }
    }

}