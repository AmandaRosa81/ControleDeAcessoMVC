package com.senai.ProjetoControleDeAcesso.Model.Horario;

    public abstract class HorarioBase {
        private String diaSemana;
        private String horaInicio;
        private String horaFim;

        public HorarioBase(String diaSemana, String horaInicio, String horaFim) {
            this.diaSemana = diaSemana;
            this.horaInicio = horaInicio;
            this.horaFim = horaFim;
        }

        public String getDiaSemana() {
            return diaSemana;
        }

        public void setDiaSemana(String diaSemana) {
            this.diaSemana = diaSemana;
        }

        public String getHoraInicio() {
            return horaInicio;
        }

        public void setHoraInicio(String horaInicio) {
            this.horaInicio = horaInicio;
        }

        public String getHoraFim() {
            return horaFim;
        }

        public void setHoraFim(String horaFim) {
            this.horaFim = horaFim;
        }

        @Override
        public String toString() {
            return diaSemana + " das " + horaInicio + " às " + horaFim;
        }
    }

