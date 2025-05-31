package com.senai.ProjetoControleDeAcesso.Model.Horario;

public class HorarioAtualizado {
    private String diaSemana;
    private String horario;
    private String turma;
    private String disciplina;

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public HorarioAtualizado(String diaSemana, String horario, String turma, String disciplina) {
        this.diaSemana = diaSemana;
        this.horario = horario;
        this.turma = turma;
        this.disciplina = disciplina;


    }

    public void exibir() {
        System.out.printf("Dia: %s | Hora: %s | Turma: %s | Disciplina: %s | Professor: %s\n",
                diaSemana, horario, turma, disciplina.getNome(), disciplina.getProfessor().getNome());
    }
}
