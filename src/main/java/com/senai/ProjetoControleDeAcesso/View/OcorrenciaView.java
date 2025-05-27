package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.OcorrenciaController;
import com.senai.ProjetoControleDeAcesso.Model.Ocorrencia;

import java.util.List;
import java.util.Scanner;

public class OcorrenciaView {
    private final Scanner scanner = new Scanner(System.in);
    private final OcorrenciaController controller = new OcorrenciaController();

    public static void main(String[] args) {
        OcorrenciaView ocorrenciaViewview = new OcorrenciaView();
        ocorrenciaViewview.menu();
    }

    public void menu() {
        String opcao;
        String menu = """
                --- MENU DE OCORRÊNCIAS ---
                1. Cadastrar Ocorrência
                2. Atualizar Ocorrência
                3. Remover Ocorrência
                4. Listar Ocorrências
                0. Sair

                Escolha uma opção: """;

        do {
            System.out.print(menu);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> criarOcorrencia();
                case "2" -> atualizar();
                case "3" -> remover();
                case "4" -> listar();
                case "0" -> System.out.println("Saindo do menu...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!opcao.equals("0"));
    }

    private void criarOcorrencia() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Data (dd/mm/aaaa): ");
        String data = scanner.nextLine();

        System.out.print("ID do Aluno: ");
        int idAluno = Integer.parseInt(scanner.nextLine());

        Ocorrencia o = new Ocorrencia(id, tipo, data, descricao, idAluno);
        controller.criarOcorrencia(o);
        System.out.println("Ocorrência cadastrada com sucesso!");
    }

    private void atualizar() {
        System.out.print("ID da ocorrência a ser atualizada: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo tipo: ");
        String tipo = scanner.nextLine();


        System.out.print("Nova data (dd/mm/aaaa): ");
        String data = scanner.nextLine();

        System.out.print("Nova descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Novo ID do Aluno: ");
        int idAluno = Integer.parseInt(scanner.nextLine());

        Ocorrencia o = new Ocorrencia(id, tipo, data, descricao, idAluno);
        controller.atualizarOcorrencia(o);
        System.out.println("Ocorrência atualizada com sucesso!");
    }

    private void remover() {
        System.out.print("ID da ocorrência a ser removida: ");
        int id = Integer.parseInt(scanner.nextLine());
        controller.deletarOcorrencia(id);
        System.out.println("Ocorrência removida com sucesso!");
    }

    private void listar() {
        List<Ocorrencia> lista = controller.listarOcorrencias();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma ocorrência encontrada.");
        } else {
            for (Ocorrencia o : lista) {
                System.out.printf("ID: %d | Tipo: %s | Data: %s | Descrição: %s | ID do aluno: %d%n",
                        o.getId(), o.getDescricao(), o.getData(), o.getTipo(), o.getIdAluno());
            }
        }
    }
}

