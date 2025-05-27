package com.senai.ProjetoControleDeAcesso.View;


import com.senai.ProjetoControleDeAcesso.Controller.HorarioController;
import com.senai.ProjetoControleDeAcesso.Model.Horario.Horario;

import java.time.LocalTime;
import java.util.Scanner;

    public class HorarioView {
        private final Scanner scanner = new Scanner(System.in);
        private final HorarioController controller = new HorarioController();
        private String scannerPromptString(String msg) {
            System.out.print(msg);
            return scanner.nextLine();
        }
        public static void main(String[] args) {
            HorarioView horarioView = new HorarioView();
            horarioView.menu();
        }

            public void menu() {
            String opcao;
            String menuHorario = """
                    --- MENU DE HORÁRIOS ---
                    
                        1. Cadastrar horário
                        2. Atualizar horário
                        3. Remover horário
                        4. Listar horários
                        0. Voltar
                    
                    """;
            do {
                System.out.print(menuHorario);
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
            int idAluno = scannerPromptInt("ID do aluno: ");
            int idProfessor = scannerPromptInt("ID do professor: ");
            String diaSemana = scannerPromptString("Dia da semana: ");
            LocalTime horaInicio = scannerPromptHora("Hora de início (HH:mm): ");
            LocalTime horaFim = scannerPromptHora("Hora de fim (HH:mm): ");
            String tipo = scannerPromptString("Tipo: ");

            System.out.println(controller.cadastrarHorario(idAluno, idProfessor, diaSemana, horaInicio, horaFim, tipo));
        }

        private void atualizar() {
            int id = scannerPromptInt("ID do horário: ");
            int idAluno = scannerPromptInt("Novo ID do aluno: ");
            int idProfessor = scannerPromptInt("Novo ID do professor: ");
            String diaSemana = scannerPromptString("Novo dia da semana: ");
            LocalTime horaInicio = scannerPromptHora("Nova hora de início (HH:mm): ");
            LocalTime horaFim = scannerPromptHora("Nova hora de fim (HH:mm): ");
            String tipo = scannerPromptString("Novo tipo: ");

            System.out.println(controller.atualizarHorario(id, idAluno, idProfessor, diaSemana, horaInicio, horaFim, tipo));
        }


        private void remover() {
            int id = scannerPromptInt("ID do horário: ");
            System.out.println(controller.removerHorario(id));
        }

        public void listar() {
            for (Horario h : controller.listarHorarios()) {
                System.out.printf("ID: %d | Aluno ID: %d | Professor ID: %d | Início: %s\n",
                        h.getId(), h.getIdAluno(), h.getIdProfessor(), h.getHora());
            }
        }

        private int scannerPromptInt(String msg) {
            System.out.print(msg);
            return Integer.parseInt(scanner.nextLine());
        }

        private LocalTime scannerPromptHora(String msg) {
            System.out.print(msg);
            return LocalTime.parse(scanner.nextLine());
        }
    }

