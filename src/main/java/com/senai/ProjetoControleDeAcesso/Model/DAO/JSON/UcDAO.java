package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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
    private final List<Uc> uc;


    public UcDAO() {
        uc = carregar();
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
        int novoId = this.uc.stream().mapToInt(Uc::getIdUC).max().orElse(0) + 1;
        uc.setIdUC(novoId);
        this.uc.add(uc);
        salvar(this.uc);
    }

    public void atualizar(Uc uc) {
        for (int i = 0; i < this.uc.size(); i++) {
            if (this.uc.get(i).getIdUC() == uc.getIdUC()) {
                this.uc.set(i, uc);
                break;
            }
        }
        salvar(this.uc);
    }

    public void remover(int idUC) {
        uc.removeIf(uc -> uc.getIdUC() == idUC);
        salvar(uc);
    }


    public List<Uc> listarTodos() {
        return uc;
    }

    public Optional<Uc> buscarPorid(int idUC) {
        return uc.stream().filter(uc -> uc.getIdUC() == idUC).findFirst();
    }
}
