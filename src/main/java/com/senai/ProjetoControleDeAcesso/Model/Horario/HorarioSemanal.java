package com.senai.ProjetoControleDeAcesso.Model.Horario;

import java.time.LocalTime;

public class HorarioSemanal extends Horario {

    private String diaSemana;
    private LocalTime horaFim;
    private String tipo;

    public HorarioSemanal(int id, int idAluno, int idProfessor, String diaSemana, LocalTime horaInicio, LocalTime horaFim, String tipo) {
        super(id, idAluno, idProfessor, horaInicio);
        this.diaSemana = diaSemana;
        this.horaFim = horaFim;
        this.tipo = tipo;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
