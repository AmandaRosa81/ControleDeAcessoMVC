package com.senai.ProjetoControleDeAcesso.Model.DAO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Curso;
import com.senai.ProjetoControleDeAcesso.Model.Turma;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private final String caminho = "cursos.json";
    private final Gson gson = new Gson();
    private final List<Curso> cursos;

    public CursoDAO{
        cursos = carregar();
    }

    private List<Curso> carregar(){
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<Curso>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar(List<Curso> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Curso curso) {
        int novoId = cursos.stream().mapToInt(Curso::getTitulo).max().orElse(0) + 1;
        curso.setTitulo(novoId);
        cursos.add(curso);
        salvar(cursos);
    }

}
