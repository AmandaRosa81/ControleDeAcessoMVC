package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.CoordenadorController;
import com.senai.ProjetoControleDeAcesso.Model.Coordenador;

import java.util.List;
import java.util.Scanner;

public class ProfessorADM {
    private final Scanner scanner = new Scanner(System.in);
    private final CoordenadorController controller = new CoordenadorController();

    public static void main(String[] args) {
        ProfessorADM professorADM = new ProfessorADM();
        professorADM.menu();
    }

    public void menu() {
        String opcao;
        String menuCoorde = """
                --- MENU PROFESSOR ---

                1. Cadastrar Professor(a)
                2. Atualizar Professor(a)
                3. Remover Professor(a)
                4. Listar Professor(a)
                0. Voltar

                Escolha uma opção:""";
        do {
            System.out.print(menuCoorde);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> cadastrar();
                case "2" -> atualizar();
                case "3" -> remover();
                case "4" -> listar();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!opcao.equals("0"));
        scanner.close();
    }

    private void cadastrar() {
        System.out.print("Digite o ID do Professor: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o nome do Professor: ");
        String nome = scanner.nextLine();

        Coordenador coordenador = new Coordenador();
        coordenador.setId(id);
        coordenador.setNome(nome);

        boolean sucesso = controller.cadastrarCoordenador(coordenador);
        if (sucesso) {
            System.out.println("Professor cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar Professor.");
        }
    }

    private void atualizar() {
        System.out.print("Digite o ID do Professor que deseja atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o novo nome: ");
        String nome = scanner.nextLine();

        Coordenador coordenador = new Coordenador();
        coordenador.setId(id);
        coordenador.setNome(nome);

        boolean sucesso = controller.atualizarCoordenador(coordenador);
        if (sucesso) {
            System.out.println("Professor atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar Professor.");
        }
    }

    private void remover() {
        System.out.print("Digite o ID do Professor que deseja remover: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean sucesso = controller.deletarCoordenador(id);
        if (sucesso) {
            System.out.println("Professor removido com sucesso!");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    private void listar() {
        List<Coordenador> lista = controller.listarCoordenador();
        if (lista.isEmpty()) {
            System.out.println("Nenhum Professor encontrado.");
        } else {
            System.out.println("--- Lista de Professores ---");
            for (Coordenador p : lista) {
                System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome());
            }
        }
    }
}
