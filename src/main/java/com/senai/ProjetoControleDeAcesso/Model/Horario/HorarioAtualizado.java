package com.senai.ProjetoControleDeAcesso.Model.Horario;

public class Horario {
    private String diaSemana;
    private String horario;
    private String turma;
    private String disciplina;

    public Horario(String diaSemana, String horario, String turma, String disciplina) {
        this.diaSemana = diaSemana;
        this.horario = horario;
        this.turma = turma;
        this.disciplina = disciplina;
    }

    public void ExibirGradeDeHorario() {
        System.out.printf("Dia: %s | Hora: %s | Turma: %s | Disciplina: %s | Professor: %s\n",
                diaSemana, horario, turma, disciplina.getNome(), disciplina.getProfessor().getNome());
    }
}
