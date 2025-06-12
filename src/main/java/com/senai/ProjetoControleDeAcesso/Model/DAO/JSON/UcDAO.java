package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Aqv;
import com.senai.ProjetoControleDeAcesso.Model.Uc;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UcDAO {
    private final String caminho = "uc.json";
    private final Gson gson = new GsonBuilder().create();
    private final List<Uc> UC;


    public UcDAO() {
        UC = carregar();
    }

    private List<Uc> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<Uc>>() {
            }.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar(List<Uc> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Uc uc) {
        int novoId = UC.stream().mapToInt(Uc::getIdUC).max().orElse(0) + 1;
        Uc.setIdUC(novoId);
        UC.add(uc);
        salvar(UC);
    }

    public void atualizar(Uc uc) {
        for (int i = 0; i < UC.size(); i++) {
            if (UC.get(i).getIdUC() == uc.getIdUC()) {
                UC.set(i, uc);
                break;
            }
        }
        salvar(UC);
    }

    public void remover(int idUC) {
        UC.removeIf(uc -> uc.getIdUC() == idUC);
        salvar(UC);
    }


    public List<Uc> listarTodos() {
        return UC;
    }

    public Optional<Uc> buscarPorid(int idUC) {
        return UC.stream().filter(uc -> uc.getIdUC() == idUC).findFirst();
    }
}
