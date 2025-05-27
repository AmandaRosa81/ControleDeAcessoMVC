package com.senai.ProjetoControleDeAcesso.Model.Horario;

import java.time.LocalTime;

public class HorarioPadrao extends Horario {
        private String diaSemana;
        private LocalTime horaFim;
        private String tipo;

        public HorarioPadrao(int id, int idAluno, int idProfessor, String diaSemana, LocalTime horaInicio, LocalTime horaFim, String tipo) {
            super(id,idAluno ,idProfessor, horaInicio);
            this.diaSemana = diaSemana;
            this.horaFim = horaFim;
            this.tipo = tipo;
        }

        public String getDiaSemana() { return diaSemana; }

        public LocalTime getHoraFim() { return horaFim; }

        public String getTipo() { return tipo; }
    }

