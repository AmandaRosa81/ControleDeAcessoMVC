package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.TurmaController;
import com.senai.ProjetoControleDeAcesso.Model.SubTurma;
import com.senai.ProjetoControleDeAcesso.Model.Turma;


import java.util.Scanner;


public class TurmaView {
    private final Scanner scanner = new Scanner(System.in);
    private final TurmaController controller = new TurmaController();

    public static void main(String[] args) {
        TurmaView turmaView = new TurmaView();
        turmaView.menu();
    }

    public void menu() {
        String opcao;
        String menuTurma = """
                ----- MENU DAS TURMAS -----
                
                    1. Cadastrar turma
                    2. Atualizar turma
                    3. Remover turma
                    4. Listar turmas
                    0. Voltar
                    
                ---------------------------
                """;
        do {
            System.out.print(menuTurma);
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
        scanner.close();
    }

    private void cadastrar() {
        int idTurma = scannerPromptInt("ID da turma: ");
        String nomeTurma = scannerPrompt("Nome da turma: ");
        String curso = scannerPrompt("Nome do curso: ");
        String dataInicio = scannerPrompt("Data do início do curso: ");
        int qtdSemanas = scannerPromptInt("Quantidade de semanas: ");
        String horarioEntrada = scannerPrompt("Horário de entrada: ");
        String periodo = scannerPrompt("Qual o período do curso: ");
        System.out.println(controller.cadastrarTurma(idTurma, nomeTurma, curso, dataInicio,
                qtdSemanas, horarioEntrada, periodo));
    }

    private void atualizar() {
        int idTurma = scannerPromptInt("ID da turma a ser atualizado: ");
        String nomeTurma = scannerPrompt("Nome da turma a ser atualizado: \n");
        String curso = scannerPrompt("Nome do curso a ser atualizado: ");
        String dataInicio = scannerPrompt("Data do início do curso a ser atualizada: ");
        int qtdSemanas = scannerPromptInt("Quantidade de semanas a ser atualizada: ");
        String horarioEntrada = scannerPrompt("Horário de entrada a ser atualizado: ");
        String periodo = scannerPrompt("Qual o período do curso a ser atualizado: ");
        System.out.println(controller.atualizarTurma(idTurma, nomeTurma, curso, dataInicio,
                qtdSemanas, horarioEntrada, periodo));
    }

    private void remover() {
        int idTurma = scannerPromptInt("ID da turma a ser removida: ");
        System.out.println(controller.removerTurma(idTurma));
    }

    public void listar() {
        for (Turma turma : controller.listarTurmas()) {
            System.out.printf("ID da turma: %d | Nome da turma: %s | Curso: %s | Data do início: %s | " +
                            "Quantidade de semanas: %d | Horário entrada: %s | Período: %s\n",
                    turma.getIdTurma(), turma.getNomeTurma(), turma.getCurso(), turma.getDataInicio(),
                    turma.getQtdSemanas(), turma.getHorarioEntrada(), turma.getPeriodo());
        }
    }

    private int scannerPromptInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine());
    }

    private String scannerPrompt(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }
}
