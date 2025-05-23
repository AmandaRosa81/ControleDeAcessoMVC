package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.CoordenadorController;
import com.senai.ProjetoControleDeAcesso.Model.Coordenador;

import java.util.List;
import java.util.Scanner;

public class CoordenadorView {
    private final Scanner scanner = new Scanner(System.in);
    private final CoordenadorController controller = new CoordenadorController();

    public void menu() {
        String opcao;
        String menuCoorde = """
                --- MENU DA COORDENAÇÃO ---

                1. Cadastrar Coordenador(a)
                2. Atualizar Coordenador(a)
                3. Remover Coordenador(a)
                4. Listar Coordenador(a)
                0. Sair

                Escolha uma opção:""";
        do {
            System.out.print(menuCoorde);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> cadastrar();
                case "2" -> atualizar();
                case "3" -> remover();
                case "4" -> listar();
                case "0" -> System.out.println("Saindo do menu...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!opcao.equals("0"));
    }

    private void cadastrar() {
        System.out.print("Digite o ID do coordenador: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o nome do coordenador: ");
        String nome = scanner.nextLine();

        Coordenador coordenador = new Coordenador();
        coordenador.setId(id);
        coordenador.setNome(nome);

        boolean sucesso = controller.cadastrarCoordenador(coordenador);
        if (sucesso) {
            System.out.println("Coordenador cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar coordenador.");
        }
    }

    private void atualizar() {
        System.out.print("Digite o ID do coordenador que deseja atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o novo nome: ");
        String nome = scanner.nextLine();

        Coordenador coordenador = new Coordenador();
        coordenador.setId(id);
        coordenador.setNome(nome);

        boolean sucesso = controller.atualizarCoordenador(coordenador);
        if (sucesso) {
            System.out.println("Coordenador atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar coordenador.");
        }
    }

    private void remover() {
        System.out.print("Digite o ID do coordenador que deseja remover: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean sucesso = controller.deletarCoordenador(id);
        if (sucesso) {
            System.out.println("Coordenador removido com sucesso!");
        } else {
            System.out.println("Coordenador não encontrado.");
        }
    }

    private void listar() {
        List<Coordenador> lista = controller.listarCoordenador();
        if (lista.isEmpty()) {
            System.out.println("Nenhum coordenador encontrado.");
        } else {
            System.out.println("--- Lista de Coordenadores ---");
            for (Coordenador c : lista) {
                System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome());
            }
        }
    }
}
