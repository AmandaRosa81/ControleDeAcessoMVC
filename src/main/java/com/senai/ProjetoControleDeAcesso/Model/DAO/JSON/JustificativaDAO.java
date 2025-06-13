package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;
import com.senai.ProjetoControleDeAcesso.Model.Ocorrencia;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JustificativaDAO {

    private final String caminho = "justificativas.json";

    private final Gson gson = new GsonBuilder().create();

    private final List<Justificativa> justificativas;

    public JustificativaDAO(){
        justificativas = carregar();
    }

    private List<Justificativa> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<Justificativa>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar() {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(justificativas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cadastrar(Justificativa j) {
        justificativas.add(j);
        salvar();
    }

    public void atualizar(Justificativa jAtualizada) {
        for (int i = 0; i < justificativas.size(); i++) {
            if (justificativas.get(i).getId() == jAtualizada.getId()) {
                justificativas.set(i, jAtualizada);
                break;
            }
        }
    }

    public void remover(int id) {
        justificativas.removeIf(a -> a.getId() == id);
        salvar();
    }

    public List<Justificativa> listar() {
        return justificativas;
    }
}
