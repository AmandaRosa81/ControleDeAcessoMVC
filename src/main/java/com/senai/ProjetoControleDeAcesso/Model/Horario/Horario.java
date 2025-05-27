package com.senai.ProjetoControleDeAcesso.Model.Horario;

import java.time.LocalTime;

public abstract class Horario {

        private int id;
        private int idAluno;
        private int idProfessor;
        private LocalTime hora;

        public Horario(int id, int idAluno, int idProfessor, LocalTime hora) {
            this.id = id;
            this.idAluno = idAluno;
            this.idProfessor = idProfessor;
            this.hora = hora;
        }

        // Getters e Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public int getIdAluno() { return idAluno; }
        public void setIdAluno(int idAluno) { this.idAluno = idAluno; }

        public int getIdProfessor() { return idProfessor; }
        public void setIdProfessor(int idProfessor) { this.idProfessor = idProfessor; }

        public LocalTime getHora() { return hora; }
        public void setHora(LocalTime hora) { this.hora = hora; }

        @Override
        public String toString() {
            return "Horario{" +
                    "id=" + id +
                    ", idAluno=" + idAluno +
                    ", idProfessor=" + idProfessor +
                    ", hora=" + hora +
                    '}';
        }
    }