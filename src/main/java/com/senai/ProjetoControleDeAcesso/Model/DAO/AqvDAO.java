package com.senai.ProjetoControleDeAcesso.Model.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Controller.AqvController;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AqvDAO  {
    private final String caminho = "aqv.json";
    private final Gson gson = new GsonBuilder().create();
    private final List<Usuario> AQV;


    public AqvDAO(){
        AQV = carregar();
    }

    private List<AQV> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<AQV>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar(List<AQV> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Usuario aqv) {
        int novoId = AQV.stream().mapToInt(Usuario::getidAQV).max().orElse(0) + 1;
        aqv.setId(novoId);
        AQV.add(aqv);
        salvar(AQV);
    }

    public void atualizar(Usuario aqv) {
        for (int i = 0; i < AQV.size(); i++) {
            if (AQV.get(i).getId() == aqv.getId()) {
                AQV.set(i, aqv);
                break;
            }
        }
        salvar(AQV);
    }

    public void remover(int id) {
        AQV.removeIf(h -> h.getId() == id);
        salvar(AQV);
    }


    public List<AQV> listarTodos() {
        return AQV;
    }
}







