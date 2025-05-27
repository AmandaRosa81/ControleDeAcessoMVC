package com.senai.ProjetoControleDeAcesso.Model.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Curso;
import com.senai.ProjetoControleDeAcesso.Model.Turma;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoDAO {
    private final String caminho = "cursos.json";
    private final Gson gson = new GsonBuilder()
            .create();
    private final List<Curso> cursos;

    public CursoDAO(){
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

    public void inserir(Curso curso) {
        int novoId = cursos.stream().mapToInt(Curso::getIdCurso).max().orElse(0) + 1;
        curso.setIdCurso(novoId);
        cursos.add(curso);
        salvar(cursos);
    }

    private void salvar(List<Curso> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Curso curso) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getIdCurso() == curso.getIdCurso()) {
                cursos.set(i, curso);
                break;
            }
        }
        salvar(cursos);
    }

    public void remover(int id) {
        cursos.removeIf(a -> a.getIdCurso() == id);
        salvar(cursos);
    }

    public Optional<Curso> buscarPorId(int id) {
        return carregar().stream().filter(p -> p.getIdCurso() == id).findFirst();
    }

    public List<Curso> listarTodos() {
        return cursos;
    }
}
