package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.CursoController;
import com.senai.ProjetoControleDeAcesso.Model.Curso;

import java.time.LocalTime;
import java.util.Scanner;

public class CursoView {
    private final Scanner scanner = new Scanner(System.in);
    private final CursoController controller = new CursoController();

    public static void main(String[] args) {
        CursoView cursoView = new CursoView();
        cursoView.menu();
    }

    public void menu() {
        String opcao;
        String menuCurso = """
                ------ MENU CURSO ------
                
                    1. Cadastrar curso
                    2. Atualizar curso
                    3. Remover curso
                    4. Listar cursos
                    0. Voltar
                
                -----------------------
                    
                """;
        do {
            System.out.print(menuCurso);
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
    }

    private void cadastrar() {
        int idCurso = scannerPromptInt("ID do curso: ");
        String nomeCurso = scannerPrompt("Nome do curso: ");
        String cargaHoraria = scannerPrompt("Carga horária do curso: ");
        String tipo = scannerPrompt("Tipo do curso: ");
        String tolerancia = scannerPrompt("Tolerância do curso: ");
        System.out.println(controller.cadastrarCurso(idCurso, nomeCurso, cargaHoraria, tipo, tolerancia));
    }

    private void atualizar() {
        int idCurso = scannerPromptInt("ID do curso a ser atualizado: ");
        String nomeCurso = scannerPrompt("Nome do curso a ser atualizado: ");
        String cargaHoraria = scannerPrompt("Carga horária do curso a ser atualizada: ");
        String tipo = scannerPrompt("Tipo do curso a ser atualizado: ");
        String tolerancia = scannerPrompt("Tolerância do curso a ser atualizada: ");
        System.out.println(controller.atualizarCurso(idCurso, nomeCurso, cargaHoraria, tipo, tolerancia));
    }

    private void remover() {
        int idCurso = scannerPromptInt("ID do curso a ser removido: ");
        System.out.println(controller.removerCurso(idCurso));
    }

    public void listar() {
        for (Curso c : controller.listarCursos()) {
            System.out.printf("ID do curso: %d | Nome do curso: %s | Carga horária: %s | Tipo do curso: %s | " +
                            "Tolerância: %s\n",
                    c.getIdCurso(), c.getNomeCurso(), c.getCargaHoraria(), c.getTipo(), c.getTolerancia());
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

    private LocalTime scannerPromptHora(String msg) {
        System.out.print(msg);
        return LocalTime.parse(scanner.nextLine());
    }
}
