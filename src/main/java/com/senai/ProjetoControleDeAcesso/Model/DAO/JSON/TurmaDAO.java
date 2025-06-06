package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.SubTurma;
import com.senai.ProjetoControleDeAcesso.Model.Turma;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurmaDAO {
    private final String caminho = "turmas.json";
    private final Gson gson = new GsonBuilder()
            .create();
    private final List<Turma> turmas;

    public TurmaDAO(){
        turmas = carregar();
    }

    private List<Turma> carregar(){
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<Turma>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar(List<Turma> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Turma turma) {
        int novoId = turmas.stream().mapToInt(Turma::getIdTurma).max().orElse(0) + 1;
        turma.setIdTurma(novoId);
        turmas.add(turma);
        salvar(turmas);
    }

    public void atualizar(Turma turma) {
        for (int i = 0; i < turmas.size(); i++) {
            if (turmas.get(i).getIdTurma() == turma.getIdTurma()) {
                turmas.set(i, turma);
                break;
            }
        }
        salvar(turmas);
    }

    public void remover(int idTurma) {
        turmas.removeIf(a -> a.getIdTurma() == idTurma);
        salvar(turmas);
    }

    public Optional<Turma> buscarPorId(int idTurma) {
        return turmas.stream().filter(a -> a.getIdTurma() == idTurma).findFirst();
    }

    public Optional<Turma> buscarPorAluno(Aluno aluno) {
        return turmas.stream()
                .filter(t ->
                        t.getSubturmas().stream()
                                .anyMatch(subTurma ->
                                        subTurma.getAlunos().stream()
                                                .anyMatch(a -> a.equals(aluno))
                                )
                ).findFirst();
    }

    public List<Turma> listarTodos() {
        return turmas;
    }

    public void adicionarAlunosNaSubturma(SubTurma subTurma, List<Aluno> alunos) {
        turmas.stream()
                .filter(turma ->
                        turma.getSubturmas().contains(subTurma)
                ).findFirst().flatMap(
                        turma -> turma.getSubturmas().stream()
                                .filter(
                                        s -> s.equals(subTurma)
                                ).findFirst()
                ).ifPresent(
                        s -> s.getAlunos().addAll(alunos)
                );
    }
}



























