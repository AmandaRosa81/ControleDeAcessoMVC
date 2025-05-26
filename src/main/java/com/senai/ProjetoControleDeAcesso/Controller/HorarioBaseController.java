package com.senai.ProjetoControleDeAcesso.Controller;

import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioBase;

import java.util.ArrayList;
import java.util.List;

public class HorarioBaseController <T extends HorarioBase>{
        protected List<T> horarios;

        public HorarioBaseController() {
            this.horarios = new ArrayList<>();
        }

        public void adicionarHorario(T horario) {
            horarios.add(horario);
            System.out.println("Horário adicionado com sucesso: " + horario);
        }

        public void removerHorario(int index) {
            if (index >= 0 && index < horarios.size()) {
                T removido = horarios.remove(index);
                System.out.println("Horário removido com sucesso: " + removido);
            } else {
                System.out.println("Índice inválido. Nenhum horário removido.");
            }
        }

        public void listarHorarios() {
            if (horarios.isEmpty()) {
                System.out.println("Nenhum horário cadastrado.");
            } else {
                System.out.println("Horários cadastrados:");
                for (int i = 0; i < horarios.size(); i++) {
                    System.out.println(i + ": " + horarios.get(i));
                }
            }
        }

        public List<T> getHorarios() {
            return horarios;
        }
    }
