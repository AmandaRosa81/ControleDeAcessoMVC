package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.UcController;
import com.senai.ProjetoControleDeAcesso.Model.Aqv;
import com.senai.ProjetoControleDeAcesso.Model.Uc;

import java.util.List;
import java.util.Scanner;

public class UcView {
    private final Scanner scanner = new Scanner(System.in);
    private final UcController controller = new UcController();

    public static void main(String[] args){
        UcView ucView = new UcView();

    }
    public void menu(){
        String opcao;
        String menuUC = """
                 -------------MENU DAS UNIDADES CURRICULARES---------------
                     1. Cadastrar UC
                     2. Atualizar Uc
                     3. Remover UC
                     4.Voltar
                ------------------------------------------------------------
                """
                do{
                    System.out.println(menuUC);
                    opcao = scanner.nextLine();

                    switch (opcao){
                        case "1" -> cadastrar();
                        case "2" -> atualizar();
                        case "3" -> remover();
                        case "4" -> listar();
                        case "0" -> System.out.println("Voltando...");
                        default -> System.out.println("Opção inválida");
                    }
                    while (!opcao.equals("0"));
                }
        private void Cadastrar(){
            String nomeUC = scannerPromptString("Id do AQV");
            int idUC = scannerPromptInt("Nome do AQV");
            int idProfessor = scannerPromptInt("Login do AQV");
            int idCurso = scannerPromptInt("Senha do AQV");
            int horarioDia = scannerPromptInt("Senha do AQV");
            int horarioSemanal = scannerPromptInt("Senha do AQV");
            System.out.println(UcController.CadastrarUC(( nomeUC,idUC, idProfessor, idCurso, horarioDia, horarioSemanal));

        }
        private void Atualizar(){
            String nomeUC = scannerPromptString("Id do AQV");
            int idUC = scannerPromptInt("Nome do AQV");
            int idProfessor = scannerPromptInt("Login do AQV");
            int idCurso = scannerPromptInt("Senha do AQV");
            int horarioDia = scannerPromptInt("Senha do AQV");
            int horarioSemanal = scannerPromptInt("Senha do AQV");
            System.out.println(UcController.AtualizarUC(nomeUC,idUC, idProfessor, idCurso, horarioDia, horarioSemanal));

        }
        private void Deletar(){
            int id = scannerPromptInt("Id do UC");
            UcController.removerUC(id);

        }
        public void Exibir(){
            List<Uc> lista = UcController.Listar();
            for (Uc UcDAO : lista) {
                System.out.printf("Nome UC: %d | Id UC: %s | Id Professor: %s | Id Curso: %s | horarioDia: %s | horarioSemanal: %s | : %s\n",
                        UcDAO.getIdUC(), UcDAO.getNomeUc(), UcDAO.getIdProfessor(), UcDAO.getIdCurso(), UcDAO.getIhorarioDia, UcDAO.getIhorarioSemanal );

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
