package com.senai.ProjetoControleDeAcesso.Model.DAO.JSON;

import com.senai.ProjetoControleDeAcesso.Model.Aqv;
import com.senai.ProjetoControleDeAcesso.Model.Professor;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class ProfessorDAO {
        private List<Professor> professores;
        private final String FILE_PATH = "professores.json";
        private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        private List<Professor> Professores;

        private List<Professor> carregar() {
            try (FileReader reader = new FileReader(FILE_PATH)) {
                Type listType = new TypeToken<ArrayList<Professor>>(){}.getType();
                return gson.fromJson(reader, listType);
            }catch (IOException e){
                return new ArrayList<>();
            }
        }

        public ProfessorDAO (){
            professores= carregar();
        }
        public  void salvar(Professor professor){
            professores.add(professor);
            salvarJson();
        }
        public void salvarJson(){
            try(FileWriter writer = new FileWriter(FILE_PATH)){
                gson.toJson(professores,writer);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        public List<Professor> listar(){
            return professores;
        }

        public void atualizar (Professor professor){
            professores.forEach(s-> {
                if (s.getId() == professor.getId()) {
                    s.setNome(professor.getNome());
                    s.setDisciplina(professor.getDisciplina());
                    salvarJson();
                }
            });
        }
        public boolean deletar(int id) {
            Iterator<Professor> iterator = professores.iterator();
            while (iterator.hasNext()) {
                Professor p = iterator.next();
                if (p.getId() == id) {
                    iterator.remove();
                    salvarJson();
                    return true;
                }
            }
            return false;
        }
    public Optional<Professor> buscarPorLogin(String login){
        return professores.stream().filter(a -> a.getLogin().equals(login)).findFirst();
    }

    public Optional<Professor> buscarPorId(int id) {
        return carregar().stream().filter(p -> p.getId() == id).findFirst();
    }
}