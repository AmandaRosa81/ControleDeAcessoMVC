package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.JustificativaController;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;
import com.senai.ProjetoControleDeAcesso.Model.Ocorrencia;

import java.util.List;
import java.util.Scanner;

public class JustificativaView {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        JustificativaView justificativaView=  new JustificativaView();

        justificativaView.menu();
    }
    public void menu() {
        String opcao;
        String menuAluno = """
                --- MENU DE JUSTIFICATIVA ---
              
                    1. Anexar Justificativa
                    2. Remover Justificativa
                    3. Status
                    4. Listar Justificativas
                    5. Descrição Justificativa
                    0. Voltar
                    
                """;
        do {
            System.out.print(menuJustificativa();
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> criarJustificativa();
                case "2" -> remover();
                case "3" -> atualizar();
                case "4" -> status();
                case "5" -> listar();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));
        scanner.close();
    }

    private void criarJustificativa(){

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Data (dd/mm/aaaa): ");
        String data = scanner.nextLine();

        System.out.print("ID do Aluno: ");
        int idAluno = Integer.parseInt(scanner.nextLine());

        System.out.println("Anexar Documento: ");
        String anexo = scanner.nextLine();

        Justificativa j = new Ocorrencia(id, data, descricao, idAluno, anexo);
        controller.criarOcorrencia(j);
        System.out.println("Ocorrência cadastrada com sucesso!");

    }

    private void remover(){

        System.out.print("ID da Justificativa a ser removida: ");
        int id = Integer.parseInt(scanner.nextLine());
        controller.deletarJustificativa(id);
        System.out.println("Ocorrência removida com sucesso!");

    }

    private void atualizar(){

        System.out.print("ID da Justificativa a ser atualizada: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nova data (dd/mm/aaaa): ");
        String data = scanner.nextLine();

        System.out.print("Nova descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Novo ID do Aluno: ");
        int idAluno = Integer.parseInt(scanner.nextLine());

        Justificativa j = new Justificativa (id, data, descricao, idAluno , anexo);
        Controller.atualizarJustificativa(j);
        System.out.println("Ocorrência atualizada com sucesso!");

    }

    private void status(){

        System.out.print("ID da Justificativa: ");
        int id = Integer.parseInt(scanner.nextLine());
        controller.statusJustificativa(id);

        System.out.print("ID do Aluno: ");
        int idAluno = Integer.parseInt(scanner.nextLine());

        /* aqv aprovar */


        Justificativa j = new Justificativa(id, idAluno, );
        Controller.statusJustificativas(j);


    }

    private void listar(){

        List<Justificativa> lista = controller.listarJustificativas();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma justificativa encontrada.");
        } else {
            for (Justificativa j : lista) {
                System.out.printf("ID: %d  | Data: %s | Descrição: %s | ID do aluno: %d%n | Anexo: %",
                        j.getId(), j.getDescricao(), j.getData(), j.getIdAluno(), j.getAnexo());
            }
        }

    }
}
