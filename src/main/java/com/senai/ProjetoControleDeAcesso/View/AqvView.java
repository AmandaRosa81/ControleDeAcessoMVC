package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.AqvController;
import com.senai.ProjetoControleDeAcesso.Model.DAO.AqvDAO;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.util.List;
import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class AqvView extends Usuario {

    private Scanner scanner = new Scanner(System.in);
    private AqvController aqvController = new AqvController();

    public void menu(){
        String opcao;
        String menuAQV = """
                --------MENU DE AQV---------
                |   1. Cadastrar AQV       |
                |   2. Atualizar AQV       |
                |   3. Deletar AQV         |
                |   4. Exibir AQV          |
                |   5. Voltar              |
                ----------------------------
         
               """;

        do{
            System.out.print(menuAQV);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> Cadastrar();
                case "2" -> Atualizar();
                case "3" -> Deletar();
                case "4" -> Exibir();
                case "5" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("5"));
    }


    private void Cadastrar(){
        int idAQV = scannerPromptInt("Id do AQV");
        String nomeAQV = scannerPromptString("Nome do AQV");
        String loginAQV = scannerPromptString("Login do AQV");
        int senhaAQV = scannerPromptInt("Senha do AQV");
        System.out.println(aqvController.CadastrarAQV(idAQV,nomeAQV,loginAQV,senhaAQV));

    }
    private void Atualizar(){
        int idAQV = scannerPromptInt("Novo Id do AQV");
        String nomeAQV = scannerPromptString("Novo Nome do AQV");
        String loginAQV = scannerPromptString("Novo Login do AQV");
        int senhaAQV = scannerPromptInt("Nova Senha do AQV");
        System.out.println(aqvController.AtualizarAQV(idAQV,nomeAQV,loginAQV,senhaAQV));

    }
    private void Deletar(){
        int id = scannerPromptInt("Id do AQV");
        System.out.println(aqvController.DeletarAQV(id));

    }
   public void Exibir(){
       List<AqvDAO> lista = aqvController.ExibirAQV();
       for (AqvDAO aqvDAO : lista) {
           System.out.printf("ID AQV: %d | Nome AQV: %s | Login AQV: %s | Senha AQV: %s\n",
                   aqvDAO.getId(), aqvDAO.getNome(), aqvDAO.getLogin(), aqvDAO.getSenha());

   }
    }

    private int scannerPromptInt(String mensagem) {
        System.out.print(mensagem + ": ");
        return Integer.parseInt(scanner.nextLine());
    }

private String scannerPromptString(String mensagem) {
    System.out.print(mensagem + ": ");
    return scanner.nextLine();
 }

  }