package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.SubTurma;
import com.senai.ProjetoControleDeAcesso.Model.Turma;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SubTurmaDAO {
    private final String caminho = "subturmas.json";
    private final Gson gson = new GsonBuilder()
            .create();
    private final List<SubTurma> subTurmas;

    public SubTurmaDAO(){
        subTurmas = carregar();
    }

    private List<SubTurma> carregar(){
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<SubTurma>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar(List<SubTurma> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserir(SubTurma subTurma) {
        int novoId = subTurmas.stream().mapToInt(SubTurma::getIdSubTurma).max().orElse(0) + 1;
        subTurma.setIdSubTurma(novoId);
        subTurmas.add(subTurma);
        salvar(subTurmas);
    }

    public void atualizar(SubTurma subTurma) {
        for (int i = 0; i < subTurmas.size(); i++) {
            if (subTurmas.get(i).getIdSubTurma() == subTurma.getIdSubTurma()) {
                subTurmas.set(i, subTurma);
                break;
            }
        }
        salvar(subTurmas);
    }

    public void remover(int idSubTurma) {
        subTurmas.removeIf(a -> a.getIdSubTurma() == idSubTurma);
        salvar(subTurmas);
    }


    public List<SubTurma> listarTodos() {
        return subTurmas;
    }
}
