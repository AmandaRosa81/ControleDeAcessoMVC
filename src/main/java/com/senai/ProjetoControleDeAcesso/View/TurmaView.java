package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.TurmaController;
import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.Curso;
import com.senai.ProjetoControleDeAcesso.Model.SubTurma;
import com.senai.ProjetoControleDeAcesso.Model.Turma;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        Curso curso = scannerPrompt("Nome do curso: ");
        List<SubTurma> subTurmas = new ArrayList<>();
//        int qtdSubTurmas = scannerPromptInt("Quantas subturmas deseja cadastrar? ");
//
//        for (int i = 0; i < qtdSubTurmas; i++) {
//            System.out.println("Cadastrando subturma #" + (i + 1));
//            int idSubTurma = scannerPromptInt("ID da SubTurma: ");
//
//            List<Aluno> alunos = new ArrayList<>();
//            int qtdAlunos = scannerPromptInt("Quantos alunos nesta subturma? ");
//
//            for (int j = 0; j < qtdAlunos; j++) {
//                System.out.println("Aluno #" + (j + 1));
//                int id = scannerPromptInt("ID do Aluno: ");
//                String nome = scannerPrompt("Nome do Aluno: ");
//                String login = scannerPrompt("Login do Aluno: ");
//                String senha = scannerPrompt("Senha: ");
//                String idAcesso = scannerPrompt("IdAcesso: ");
//
//                alunos.add(new Aluno(id, nome, login, senha, idAcesso));
//            }
//
//            SubTurma subTurma = new SubTurma(idSubTurma, alunos);
//            subTurmas.add(subTurma);
//        }
        String dataInicio = scannerPrompt("Data do início do curso: ");
        int qtdSemanas = scannerPromptInt("Quantidade de semanas: ");
        String horarioEntrada = scannerPrompt("Horário de entrada: ");
        String periodo = scannerPrompt("Qual o período do curso: ");
        System.out.println(controller.cadastrarTurma(idTurma, nomeTurma, curso, subTurmas, dataInicio,
                qtdSemanas, horarioEntrada, periodo));
    }

    private void atualizar() {
        int idTurma = scannerPromptInt("ID da turma a ser atualizado: ");
        String nomeTurma = scannerPrompt("Nome da turma a ser atualizado: \n");
        Curso curso = scannerPrompt("Nome do curso a ser atualizado: ");
        List<SubTurma> subTurmas = new ArrayList<>();
//        int qtdSubTurmas = scannerPromptInt("Quantas subturmas deseja atualizar? ");
//
//        for (int i = 0; i < qtdSubTurmas; i++) {
//            System.out.println("Atualizar subturma #" + (i + 1));
//            int idSubTurma = scannerPromptInt("ID da SubTurma: ");
//
//            List<Aluno> alunos = new ArrayList<>();
//            int qtdAlunos = scannerPromptInt("Quantos alunos nesta subturma? ");
//
//            for (int j = 0; j < qtdAlunos; j++) {
//                System.out.println("Aluno #" + (j + 1));
//                int id = scannerPromptInt("ID do Aluno: ");
//                String nome = scannerPrompt("Nome do Aluno: ");
//                String login = scannerPrompt("Login do Aluno: ");
//                String senha = scannerPrompt("Senha: ");
//                String idAcesso = scannerPrompt("IdAcesso: ");
//
//                alunos.add(new Aluno(id, nome, login, senha, idAcesso));
//            }
//
//            SubTurma subTurma = new SubTurma(idSubTurma, alunos);
//            subTurmas.add(subTurma);
//        }
        String dataInicio = scannerPrompt("Data do início do curso a ser atualizada: ");
        int qtdSemanas = scannerPromptInt("Quantidade de semanas a ser atualizada: ");
        String horarioEntrada = scannerPrompt("Horário de entrada a ser atualizado: ");
        String periodo = scannerPrompt("Qual o período do curso a ser atualizado: ");
        System.out.println(controller.atualizarTurma(idTurma, nomeTurma, curso, subTurmas, dataInicio,
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
