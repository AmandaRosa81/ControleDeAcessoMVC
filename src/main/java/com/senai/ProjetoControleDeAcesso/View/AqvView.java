package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.AqvController;
import com.senai.ProjetoControleDeAcesso.Model.DAO.AqvDAO;

import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class AqvView {

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
    }
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
    } while (!opcao.equals("0"));

    private void Cadastrar(){
        int idAQV = scannerPrompInt("Id do AQV");
        String nomeAQV = scannerPrompString("Nome do AQV");
        String loginAQV = scannerPrompString("Login do AQV");
        int senhaAQV = scannerPrompInt("Senha do AQV");
        System.out.println(aqvController.CadastrarAQV(idAQV,nomeAQV,loginAQV,senhaAQV));

    }
    private void Atualizar(){
        int id = scannerPrompInt("Id do AQV");
        int idAQV = scannerPrompInt("Novo Id do AQV");
        String nome = scannerPrompString("Nome do AQV");
        String nomeAQV = scannerPrompString("Novo Nome do AQV");
        int senha = scannerPrompInt("Senha do AQV");
        int senhaAQV = scannerPrompInt("Nova Senha do AQV");
        System.out.println(aqvController.CadastrarAQV(idAQV,nomeAQV,senhaAQV));

    }
    private void Deletar(){
        int id = scannerPromtInt("Id do AQV");
        System.out.println(aqvController.DeletarAQV(id));

    }
   public void Exibir(){
        for (AQV aqv : aqvController.ExibirAQV()){
       System.out.printf("ID AQV: %d | Nome AQV: %d | Login AQV: %d | Senha AQV: %s\n",
       aqv.getId(),aqv.getNome(),aqv.getLogin(),aqv.getSenha());

}

}
    private int scannerPromptInt(int id, int senha) {
        System.out.print(id,senha);
        return Integer.parseInt(scanner.nextLine());
    }
    private String scannerPromptInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine());
    }
}
