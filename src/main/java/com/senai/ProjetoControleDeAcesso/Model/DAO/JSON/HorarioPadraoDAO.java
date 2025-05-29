package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.DAO.LocalTimeAdapter;
import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioPadrao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HorarioPadraoDAO {

    private final String caminho = "horarios_padrao.json";
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
            .create();
    private final List<HorarioPadrao> horariosPadrao;

    public HorarioPadraoDAO() {
        horariosPadrao = carregar();
    }

    private List<HorarioPadrao> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<HorarioPadrao>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar(List<HorarioPadrao> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserir(HorarioPadrao horario) {
        int novoId = horariosPadrao.stream().mapToInt(HorarioPadrao::getId).max().orElse(0) + 1;
        horario.setId(novoId);
        horariosPadrao.add(horario);
        salvar(horariosPadrao);
    }

    public void atualizar(HorarioPadrao horario) {
        for (int i = 0; i < horariosPadrao.size(); i++) {
            if (horariosPadrao.get(i).getId() == horario.getId()) {
                horariosPadrao.set(i, horario);
                break;
            }
        }
        salvar(horariosPadrao);
    }

    public void remover(int id) {
        horariosPadrao.removeIf(h -> h.getId() == id);
        salvar(horariosPadrao);
    }

    public List<HorarioPadrao> listarTodos() {
        return horariosPadrao;
    }
}
