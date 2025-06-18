package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.UcController;
import com.senai.ProjetoControleDeAcesso.Model.Aqv;
import com.senai.ProjetoControleDeAcesso.Model.DAO.JSON.UcDAO;
import com.senai.ProjetoControleDeAcesso.Model.Uc;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class UcView {
    private final Scanner scanner = new Scanner(System.in);
    private final UcController controller = new UcController();

    public static void main(String[] args){
        UcView ucView = new UcView();
        ucView.menu();

    }
    public void menu() {
        String opcao;
        String menuUC = """
                 -------------MENU DAS UNIDADES CURRICULARES---------------
                     0. Voltar
                     1. Cadastrar UC
                     2. Atualizar Uc
                     3. Remover UC
                     4. Exibir UC
                ------------------------------------------------------------
                """;
        do {
            System.out.println(menuUC);
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> Cadastrar();
                case "2" -> Atualizar();
                case "3" -> Remover();
                case "4" -> Exibir();
                case "0" -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida");
            }
        }while (!opcao.equals("0")) ;

    }
        private void Cadastrar(){
            String nomeUC = scannerPromptString("Nome da Unidade Curricular");
            int idUC = scannerPromptInt("Id da Unidade Curricular");
            int idProfessor = scannerPromptInt("Id do Professor");
            int idCurso = scannerPromptInt("Id do Curso");
            LocalTime horarioDia = scannerPromptHora("Nova hora de início (HH:mm): ");
            LocalDateTime horarioSemanal = scannerPromptHoraDate("Nova hora da semana (hh:mm)");
            System.out.println(controller.cadastrarUC( nomeUC,idUC, idProfessor, idCurso, horarioDia, horarioSemanal));

        }
        private void Atualizar(){
            String nomeUC = scannerPromptString("Nome da Unidade Curricular");
            int idUC = scannerPromptInt("Id da Unidade Curricular");
            int idProfessor = scannerPromptInt("Id do Professor");
            int idCurso = scannerPromptInt("Id do Curso");
            LocalTime horarioDia = scannerPromptHora("Nova hora de início (HH:mm): ");
            LocalDateTime horarioSemanal = scannerPromptHoraDate("Nova hora da semana (hh:mm)");
            System.out.println(controller.atualizarUC(nomeUC,idUC, idProfessor, idCurso, horarioDia, horarioSemanal));

        }
        private void Remover(){
            int id = scannerPromptInt("Id do UC");
            controller.removerUC(id);

        }
        public void Exibir(){
            List<Uc> lista = controller.Listar();
            for (Uc ucDAO : lista) {
                System.out.printf("Nome UC: %d | Id UC: %s | Id Professor: %s | Id Curso: %s | horarioDia: %s | horarioSemanal: %s | : %s\n",
                        ucDAO.getIdUC(), ucDAO.getNomeUc(), ucDAO.getIdProfessor(), ucDAO.getIdCurso(), ucDAO.getHorarioDia(), ucDAO.getHorarioSemanal());

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

    private LocalTime scannerPromptHora(String msg) {
        System.out.print(msg);
        return LocalTime.parse(scanner.nextLine());
    }
    private LocalDateTime scannerPromptHoraDate(String msg) {
        System.out.print(msg);
        return LocalDateTime.parse(scanner.nextLine());
    }

}
