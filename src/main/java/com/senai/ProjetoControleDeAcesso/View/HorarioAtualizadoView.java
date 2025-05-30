package com.senai.ProjetoControleDeAcesso.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Horario> horarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de cadastro de horários!");

        for (int i = 0; i < 3; i++) { // exemplo: cadastrar 3 horários
            System.out.println("\nCadastro do horário " + (i + 1));

            System.out.print("Dia da semana: ");
            String dia = scanner.nextLine();

            System.out.print("Horário: ");
            String hora = scanner.nextLine();

            System.out.print("Turma: ");
            String turma = scanner.nextLine();

            System.out.print("Disciplina: ");
            String nomeDisciplina = scanner.nextLine();

            System.out.print("Professor: ");
            String nomeProfessor = scanner.nextLine();

            Professor professor = new Professor(nomeProfessor);
            Disciplina disciplina = new Disciplina(nomeDisciplina, professor);
            Horario horario = new Horario(dia, hora, turma, disciplina);

            horarios.add(horario);
        }

        System.out.println("\nHorários cadastrados:");

        for (Horario h : horarios) {
            h.exibir();
        }

        scanner.close();
    }
}
