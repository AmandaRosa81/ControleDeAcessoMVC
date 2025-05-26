package com.senai.ProjetoControleDeAcesso.Model.DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Ocorrencia;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class OcorrenciaDAO {
    private static final String FILE_PATH = "ocorrencias.json";
    private List<Ocorrencia> ocorrencias;

    public OcorrenciaDAO(){
        ocorrencias = carregar();
    }

    private List<Ocorrencia> carregar() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Ocorrencia>>(){}.getType();
            return new Gson().fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            new Gson().toJson(ocorrencias, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void criar(Ocorrencia o) {
        ocorrencias.add(o);
        salvar();
    }

    public List<Ocorrencia> listar() {
        return ocorrencias;
    }

    public void atualizar(Ocorrencia oAtualizada) {
        for (int i = 0; i < ocorrencias.size(); i++) {
            if (ocorrencias.get(i).getId() == oAtualizada.getId()) {
                ocorrencias.set(i, oAtualizada);
                salvar();
                break;
            }
        }
    }

    public void deletar(int id) {
        ocorrencias.removeIf(o -> o.getId() == id);
        salvar();
    }

    }