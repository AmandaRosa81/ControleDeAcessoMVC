package com.senai.ProjetoControleDeAcesso.View;

import com.senai.ProjetoControleDeAcesso.Controller.TurmaController;

public class TurmaView {
    private final Scanner scanner = new Scanner(System.in);
    private final TurmaController controller = new TurmaController();

    public void menu() {
        String opcao;
        String menuTurma = """
                --- MENU DE TURMAS ---
                
                    1. Cadastrar turma
                    2. Atualizar turma
                    3. Remover turma
                    4. Listar turmas
                    0. Voltar
                    
                """;
        do {
            System.out.print(menuTurma);
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
        int idTurma = scannerPromptInt("ID da turma: ");
        String nomeTurma = String.valueOf(scannerPromptInt("Nome da turma: "));
        String curso = String.valueOf(scannerPromptInt("Nome do curso: "));
        int dataInicio = scannerPromptInt("Data do início do curso: ");
        int qtdSemanas = scannerPromptInt("Quantidade de semanas: ");
        int horarioEntrada = scannerPromptInt("Horário de entrada: ");
        String periodo = String.valueOf(scannerPromptInt("Qual o período do curso: "));
        System.out.println(controller.cadastrarTurma(idTurma, nomeTurma, curso, dataInicio, qtdSemanas, horarioEntrada, periodo));
    }

    private void atualizar() {
        int id = scannerPromptInt("ID do horário: ");
        int idAluno = scannerPromptInt("Novo ID do aluno: ");
        int idProfessor = scannerPromptInt("Novo ID do professor: ");
        LocalTime hora = scannerPromptHora("Nova hora de início (HH:mm): ");
        System.out.println(controller.atualizarHorario(id, idAluno, idProfessor, hora));
    }

    private void remover() {
        int id = scannerPromptInt("ID do horário: ");
        System.out.println(controller.removerHorario(id));
    }

    public void listar() {
        for (Horario h : controller.listarHorarios()) {
            System.out.printf("ID: %d | Aluno ID: %d | Professor ID: %d | Início: %s\n",
                    h.getId(), h.getIdAluno(), h.getIdProfessor(), h.getHoraInicio());
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
