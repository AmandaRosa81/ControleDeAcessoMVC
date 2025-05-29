package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.DAO.LocalTimeAdapter;
import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioSemanal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HorarioSemanalDAO {

    private final String caminho = "horarios_semanal.json";
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
            .create();
    private final List<HorarioSemanal> horariosSemanal;

    public HorarioSemanalDAO() {
        horariosSemanal = carregar();
    }

    private List<HorarioSemanal> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<HorarioSemanal>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar(List<HorarioSemanal> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserir(HorarioSemanal horario) {
        int novoId = horariosSemanal.stream().mapToInt(HorarioSemanal::getId).max().orElse(0) + 1;
        horario.setId(novoId);
        horariosSemanal.add(horario);
        salvar(horariosSemanal);
    }

    public void atualizar(HorarioSemanal horario) {
        for (int i = 0; i < horariosSemanal.size(); i++) {
            if (horariosSemanal.get(i).getId() == horario.getId()) {
                horariosSemanal.set(i, horario);
                break;
            }
        }
        salvar(horariosSemanal);
    }

    public void remover(int id) {
        horariosSemanal.removeIf(h -> h.getId() == id);
        salvar(horariosSemanal);
    }

    public List<HorarioSemanal> listarTodos() {
        return horariosSemanal;
    }
}
