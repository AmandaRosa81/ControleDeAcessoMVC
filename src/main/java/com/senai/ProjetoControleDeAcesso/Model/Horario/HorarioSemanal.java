package com.senai.ProjetoControleDeAcesso.Model.Horario;

import java.time.LocalTime;

public class HorarioSemanal extends Horario {
    private String diaSemana;

    public HorarioSemanal(int id, int idAluno, int idProfessor, LocalTime hora) {
        super(id, idAluno,idProfessor, hora);
        this.diaSemana = diaSemana;
    }
    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }
}

