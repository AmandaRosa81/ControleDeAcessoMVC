package com.senai.ProjetoControleDeAcesso.Model.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

public class JustificativaDAO {

    private final String caminho = "justificativas.json";

    private final Gson gson = new GsonBuilder().create();


    private final List<Justificativa> justificativas;

    public JustificativaDAO(){justificativas = carregar();}

    private List<Justificativa> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<Justificativa>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar(List<Justificativa> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public void anexar(Justificativa justificativa) {
        int novaJustificativa = justificativas.stream().mapToInt(Justificativa::getAnexar).max().orElse(0) + 1;
        justificativa.setAnexar(novoAnexo);
        justificativas.add(justificativa);
        salvar(justificativas);
    }

    public void remover(int anexo) {
        justificativas.removeIf(a -> a.getAnexar() == anexo);
        salvar(justificativas);
    }


    public List<Justificativa> listarTodos() {
        return justificativas;
    }
}
