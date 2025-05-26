package com.senai.ProjetoControleDeAcesso.Model.Horario;

import java.time.LocalTime;

public class HorarioBase extends Horario {

    private String diaSemana;

    public HorarioBase(int id, int idAluno, int idProfessor, LocalTime hora, String diaSemana) {
        super(id, idAluno,idProfessor, hora);
        this.diaSemana = diaSemana;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    @Override
    public String toString() {
        return super.toString() + ", diaSemana='" + diaSemana + '\'';
    }
}



