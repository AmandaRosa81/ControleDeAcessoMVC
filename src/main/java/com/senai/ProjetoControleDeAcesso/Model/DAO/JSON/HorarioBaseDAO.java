package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.DAO.LocalTimeAdapter;
import com.senai.ProjetoControleDeAcesso.Model.Horario.HorarioBase;



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class HorarioBaseDAO {

    private final String caminho = "horarios_base.json";
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
            .create();
    private final List<HorarioBase> horariosBase;

    public HorarioBaseDAO() {
        horariosBase = carregar();
    }

    private List<HorarioBase> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<HorarioBase>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar(List<HorarioBase> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserir(HorarioBase horario) {
        int novoId = horariosBase.stream().mapToInt(HorarioBase::getId).max().orElse(0) + 1;
        horario.setId(novoId);
        horariosBase.add(horario);
        salvar(horariosBase);
    }

    public void atualizar(HorarioBase horario) {
        for (int i = 0; i < horariosBase.size(); i++) {
            if (horariosBase.get(i).getId() == horario.getId()) {
                horariosBase.set(i, horario);
                break;
            }
        }
        salvar(horariosBase);
    }

    public void remover(int id) {
        horariosBase.removeIf(h -> h.getId() == id);
        salvar(horariosBase);
    }

    public List<HorarioBase> listarTodos() {
        return horariosBase;
    }
}

