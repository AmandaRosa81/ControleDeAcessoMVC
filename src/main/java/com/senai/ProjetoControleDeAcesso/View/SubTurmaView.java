package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.SubTurmaController;
import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.SubTurma;
import com.senai.ProjetoControleDeAcesso.Model.Turma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubTurmaView {
    private final Scanner scanner = new Scanner(System.in);
    private final SubTurmaController controller = new SubTurmaController();

    public static void main(String[] args) {
        SubTurmaView subTurmaView = new SubTurmaView();
        subTurmaView.menu();
    }

    public void menu() {
        String opcao;
        String menuSubTurma = """
                ----- MENU DAS SUBTURMAS -----
                
                    1. Cadastrar subturma
                    2. Atualizar subturma
                    3. Remover subturma
                    4. Listar subturmas
                    0. Voltar
                    
                ---------------------------
                """;
        do {
            System.out.print(menuSubTurma);
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
        int idSubTurma = scannerPromptInt("Digite o id da SubTurma a ser cadastrado: ");
        String nomeSubTurma = scannerPrompt("Nome da subturma a ser cadastrado: ");
        List<Aluno> alunos = new ArrayList<>();
        System.out.println(controller.cadastrar(idSubTurma, nomeSubTurma, alunos));
    }

    private void atualizar() {
        int idSubTurma = scannerPromptInt("Digite o id da SubTurma a ser atualizada: ");
        String nomeSubTurma = scannerPrompt("Nome da subturma a ser atualizada: ");
        List<Aluno> alunos = new ArrayList<>();
        System.out.println(controller.cadastrar(idSubTurma, nomeSubTurma, alunos));
    }

    private void remover() {
        int idSubTurma = scannerPromptInt("ID da turma a ser removida: ");
        System.out.println(controller.remover(idSubTurma));
    }

    public void listar() {
        for (SubTurma subTurma : controller.listar()) {
            System.out.printf("ID da SubTurma: %d | Nome da SubTurma: %s | Alunos: %s\n",
                    subTurma.getIdSubTurma(), subTurma.getNomeSubTurma(), subTurma.getAlunos());
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
