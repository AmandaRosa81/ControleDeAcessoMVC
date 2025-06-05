package com.senai.ProjetoControleDeAcesso.Model.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.Justificativa;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;

import java.io.File;
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

    public void anexarJustificativa () {

        boolean seen = false;
        int best = 0;
        for (Justificativa justificativa1 : justificativas) {
            int id = Integer.parseInt(justificativa1.getId());
            if (!seen || id > best) {
                seen = true;
                best = id;
            }
        }

        salvar(justificativas);
    }

    private List<Justificativa> carregar() {
        try {
            File file = new File(caminho);
            if (!file.exists()) {
                file.createNewFile(); // Cria o arquivo se não existir
            }

            try (FileReader reader = new FileReader(file)) {
                Type listType = new TypeToken<List<Justificativa>>() {}.getType();
                return gson.fromJson(reader, listType);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo: " + e.getMessage());
            return new ArrayList<>();
        }
    }


    private void salvar(List<Justificativa> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar no arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }



    public void remover(Integer id) {
        justificativas.removeIf(j -> j.getId().equals(id));
        salvar(justificativas);
    }


    public List<Justificativa> listarTodos() {
        return justificativas;
    }


}
