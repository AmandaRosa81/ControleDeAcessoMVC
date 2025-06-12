package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.senai.ProjetoControleDeAcesso.Model.Aluno;
import com.senai.ProjetoControleDeAcesso.Model.Aqv;
import com.senai.ProjetoControleDeAcesso.Model.Usuario;
import com.senai.ProjetoControleDeAcesso.Model.Aluno;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlunoDAO {
    private final String caminho = "alunos.json";

    private final Gson gson = new GsonBuilder().create();


    private final List<Aluno> alunos;

    public AlunoDAO(){
        alunos = carregar();
    }

    private List<Aluno> carregar() {
        try (FileReader reader = new FileReader(caminho)) {
            Type listType = new TypeToken<List<Usuario>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void salvar(List<Aluno> lista) {
        try (FileWriter writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Aluno aluno) {
        int novoId = alunos.stream().mapToInt(Aluno::getId).max().orElse(0) + 1;
        aluno.setId(novoId);
        alunos.add(aluno);
        salvar(alunos);
    }

    public void atualizar(Aluno aluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId() == aluno.getId()) {
                alunos.set(i, aluno);
                break;
            }
        }
        salvar(alunos);
    }

    public void remover(int idAluno) {
        alunos.removeIf(a -> a.getId() == idAluno);
        salvar(alunos);
    }

     public Optional<Aluno> buscarPorIdAcesso(String idAcesso) {
        return alunos.stream().filter(a -> idAcesso.equals(a.getIdAcesso())).findFirst();
    }

    // public Optional<Aluno> buscarPorRfid(String rfid) {
        //return alunos.stream().filter(a -> rfid.equals(a.getIdCartaoRfid())).findFirst();//
    //}//

    public Optional<Aluno> buscarPorLoginESenha(String login, String senha) {
        return alunos.stream()
                .filter(a -> a.getLogin().equals(login) && a.getSenha().equals(senha))
                .findFirst();
    }

    public List<Aluno> listarTodos() {
        return alunos;
    }
    public Optional<Aluno> buscarPorLogin(String login){
        return alunos.stream().filter(a -> a.getLogin().equals(login)).findFirst();
    }

}
