package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

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
        int novoId = ambienteList.stream().mapToInt(Ambiente::getIdAmbiente).max().orElse(0) + 1;
        ambiente.setIdAmbiente(novoId);
        ambienteList.add(ambiente);
        salvar(ambienteList);
    }

    public void atualizar(Ambiente ambiente) {
        for (int i = 0; i < ambienteList.size(); i++) {
           if (ambienteList.get(i).getIdAmbiente() == ambiente.getIdAmbiente()) {
                ambienteList.set(i, ambiente);
                break;
            }
        }
        salvar(ambienteList);
    }

    public void remover(int id) {
        ambienteList.removeIf(a -> a.getIdAmbiente() == id);
        salvar(ambienteList);
    }

    public List<Ambiente> listarTodos() {
        return ambienteList;
    }
}
