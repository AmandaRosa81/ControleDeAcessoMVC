package com.senai.ProjetoControleDeAcesso.Model.DAO;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Ambiente;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AmbienteDAO {
    private final String caminho = "ambientes.json";
    private final Gson gson = new GsonBuilder()
            .create();
    private final List<Ambiente> ambienteList;

    public AmbienteDAO(){
        ambienteList = carregar();
    }

    private List<Ambiente> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<Ambiente>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar(List<Ambiente> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Ambiente ambiente) {
        String novoAmbiente = ambienteList.toString();
        ambiente.setNomeAmbiente(novoAmbiente);
        ambienteList.add(ambiente);
        salvar(ambienteList);
    }

    public void atualizar(Ambiente ambiente) {
        for (int i = 0; i < ambienteList.size(); i++) {
            if (ambienteList.get(i)
                    .getId() == horario.getId()) {
                ambienteList.set(i, horario);
                break;
            }
        }
        salvar(ambienteList);
    }

    public void remover(int id) {
        ambienteList.removeIf(h -> h.getId() == id);
        salvar(ambienteList);
    }

    public List<Ambiente> listarTodos() {
        return ambienteList;
    }
}
