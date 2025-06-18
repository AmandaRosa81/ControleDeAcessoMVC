package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.HorarioAtualizadoController;
import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioAtualizado;

import java.util.List;
import java.util.Scanner;

public class HorarioAtualizadoView {

    private final HorarioAtualizadoController controller = new HorarioAtualizadoController();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AmbienteView ambienteView = new AmbienteView();
        HorarioAtualizadoView horarioAtualizadoView = new HorarioAtualizadoView();
    }

    public void menu() {
        String opcao;
        do {
            System.out.println("""
                    ==== MENU HORÁRIO ATUALIZADO ====
                    1. Cadastrar horário
                    2. Listar horários
                    0. Sair
                    """);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> cadastrarHorario();
                case "2" -> listarHorarios();
                case "0" -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
    }

    private void cadastrarHorario() {
        System.out.print("Dia da semana: ");
        String dia = scanner.nextLine();
        System.out.print("Horário: ");
        String hora = scanner.nextLine();
        System.out.print("Turma: ");
        String turma = scanner.nextLine();
        System.out.print("Disciplina: ");
        String disciplina = scanner.nextLine();
        System.out.print("Professor: ");
        String professor = scanner.nextLine();

        String resposta = controller.cadastrar(dia, hora, turma, disciplina, professor);
        System.out.println(resposta);
    }

    private void listarHorarios() {
        List<HorarioAtualizado> horarios = controller.listarTodos();
        for (HorarioAtualizado h : horarios) {
            h.exibir();
        }
    }
}
